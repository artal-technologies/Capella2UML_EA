/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Interface;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentPort;
import org.polarsys.capella.core.data.fa.OrientationPortKind;
import org.polarsys.capella.core.data.information.Port;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonComponentExchangeMapping;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class ExchangeMapping extends CommonComponentExchangeMapping<Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public ExchangeMapping(Capella2UMLAlgo algo, org.polarsys.capella.core.data.cs.Component parent,
			IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, ComponentExchange source) {
		Connector targetConnector = UMLFactory.eINSTANCE.createConnector();
		MappingUtils.generateUID(getAlgo(), source, targetConnector, this);
		targetConnector.setName(source.getName());

		Port sourcePort = source.getSourcePort();
		org.eclipse.uml2.uml.Port sourceUMLPort = (org.eclipse.uml2.uml.Port) MappingRulesManager
				.getCapellaObjectFromAllRules(sourcePort);
		Port targetPort = source.getTargetPort();
		org.eclipse.uml2.uml.Port targetUMLPort = (org.eclipse.uml2.uml.Port) MappingRulesManager
				.getCapellaObjectFromAllRules(targetPort);

		if (sourceUMLPort != null && targetUMLPort != null) {
			ConnectorEnd sourceConnectorEnd = UMLFactory.eINSTANCE.createConnectorEnd();
			sourceConnectorEnd.setRole(sourceUMLPort);

			ConnectorEnd targetConnectorEnd = UMLFactory.eINSTANCE.createConnectorEnd();
			targetConnectorEnd.setRole(targetUMLPort);

			MappingUtils.generateUID(getAlgo(), source, sourceConnectorEnd, this, "sourcePort");
			MappingUtils.generateUID(getAlgo(), source, targetConnectorEnd, this, "targetPort");

			OrientationPortKind sourceorientation = ((ComponentPort) sourcePort).getOrientation();

			if (sourceorientation == OrientationPortKind.OUT) {
				targetConnector.getEnds().add(sourceConnectorEnd);
				targetConnector.getEnds().add(targetConnectorEnd);
			} else {
				targetConnector.getEnds().add(targetConnectorEnd);
				targetConnector.getEnds().add(sourceConnectorEnd);
			}

			Component eContainer = (Component) sourceUMLPort.eContainer();
			eContainer.getOwnedConnectors().add(targetConnector);

			Set<Interface> providedInterface = new HashSet<>();
			if (!sourcePort.getProvidedInterfaces().isEmpty()) {
				providedInterface.addAll(sourcePort.getProvidedInterfaces());
			}
			if (!targetPort.getProvidedInterfaces().isEmpty()) {
				providedInterface.addAll(targetPort.getProvidedInterfaces());
			}

			for (Interface interface1 : providedInterface) {
				org.eclipse.uml2.uml.Interface interf = (org.eclipse.uml2.uml.Interface) MappingRulesManager
						.getCapellaObjectFromAllRules(interface1);
				Realization realizationTarget = UMLFactory.eINSTANCE.createRealization();
				MappingUtils.generateUID(getAlgo(), interface1, realizationTarget, this, "r");
				realizationTarget.getClients().add(interf);

				Class createClass = UMLFactory.eINSTANCE.createClass();
				realizationTarget.getSuppliers().add(createClass);

				MappingUtils.generateUID(getAlgo(), interface1, createClass, this, "pc");
				createClass.setName("ProxyConnector");

				element addElement = XMIExtensionsUtils.createElement(createClass, getAlgo().getXMIExtension());
				XMIExtensionsUtils.createProperties(addElement, false, false, "ProxyConnector", 0, "public", false,
						false);
				addElement.setClassifier(targetConnector);

				if (eaContainer instanceof StructuredClassifier) {
					org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package) ((StructuredClassifier) eaContainer)
							.getModel().getPackagedElements().get(0);
					int indexOf = pkgCapella.getPackagedElements().indexOf(interf);
					pkgCapella.getPackagedElements().add(indexOf + 1, realizationTarget);
					pkgCapella.getPackagedElements().add(createClass);
				}
				if (eaContainer instanceof Model) {
					org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package) (((Model) eaContainer)
							.getPackagedElements().get(0));
					int indexOf = pkgCapella.getPackagedElements().indexOf(interf);
					pkgCapella.getPackagedElements().add(indexOf + 1, realizationTarget);
					pkgCapella.getPackagedElements().add(createClass);
				}
			}
		}
		return targetConnector;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<ComponentExchange> _capellaSource, MappingRulesManager manager) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#getUID(
	 * org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping;
import org.eclipse.capella.mapping.capella2uml.toMove.MappingUtils;
import org.eclipse.capella.mapping.capella2uml.toMove.XMIExtensionsUtils;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.polarsys.capella.core.data.information.Port;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.XmiFactory;
import xmi.element;
import xmi.properties;

/**
 * @author binot
 *
 */
public class ExchangeMapping extends
		AbstractDynamicMapping<org.polarsys.capella.core.data.cs.Component, ComponentExchange, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public ExchangeMapping(Capella2UMLAlgo algo, org.polarsys.capella.core.data.cs.Component parent,
			IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeEAContainer(org.polarsys.capella.core.data.cs.Component capellaContainer) {

		BehavioredClassifier container = (BehavioredClassifier) MappingRulesManager
				.getCapellaObjectFromAllRules(capellaContainer);
		if (container != null) {
			return container;
		}
		Project project = ProjectExt.getProject(capellaContainer);

		return (Model) MappingRulesManager.getCapellaObjectFromAllRules(project);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeCapellaSource(java.lang.Object)
	 */
	@Override
	public List<ComponentExchange> computeCapellaSource(org.polarsys.capella.core.data.cs.Component capellaContainer) {
		// List<ComponentPort> ports =
		// capellaContainer.getOwnedFeatures().stream().filter(p -> p instanceof
		// ComponentPort)
		// .map(ComponentPort.class::cast).collect(Collectors.toList());
		// Set<ComponentExchange> exchanges = new HashSet<>();

		// for (ComponentPort componentPort : ports) {
		// EList<ComponentExchange> componentExchanges =
		// componentPort.getComponentExchanges();
		// for (ComponentExchange componentExchange : componentExchanges) {
		// if(MappingRulesManager.getCapellaObjectFromAllRules(componentExchange)==null)
		// {
		// exchanges.add(componentExchange);
		// }
		// }
		//// exchanges.addAll(componentExchanges);
		// }

		List<ComponentExchange> ownedComponentExchanges = capellaContainer.getOwnedComponentExchanges();
		// return new ArrayList<>(exchanges);
		return ownedComponentExchanges;
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
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		getAlgo().putId(targetConnector, this, sysMLID);

		targetConnector.setName(source.getName());

		Port sourcePort = source.getSourcePort();
		org.eclipse.uml2.uml.Port sourceUMLPort = (org.eclipse.uml2.uml.Port) MappingRulesManager
				.getCapellaObjectFromAllRules(sourcePort);
		Port targetPort = source.getTargetPort();
		org.eclipse.uml2.uml.Port targetUMLPort = (org.eclipse.uml2.uml.Port) MappingRulesManager
				.getCapellaObjectFromAllRules(targetPort);

		ConnectorEnd sourceConnectorEnd = UMLFactory.eINSTANCE.createConnectorEnd();
		sourceConnectorEnd.setRole(sourceUMLPort);

		ConnectorEnd targetConnectorEnd = UMLFactory.eINSTANCE.createConnectorEnd();
		targetConnectorEnd.setRole(targetUMLPort);

		String sysMLID1 = MappingUtils.getSysMLID(eResource, source);
		getAlgo().putId(sourceConnectorEnd, this, sysMLID1 + "sourcePort");

		String sysMLID2 = MappingUtils.getSysMLID(eResource, source);
		getAlgo().putId(targetConnectorEnd, this, sysMLID2 + "targetPort");

		targetConnector.getEnds().add(sourceConnectorEnd);
		targetConnector.getEnds().add(targetConnectorEnd);

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
			String sysMLID3 = MappingUtils.getSysMLID(eResource, interface1);
			getAlgo().putId(realizationTarget, this, sysMLID3 + "r");
			realizationTarget.getClients().add(interf);

			Class createClass = UMLFactory.eINSTANCE.createClass();
			realizationTarget.getSuppliers().add(createClass);
			String sysMLID4 = MappingUtils.getSysMLID(eResource, interface1);
			getAlgo().putId(createClass, this, sysMLID4 + "pc");
			createClass.setName("ProxyConnector");
			element addElement = XMIExtensionsUtils.addElement(createClass, getAlgo().getXMIExtension());
			properties createproperties = XmiFactory.eINSTANCE.createproperties();
			createproperties.setIsAbstract(false);
			createproperties.setIsLeaf(false);
			createproperties.setSType("ProxyConnector");
			createproperties.setNType(0);
			createproperties.setScope("public");
			createproperties.setIsRoot(false);
			createproperties.setIsSpecification(false);
			addElement.setProperties(createproperties);
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

		// if (eaContainer instanceof StructuredClassifier) {
		// ((StructuredClassifier)
		// eaContainer).getOwnedConnectors().add(targetConnector);
		// }
		// if (eaContainer instanceof Model) {
		// ((StructuredClassifier)
		// eaContainer).getOwnedConnectors().add(targetConnector);
		// }

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
		// TODO Auto-generated method stub

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

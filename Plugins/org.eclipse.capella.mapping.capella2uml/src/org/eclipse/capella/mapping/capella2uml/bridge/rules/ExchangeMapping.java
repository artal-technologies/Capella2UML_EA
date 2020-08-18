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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.Interface;
import org.polarsys.capella.core.data.cs.SystemComponent;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentPort;
import org.polarsys.capella.core.data.fa.OrientationPortKind;
import org.polarsys.capella.core.data.information.Port;
import org.polarsys.capella.core.data.pa.AbstractPhysicalComponent;

import com.artal.capella.mapping.CapellaUtils;
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

		Port sourcePort = source.getSourcePort();
		org.eclipse.uml2.uml.Port sourceUMLPort = (org.eclipse.uml2.uml.Port) MappingRulesManager
				.getCapellaObjectFromAllRules(sourcePort);
		Port targetPort = source.getTargetPort();
		org.eclipse.uml2.uml.Port targetUMLPort = (org.eclipse.uml2.uml.Port) MappingRulesManager
				.getCapellaObjectFromAllRules(targetPort);

		SystemComponent logicalSystemRoot = null;
		Component container = null;
		if(sourcePort.eContainer() instanceof AbstractPhysicalComponent) {
			 logicalSystemRoot = CapellaUtils.getPhysicalSystemRoot(source);
			 container = (Component) MappingRulesManager.getCapellaObjectFromAllRules(logicalSystemRoot);
		}
		else {
			 logicalSystemRoot = CapellaUtils.getLogicalSystemRoot(source);
			 container = (Component) MappingRulesManager.getCapellaObjectFromAllRules(logicalSystemRoot);
		}
		
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);

		// if ((sourcePort.eContainer() instanceof AbstractActor) ||
		// (targetPort.eContainer() instanceof AbstractActor)) {
		// Association createAssociation = UMLFactory.eINSTANCE.createAssociation();
		// MappingUtils.generateUID(getAlgo(), source, createAssociation, this);
		//
		// Object sourceComponent = /* sourcePort.eContainer() instanceof AbstractActor
		// ? */ sourcePort.eContainer()
		// /* : sourcePort */;
		// Object targetComponent = /* targetPort.eContainer() instanceof AbstractActor
		// ? */targetPort.eContainer()
		// /* : targetPort */;
		//
		// Element sourceElement = (Element)
		// MappingRulesManager.getCapellaObjectFromAllRules(sourceComponent);
		// Element targetElement = (Element)
		// MappingRulesManager.getCapellaObjectFromAllRules(targetComponent);
		//
		// Property sourceProperty = UMLFactory.eINSTANCE.createProperty();
		// MappingUtils.generateUID(getAlgo(), source, sourceProperty, this, "s");
		// Property targetProperty = UMLFactory.eINSTANCE.createProperty();
		// MappingUtils.generateUID(getAlgo(), source, targetProperty, this, "t");
		//
		// sourceProperty.setAssociation(createAssociation);
		// targetProperty.setAssociation(createAssociation);
		//
		// if (sourceElement instanceof Type) {
		// sourceProperty.setType((Type) sourceElement);
		// }
		// if (targetElement instanceof Type) {
		// targetProperty.setType((Type) targetElement);
		// }
		//
		// createAssociation.getOwnedEnds().add(sourceProperty);
		// createAssociation.getOwnedEnds().add(targetProperty);
		//
		// if (eaContainer instanceof Element) {
		// Model model = ((Element) eaContainer).getModel();
		// org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package)
		// model.getPackagedElements()
		// .get(0);
		// pkgCapella.getPackagedElements().add(createAssociation);
		// }
		//
		// Set<Interface> providedInterface = new HashSet<>();
		// if (!sourcePort.getProvidedInterfaces().isEmpty()) {
		// providedInterface.addAll(sourcePort.getProvidedInterfaces());
		// }
		// if (!targetPort.getProvidedInterfaces().isEmpty()) {
		// providedInterface.addAll(targetPort.getProvidedInterfaces());
		// }
		//
		// for (Interface interface1 : providedInterface) {
		// org.eclipse.uml2.uml.Interface interf = (org.eclipse.uml2.uml.Interface)
		// MappingRulesManager
		// .getCapellaObjectFromAllRules(interface1);
		// if (interf == null) {
		// continue;
		// }
		// Realization realizationTarget = UMLFactory.eINSTANCE.createRealization();
		// MappingUtils.generateUID(getAlgo(), interface1, realizationTarget, this,
		// "r");
		// realizationTarget.getClients().add(interf);
		//
		// Class createClass = UMLFactory.eINSTANCE.createClass();
		// realizationTarget.getSuppliers().add(createClass);
		//
		// MappingUtils.generateUID(getAlgo(), interface1, createClass, this, "pc");
		// createClass.setName("ProxyConnector");
		//
		// element addElement = XMIExtensionsUtils.createElement(createClass,
		// getAlgo().getXMIExtension());
		// CapellaElement ce = (CapellaElement) interface1;
		// if (!CapellaUtils.hasStereotype(ce)) {
		// XMIExtensionsUtils.createProperties(addElement, false, false,
		// "ProxyConnector", 0, "public", false,
		// false);
		// } else {
		// XMIExtensionsUtils.createPropertiesWithStereotype(addElement, false, false,
		// "ProxyConnector", 0,
		// "public", false, false, CapellaUtils.getSterotypeName(ce));
		// }
		// addElement.setClassifier(createAssociation);
		//
		// XMIExtensionsUtils.addConnector(realizationTarget,
		// getAlgo().getXMIExtension(), sysMLID, "Unspecified",
		// "Relization", interf, createClass, false);
		//
		// if (eaContainer instanceof StructuredClassifier) {
		// org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package)
		// ((StructuredClassifier) eaContainer)
		// .getModel().getPackagedElements().get(0);
		// int indexOf = pkgCapella.getPackagedElements().indexOf(interf);
		// pkgCapella.getPackagedElements().add(indexOf + 1, realizationTarget);
		// pkgCapella.getPackagedElements().add(createClass);
		// }
		// if (eaContainer instanceof Model) {
		// org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package)
		// (((Model) eaContainer)
		// .getPackagedElements().get(0));
		// int indexOf = pkgCapella.getPackagedElements().indexOf(interf);
		// pkgCapella.getPackagedElements().add(indexOf + 1, realizationTarget);
		// pkgCapella.getPackagedElements().add(createClass);
		// }
		// }
		//
		// return createAssociation;
		//
		// } else
		//
		// {
		Connector targetConnector = UMLFactory.eINSTANCE.createConnector();
		MappingUtils.generateUID(getAlgo(), source, targetConnector, this);
		targetConnector.setName(source.getName());
		if (sourceUMLPort != null && targetUMLPort != null) {
			ConnectorEnd sourceConnectorEnd = UMLFactory.eINSTANCE.createConnectorEnd();
			sourceConnectorEnd.setRole(sourceUMLPort);

			ConnectorEnd targetConnectorEnd = UMLFactory.eINSTANCE.createConnectorEnd();
			targetConnectorEnd.setRole(targetUMLPort);

			MappingUtils.generateUID(getAlgo(), source, sourceConnectorEnd, this, "sourcePort");
			MappingUtils.generateUID(getAlgo(), source, targetConnectorEnd, this, "targetPort");

			OrientationPortKind sourceorientation = ((ComponentPort) sourcePort).getOrientation();

			XMIExtensionsUtils.addConnector(targetConnector, getAlgo().getXMIExtension(), sysMLID, "Unspecified",
					"Assembly", sourceUMLPort, targetUMLPort, false);

			if (sourceorientation == OrientationPortKind.OUT) {
				targetConnector.getEnds().add(sourceConnectorEnd);
				targetConnector.getEnds().add(targetConnectorEnd);
			} else {
				targetConnector.getEnds().add(targetConnectorEnd);
				targetConnector.getEnds().add(sourceConnectorEnd);
			}

			if (container != null) {
				container.getOwnedConnectors().add(targetConnector);
			} else {
				Component eContainer = (Component) sourceUMLPort.eContainer();
				eContainer.getOwnedConnectors().add(targetConnector);
			}
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
				if (interf == null) {
					continue;
				}
				Realization realizationTarget = UMLFactory.eINSTANCE.createRealization();
				MappingUtils.generateUID(getAlgo(), interface1, realizationTarget, this, "r");
				realizationTarget.getClients().add(interf);

				Class createClass = UMLFactory.eINSTANCE.createClass();
				realizationTarget.getSuppliers().add(createClass);

				MappingUtils.generateUID(getAlgo(), interface1, createClass, this, "pc");
				createClass.setName("ProxyConnector");

				element addElement = XMIExtensionsUtils.createElement(createClass, getAlgo().getXMIExtension());
				CapellaElement ce = (CapellaElement) interface1;
				if (!CapellaUtils.hasStereotype(ce)) {
					XMIExtensionsUtils.createProperties(addElement, false, false, "ProxyConnector", 0, "public", false,
							false);
				} else {
					XMIExtensionsUtils.createPropertiesWithStereotype(addElement, false, false, "ProxyConnector", 0,
							"public", false, false, CapellaUtils.getSterotypeName(ce));
					
				}
				addElement.setClassifier(targetConnector);

				XMIExtensionsUtils.addConnector(realizationTarget, getAlgo().getXMIExtension(), sysMLID, "Unspecified",
						"Relization", interf, createClass, false);

				if (eaContainer instanceof StructuredClassifier) {
					org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package) ((StructuredClassifier) eaContainer)
							.getModel().getPackagedElements().get(0);
					int indexOf = pkgCapella.getPackagedElements().indexOf(interf);
					pkgCapella.getPackagedElements().add(indexOf + 1, realizationTarget);
					pkgCapella.getPackagedElements().add(createClass);
				}
				if (eaContainer instanceof Actor) {
					org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package) ((Actor) eaContainer)
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
		// }
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

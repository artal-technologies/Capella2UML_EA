/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.AbstractActor;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.SystemComponent;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentPort;
import org.polarsys.capella.core.data.pa.PhysicalComponent;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonPortMapping;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class PortMapping extends CommonPortMapping<Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public PortMapping(Capella2UMLAlgo algo, org.polarsys.capella.core.data.cs.Component parent,
			IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public List<ComponentPort> findSourceElements(Component capellaContainer) {
		List<ComponentPort> ports = capellaContainer.getOwnedFeatures().stream().filter(p -> p instanceof ComponentPort)
				.map(ComponentPort.class::cast).filter(p -> isNotActorConnection(p)).collect(Collectors.toList());
		return ports;
	}

	public boolean isNotActorConnection(ComponentPort port) {

		// EList<ComponentExchange> componentExchanges = port.getComponentExchanges();
		// for (ComponentExchange componentExchange : componentExchanges) {
		// org.polarsys.capella.core.data.information.Port sourcePort =
		// componentExchange.getSourcePort();
		// org.polarsys.capella.core.data.information.Port targetPort =
		// componentExchange.getTargetPort();
		// if (sourcePort.equals(port)) {
		// if (targetPort.eContainer() instanceof SystemComponent) {
		// return true;
		// }
		// } else {
		//
		// if (sourcePort.eContainer() instanceof SystemComponent) {
		// return true;
		// }
		//
		// }
		// }

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, ComponentPort source) {
//		 if (source.eContainer() instanceof AbstractActor) {
//		 return null;
//		 }
		Port targetPort = UMLFactory.eINSTANCE.createPort();
		MappingUtils.generateUID(getAlgo(), source, targetPort, this);
		element targetelement = XMIExtensionsUtils.createElement(targetPort, getAlgo().getXMIExtension());

		CapellaElement ce = (CapellaElement) source;
		if (CapellaUtils.hasStereotype(ce)) {
			XMIExtensionsUtils.createStereotypeProperties(targetelement, CapellaUtils.getSterotypeName(ce), "Port");
		}
		if (source.eContainer() instanceof PhysicalComponent) {
			List<String> stereoNames = new ArrayList<String>();
			stereoNames.add("Component Port");
			Resource eResource = source.eResource();
			String sysMLID = MappingUtils.getSysMLID(eResource, source);
			XMIExtensionsUtils.createStereotypeProperties(targetelement, stereoNames, "Port", sysMLID);
			SpecificUtils.applyComponentPortStereotypeAttribute(targetelement, source, targetPort);
		}

		targetPort.setName(source.getName());
		targetPort.setAggregation(AggregationKind.COMPOSITE_LITERAL);
		targetPort.setIsUnique(false);
		targetPort.setIsService(false);
		targetPort.setIsBehavior(true);
		if (eaContainer instanceof EncapsulatedClassifier) {
			((EncapsulatedClassifier) eaContainer).getOwnedPorts().add(targetPort);
		}
		if (eaContainer instanceof Actor) {
			Resource resource = (Resource) ((Actor) eaContainer).eResource();
			if (resource instanceof XMIResource) {
				SpecificUtils.addCustoRef((XMIResource) resource, (Actor) eaContainer, "ownedPort", targetPort,true,true);
			}
		}

		return targetPort;
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<ComponentPort> _capellaSource, MappingRulesManager manager) {

	}

}

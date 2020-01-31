/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.fa.ComponentPort;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class PortMapping
		extends AbstractDynamicMapping<org.polarsys.capella.core.data.cs.Component, ComponentPort, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public PortMapping(Capella2UMLAlgo algo, org.polarsys.capella.core.data.cs.Component parent,
			IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeTargetContainer(org.polarsys.capella.core.data.cs.Component capellaContainer) {
		return (BehavioredClassifier) MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeCapellaSource(java.lang.Object)
	 */
	@Override
	public List<ComponentPort> findSourceElements(org.polarsys.capella.core.data.cs.Component capellaContainer) {
		List<ComponentPort> ports = capellaContainer.getOwnedFeatures().stream().filter(p -> p instanceof ComponentPort)
				.map(ComponentPort.class::cast).collect(Collectors.toList());
		return ports;
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
		Port targetPort = UMLFactory.eINSTANCE.createPort();
		MappingUtils.generateUID(getAlgo(), source, targetPort, this);
		XMIExtensionsUtils.createElement(targetPort, getAlgo().getXMIExtension());
		targetPort.setName(source.getName());
		targetPort.setAggregation(AggregationKind.COMPOSITE_LITERAL);
		targetPort.setIsUnique(false);
		targetPort.setIsService(false);
		if (eaContainer instanceof EncapsulatedClassifier) {
			((EncapsulatedClassifier) eaContainer).getOwnedPorts().add(targetPort);

		}
		// if(eaContainer instanceof Actor) {
		// ((Actor)eaContainer).
		// }

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

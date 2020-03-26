/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.fa.ComponentPort;

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
		element targetelement=XMIExtensionsUtils.createElement(targetPort, getAlgo().getXMIExtension());
		
		CapellaElement ce = (CapellaElement)source;
		if (CapellaUtils.hasStereotype(ce)){
		 XMIExtensionsUtils.createStereotypeProperties(targetelement, CapellaUtils.getSterotypeName(ce), "Port");
		}


		
		targetPort.setName(source.getName());
		targetPort.setAggregation(AggregationKind.COMPOSITE_LITERAL);
		targetPort.setIsUnique(false);
		targetPort.setIsService(false);
		targetPort.setIsBehavior(true);
		if (eaContainer instanceof EncapsulatedClassifier) {
			((EncapsulatedClassifier) eaContainer).getOwnedPorts().add(targetPort);

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

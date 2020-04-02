/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonExchangeItemMapping;

import xmi.element;
import xmi.operation;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class AlternativeExchangeItemMapping extends CommonExchangeItemMapping<ComponentExchange, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public AlternativeExchangeItemMapping(Capella2UMLAlgo algo, ComponentExchange parent,
			IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(ComponentExchange capellaContainer) {
		return MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	@Override
	public List<ExchangeItem> findSourceElements(ComponentExchange capellaContainer) {
		List<ExchangeItem> operations = capellaContainer.getConvoyedInformations().stream()
				.map(ExchangeItem.class::cast).collect(Collectors.toList());
		return operations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#compute(java.lang.
	 * Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, ExchangeItem source) {
		Operation targetOperation = UMLFactory.eINSTANCE.createOperation();
		targetOperation.setName(source.getName());
		MappingUtils.generateUID(getAlgo(), source, targetOperation, this);

		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		List<String> stereoNames = new ArrayList<>();
		stereoNames.add("Capella");
		CapellaElement ce = (CapellaElement) source;

		element targetelement = XMIExtensionsUtils.getElementFromEObject((EObject) eaContainer,
				getAlgo().getXMIExtension());
		operation operation = XMIExtensionsUtils.createOperation(targetelement, targetOperation, stereoNames, sysMLID);

		if (CapellaUtils.hasStereotype(ce)) {
			String sterotypeName = CapellaUtils.getSterotypeName(ce);
			stereoNames.add(sterotypeName);
			XMIExtensionsUtils.createStereotypeProperties(operation, stereoNames, "Object", sysMLID);
		}

		if (eaContainer instanceof org.eclipse.uml2.uml.Interface) {
			((org.eclipse.uml2.uml.Interface) eaContainer).getOwnedOperations().add(targetOperation);
		}

		return targetOperation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#executeSubRules(java.
	 * util.List, com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<ExchangeItem> _capellaSource, MappingRulesManager manager) {

		for (ExchangeItem exchangeItem : _capellaSource) {
			OperationExchangeItemElementMapping elementMapping = new OperationExchangeItemElementMapping(getAlgo(),
					exchangeItem, getMappingExucution());
			manager.add(elementMapping.getClass().getName() + exchangeItem.getId(), elementMapping);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#getUID(org.eclipse.emf
	 * .ecore.EObject, java.lang.String)
	 */
	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

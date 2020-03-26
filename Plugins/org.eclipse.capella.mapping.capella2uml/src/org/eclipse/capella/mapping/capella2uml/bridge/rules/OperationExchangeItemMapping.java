/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.Interface;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeMechanism;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonExchangeItemMapping;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class OperationExchangeItemMapping extends
		CommonExchangeItemMapping<org.polarsys.capella.core.data.cs.Interface, org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo> {

	public OperationExchangeItemMapping(Capella2UMLAlgo algo, Interface parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(Interface capellaContainer) {
		return  MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	@Override
	public List<ExchangeItem> findSourceElements(Interface capellaContainer) {
		List<ExchangeItem> operations = capellaContainer.getExchangeItems().stream().map(ExchangeItem.class::cast)
				.filter(ei -> (ei.getExchangeMechanism() == ExchangeMechanism.OPERATION)).collect(Collectors.toList());
		return operations;
	}

	@Override
	public Object compute(Object eaContainer, ExchangeItem source) {
		Operation targetOperation = UMLFactory.eINSTANCE.createOperation();
		targetOperation.setName(source.getName());
		MappingUtils.generateUID(getAlgo(), source, targetOperation, this);
		element targetelement=XMIExtensionsUtils.createElement(targetOperation, getAlgo().getXMIExtension());

		CapellaElement ce = (CapellaElement)source;
		if (CapellaUtils.hasStereotype(ce)){
		 XMIExtensionsUtils.createStereotypeProperties(targetelement, CapellaUtils.getSterotypeName(ce), "Object");
		}

		
		if (eaContainer instanceof org.eclipse.uml2.uml.Interface) {
			((org.eclipse.uml2.uml.Interface) eaContainer).getOwnedOperations().add(targetOperation);
		}

		return targetOperation;
	}

	@Override
	public void executeSubRules(List<ExchangeItem> _capellaSource, MappingRulesManager manager) {
		for (ExchangeItem exchangeItem : _capellaSource) {
			OperationExchangeItemElementMapping elementMapping = new OperationExchangeItemElementMapping(getAlgo(),
					exchangeItem, getMappingExucution());
			manager.add(elementMapping.getClass().getName() + exchangeItem.getId(), elementMapping);
		}

	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

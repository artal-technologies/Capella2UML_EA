/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping;
import org.eclipse.capella.mapping.capella2uml.toMove.MappingUtils;
import org.eclipse.capella.mapping.capella2uml.toMove.XMIExtensionsUtils;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.Interface;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeMechanism;

import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class OperationExchangeItemMapping extends
		AbstractDynamicMapping<org.polarsys.capella.core.data.cs.Interface, ExchangeItem, org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo> {

	public OperationExchangeItemMapping(Capella2UMLAlgo algo, Interface parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object computeEAContainer(Interface capellaContainer) {
		return (org.eclipse.uml2.uml.Interface) MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	@Override
	public List<ExchangeItem> computeCapellaSource(Interface capellaContainer) {
		List<ExchangeItem> operations = capellaContainer.getExchangeItems().stream().map(ExchangeItem.class::cast)
				.filter(ei -> (ei.getExchangeMechanism() == ExchangeMechanism.OPERATION)).collect(Collectors.toList());
		return operations;
	}

	private void generateUID(CapellaElement source, EObject targetComponent) {
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		getAlgo().putId(targetComponent, this, sysMLID);
		XMIExtensionsUtils.addElement(targetComponent, getAlgo().getXMIExtension());
	}

	@Override
	public Object compute(Object eaContainer, ExchangeItem source) {
		Operation targetOperation = UMLFactory.eINSTANCE.createOperation();
		targetOperation.setName(source.getName());
		generateUID(source, targetOperation);

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

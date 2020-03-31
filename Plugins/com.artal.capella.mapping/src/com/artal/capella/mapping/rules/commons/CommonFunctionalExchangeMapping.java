/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Actor;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FaPackage;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.la.LogicalFunctionPkg;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonFunctionalExchangeMapping<SOURCE_CONTAINER extends CapellaElement, ALGO extends CapellaBridgeAlgo<?>>
		extends AbstractDynamicMapping<SOURCE_CONTAINER, org.polarsys.capella.core.data.fa.FunctionalExchange, ALGO> {

	public CommonFunctionalExchangeMapping(ALGO algo, SOURCE_CONTAINER parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object computeTargetContainer(SOURCE_CONTAINER capellaContainer) {

		return MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);

	}

	@Override
	public List<FunctionalExchange> findSourceElements(SOURCE_CONTAINER capellaContainer) {

		LogicalFunctionPkg logicalFunctionPackage = CapellaUtils.getLogicalFunctionPackage(capellaContainer);
		List<FunctionalExchange> collect = EObjectExt
				.getAll(logicalFunctionPackage, FaPackage.eINSTANCE.getFunctionalExchange()).stream()
				.map(FunctionalExchange.class::cast).collect(Collectors.toList());

		return collect;
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

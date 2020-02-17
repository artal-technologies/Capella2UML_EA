/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.uml2.uml.Model;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonExchangeItemMapping<SOURCE_CONTAINER extends CapellaElement, ALGO extends CapellaBridgeAlgo<?>>
		extends
		AbstractDynamicMapping<SOURCE_CONTAINER, org.polarsys.capella.core.data.information.ExchangeItem, ALGO> {

	public CommonExchangeItemMapping(ALGO algo, SOURCE_CONTAINER parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeTargetContainer(SOURCE_CONTAINER capellaContainer) {
		Project capellaProject = ProjectExt.getProject(capellaContainer);
		return MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
	}

	@Override
	public List<ExchangeItem> findSourceElements(SOURCE_CONTAINER capellaContainer) {
		List<ExchangeItem> eis = EObjectExt.getAll(capellaContainer, InformationPackage.Literals.EXCHANGE_ITEM).stream()
				.map(ExchangeItem.class::cast).collect(Collectors.toList());
		return eis;
	}

}

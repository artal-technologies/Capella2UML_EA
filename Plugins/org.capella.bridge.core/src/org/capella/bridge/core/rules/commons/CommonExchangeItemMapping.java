/*******************************************************************************
* Copyright (c) 2021 THALES GLOBAL SERVICES.
* All right reserved. This program and the accompanying materials are made 
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
*     Artal Technologies - initial API and implementation
*******************************************************************************/
package org.capella.bridge.core.rules.commons;

import java.util.List;
import java.util.stream.Collectors;

import org.capella.bridge.core.CapellaBridgeAlgo;
import org.capella.bridge.core.rules.AbstractDynamicMapping;
import org.capella.bridge.core.rules.MappingRulesManager;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.model.helpers.ProjectExt;

/**
 * @author Artal
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

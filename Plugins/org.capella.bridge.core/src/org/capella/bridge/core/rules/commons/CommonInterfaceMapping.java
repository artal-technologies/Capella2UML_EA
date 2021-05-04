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
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.Interface;
import org.polarsys.capella.core.data.cs.InterfacePkg;

/**
 * @author Artal
 *
 */
public abstract class CommonInterfaceMapping<ALGO extends CapellaBridgeAlgo<?>> extends
		AbstractDynamicMapping<org.polarsys.capella.core.data.cs.InterfacePkg, org.polarsys.capella.core.data.cs.Interface, ALGO> {

	public CommonInterfaceMapping(ALGO algo, InterfacePkg parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(InterfacePkg capellaContainer) {
		return MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	@Override
	public List<Interface> findSourceElements(InterfacePkg capellaContainer) {
		// List<Interface> ownedInterfaces = capellaContainer.getOwnedInterfaces();
		// return ownedInterfaces;
		List<Interface> collect = EObjectExt.getAll(capellaContainer, CsPackage.eINSTANCE.getInterface()).stream()
				.map(Interface.class::cast).collect(Collectors.toList());

		return collect;
	}

}

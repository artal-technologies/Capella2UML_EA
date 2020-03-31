/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.Interface;
import org.polarsys.capella.core.data.cs.InterfacePkg;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
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

/*******************************************************************************
* Copyright (c) 2021 THALES GLOBAL SERVICES.
* All right reserved. This program and the accompanying materials are made 
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
*     Artal Technologies - initial API and implementation
*******************************************************************************/
package org.capella.bridge.uml.ea.core.bridge.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.capella.bridge.core.MappingUtils;
import org.capella.bridge.core.rules.MappingRulesManager;
import org.capella.bridge.core.rules.commons.CommonExchangeItemMapping;
import org.capella.bridge.uml.ea.core.bridge.Capella2UMLAlgo;
import org.capella.bridge.uml.ea.core.bridge.rules.utils.SpecificUtils;
import org.capella.bridge.uml.ea.model.XMIExtensionsUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeMechanism;

/**
 * @author Artal
 *
 */
public class EventExchangeItemMapping extends CommonExchangeItemMapping<BlockArchitecture, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public EventExchangeItemMapping(Capella2UMLAlgo algo, BlockArchitecture parent,
			IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeCapellaSource(java.lang.Object)
	 */
	@Override
	public List<ExchangeItem> findSourceElements(BlockArchitecture capellaContainer) {
		List<ExchangeItem> findSourceElements = super.findSourceElements(capellaContainer);
		List<ExchangeItem> eventEIs = findSourceElements.stream()
				.filter(ei -> (ei.getExchangeMechanism() == ExchangeMechanism.EVENT)).collect(Collectors.toList());
		return eventEIs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, ExchangeItem source) {
		Signal signalTarget = UMLFactory.eINSTANCE.createSignal();
		MappingUtils.generateUID(getAlgo(), source, signalTarget, this);
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		XMIExtensionsUtils.addElement(signalTarget, getAlgo().getXMIExtension(), sysMLID, "sign");

		signalTarget.setName(source.getName());

		Object capellaObjectFromAllRules = MappingRulesManager.getCapellaObjectFromAllRules(source.eContainer());
		if (capellaObjectFromAllRules instanceof org.eclipse.uml2.uml.Package) {
			((org.eclipse.uml2.uml.Package) capellaObjectFromAllRules).getPackagedElements().add(signalTarget);
		}

		else if (eaContainer instanceof Model) {
			EList<PackageableElement> ownedMembers = ((Model) eaContainer).getPackagedElements();
			for (PackageableElement ownedMember : ownedMembers) {
				if (ownedMember.getName().equals(SpecificUtils.getCapellaImportName(this)))
					((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(signalTarget);
			}

		}

		return signalTarget;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<ExchangeItem> _capellaSource, MappingRulesManager manager) {
		for (ExchangeItem exchangeItem : _capellaSource) {
			EventExchangeItemElementMapping elementMapping = new EventExchangeItemElementMapping(getAlgo(),
					exchangeItem, getMappingExucution());
			manager.add(EventExchangeItemElementMapping.class.getName() + exchangeItem.getId(), elementMapping);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#getUID(
	 * org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

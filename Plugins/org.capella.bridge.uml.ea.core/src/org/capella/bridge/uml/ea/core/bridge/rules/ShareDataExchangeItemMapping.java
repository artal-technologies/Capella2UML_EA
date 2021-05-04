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

import org.capella.bridge.core.CapellaUtils;
import org.capella.bridge.core.MappingUtils;
import org.capella.bridge.core.rules.MappingRulesManager;
import org.capella.bridge.core.rules.commons.CommonExchangeItemMapping;
import org.capella.bridge.uml.ea.core.bridge.Capella2UMLAlgo;
import org.capella.bridge.uml.ea.core.bridge.rules.utils.SpecificUtils;
import org.capella.bridge.uml.ea.model.XMIExtensionsUtils;
import org.capella.bridge.uml.ea.model.xmi.element;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.PropertyValueGroup;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeMechanism;
import org.polarsys.capella.core.model.helpers.ProjectExt;

/**
 * @author Artal
 *
 */
public class ShareDataExchangeItemMapping extends CommonExchangeItemMapping<BlockArchitecture, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public ShareDataExchangeItemMapping(Capella2UMLAlgo algo, BlockArchitecture parent,
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
				.filter(ei -> (ei.getExchangeMechanism() == ExchangeMechanism.SHARED_DATA))
				.collect(Collectors.toList());

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
		Class classTarget = UMLFactory.eINSTANCE.createClass();
		MappingUtils.generateUID(getAlgo(), source, classTarget, this);
		classTarget.setName(source.getName());
		Object capellaObjectFromAllRules0 = MappingRulesManager.getCapellaObjectFromAllRules(source.eContainer());
		if (capellaObjectFromAllRules0 instanceof org.eclipse.uml2.uml.Package) {
			((org.eclipse.uml2.uml.Package) capellaObjectFromAllRules0).getPackagedElements().add(classTarget);
		}

		else if (eaContainer instanceof Model) {
			EList<PackageableElement> ownedMembers = ((Model) eaContainer).getPackagedElements();
			for (PackageableElement ownedMember : ownedMembers) {
				if (ownedMember.getName().equals(SpecificUtils.getCapellaImportName(this)))
					((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(classTarget);
			}
		}
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		element createElement = XMIExtensionsUtils.addElement(classTarget, getAlgo().getXMIExtension(), sysMLID,
				"entity");

		CapellaElement ce = (CapellaElement) source;
		if (CapellaUtils.hasStereotype(ce) && getAlgo().isPVMTExport()) {
			XMIExtensionsUtils.createStereotypeProperties(createElement, CapellaUtils.getSterotypeName(ce), "Entity");
			EList<PropertyValueGroup> pvgs = ce.getOwnedPropertyValueGroups();
			for (PropertyValueGroup propertyValueGroup : pvgs) {
				PropertyValuePkg propertyValuePkgFromName = SpecificUtils
						.getProfilePropertyValueGroup(ProjectExt.getProject(source), propertyValueGroup.getName());
				Profile capellaObjectFromAllRules = (Profile) MappingRulesManager
						.getCapellaObjectFromAllRules(propertyValuePkgFromName);

				Stereotype ownedStereotype = capellaObjectFromAllRules
						.getOwnedStereotype(propertyValueGroup.getName().split("\\.")[1]);

				getAlgo().getStereotypes().add(ownedStereotype);

				String typeBase = "Entity";

				Class compStereo = UMLFactory.eINSTANCE.createClass();
				SpecificUtils.createCustoStereotypeApplication((Element) eaContainer, classTarget,
						SpecificUtils.getModel(classTarget, source), propertyValueGroup, typeBase, compStereo,
						getAlgo());

			}
		}

		return classTarget;
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
			ShareDataExchangeItemElementMapping elementMapping = new ShareDataExchangeItemElementMapping(getAlgo(),
					exchangeItem, getMappingExucution());
			manager.add(elementMapping.getClass().getName() + exchangeItem.getId(), elementMapping);
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

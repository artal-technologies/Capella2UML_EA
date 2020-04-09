/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.PropertyValueGroup;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.model.helpers.ProjectExt;

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
		if (eaContainer instanceof org.eclipse.uml2.uml.Interface) {
			((org.eclipse.uml2.uml.Interface) eaContainer).getOwnedOperations().add(targetOperation);
		}
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		PhysicalArchitecture physicalArchitecture = CapellaUtils.getPhysicalArchitecture(source);
		Profile capellaObjectFromAllRules = (Profile) MappingRulesManager
				.getCapellaObjectFromAllRules(physicalArchitecture);
		Stereotype ownedStereotype = capellaObjectFromAllRules.getOwnedStereotype("Capella");
		getAlgo().getStereotypes().add(ownedStereotype);
		List<String> stereoNames = new ArrayList<>();
		stereoNames.add("Physical_Architecture::Capella");
		CapellaElement ce = (CapellaElement) source;

		element targetelement = XMIExtensionsUtils.getElementFromEObject((EObject) eaContainer,
				getAlgo().getXMIExtension());
		operation operation = XMIExtensionsUtils.createOperation(targetelement, targetOperation, stereoNames, sysMLID);
		Operation compStereo = UMLFactory.eINSTANCE.createOperation();

		XMIResource res = (XMIResource) ((Element) eaContainer).eResource();
		Model model = SpecificUtils.getModel(targetOperation,source);
		SpecificUtils.addCustoRef(res, model, "Physical_Architecture:Capella", compStereo, false, true);
		getAlgo().getStereoNames().add("Physical_Architecture:Capella");
		String sysMLID2 = MappingUtils.getSysMLID(res, targetOperation);
		if (sysMLID2 != null)
			SpecificUtils.addCustoAttr(res, compStereo, "base_Operation" /* + typeBase */, sysMLID2);

		if (CapellaUtils.hasStereotype(ce)) {
			String sterotypeName = CapellaUtils.getSterotypeName(ce);
			stereoNames.add(sterotypeName);
			XMIExtensionsUtils.createStereotypeProperties(operation, stereoNames, "Object", sysMLID);

			EList<PropertyValueGroup> pvgs = ce.getOwnedPropertyValueGroups();
			for (PropertyValueGroup propertyValueGroup : pvgs) {
				PropertyValuePkg propertyValuePkgFromName = SpecificUtils
						.getProfilePropertyValueGroup(ProjectExt.getProject(source), propertyValueGroup.getName());
				Profile capellaObjectFromAllRules2 = (Profile) MappingRulesManager
						.getCapellaObjectFromAllRules(propertyValuePkgFromName);

				Stereotype ownedStereotype2 = capellaObjectFromAllRules2
						.getOwnedStereotype(propertyValueGroup.getName().split("\\.")[1]);

				getAlgo().getStereotypes().add(ownedStereotype2);

				String typeBase = "Object";

				Operation compStereo2 = UMLFactory.eINSTANCE.createOperation();
				SpecificUtils.createCustoStereotypeApplication((Element) eaContainer, targetOperation,
						model, propertyValueGroup, typeBase, compStereo2, getAlgo());

			}
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
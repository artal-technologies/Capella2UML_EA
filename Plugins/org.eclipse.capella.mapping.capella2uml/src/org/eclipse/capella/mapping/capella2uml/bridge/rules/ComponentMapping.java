/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.PropertyValueGroup;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.SystemComponent;
import org.polarsys.capella.core.data.information.Class;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonComponentMapping;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class ComponentMapping extends CommonComponentMapping<Capella2UMLAlgo> {

	public ComponentMapping(Capella2UMLAlgo algo, CapellaElement component, IMappingExecution execution) {
		super(algo, component, execution);
	}

	@Override
	public Object compute(Object eaContainer, SystemComponent source) {
		org.eclipse.uml2.uml.Component targetComponent = UMLFactory.eINSTANCE.createComponent();

		MappingUtils.generateUID(getAlgo(), source, targetComponent, this);
		element createElement = XMIExtensionsUtils.createElement(targetComponent, getAlgo().getXMIExtension());
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		CapellaElement ce = (CapellaElement) source;

		Project project = ProjectExt.getProject(source);
		Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(project);
		Package pack = null;

		EList<PackageableElement> ownedMembers = model.getPackagedElements();
		for (PackageableElement ownedMember : ownedMembers) {
			if (ownedMember.getName().equals(SpecificUtils.getCapellaImportName(this)))
				pack = (Package) ownedMember;
			break;
		}

		targetComponent.setName(source.getName());
		if (eaContainer instanceof Model) {
			pack.getPackagedElements().add(targetComponent);
			XMIExtensionsUtils.addModel(createElement, null, pack);

		} else if (eaContainer instanceof Component) {
			((Component) eaContainer).getNestedClassifiers().add(targetComponent);
			XMIExtensionsUtils.addModel(createElement, (Component) eaContainer, pack);
		}
		List<String> stereoNames = new ArrayList<String>();
		if (CapellaUtils.hasStereotype(ce)) {
			stereoNames.addAll(CapellaUtils.getListStereotypeName(ce));
			XMIExtensionsUtils.createStereotypeProperties(createElement, stereoNames, "Component", sysMLID);

			EList<PropertyValueGroup> pvgs = ce.getOwnedPropertyValueGroups();
			for (PropertyValueGroup propertyValueGroup : pvgs) {
				PropertyValuePkg propertyValuePkgFromName = SpecificUtils
						.getProfilePropertyValueGroup(ProjectExt.getProject(source), propertyValueGroup.getName());
				Profile capellaObjectFromAllRules = (Profile) MappingRulesManager
						.getCapellaObjectFromAllRules(propertyValuePkgFromName);

				Stereotype ownedStereotype = capellaObjectFromAllRules
						.getOwnedStereotype(propertyValueGroup.getName().split("\\.")[1]);
				//
				// PropertyValueGroup stereotypePropertyValueGroup = SpecificUtils
				// .getStereotypePropertyValueGroup(ProjectExt.getProject(source),
				// propertyValueGroup.getName());

				// Object capellaObjectFromAllRules2 = MappingRulesManager
				// .getCapellaObjectFromAllRules(stereotypePropertyValueGroup);

				// model.

				SpecificUtils.applyStereotypeAttribute(propertyValueGroup, createElement, targetComponent);

				targetComponent.applyStereotype((Stereotype) ownedStereotype);
				// Capella2UMLElementOperations.applyStereotype(targetComponent,
				// ownedStereotype);
			}
		}
		if (source instanceof PhysicalComponent) {
			stereoNames.add("Physical Component");
			XMIExtensionsUtils.createStereotypeProperties(createElement, stereoNames, "Physical Component", sysMLID);

			SpecificUtils.applyPhysicalStereotypeAttribute(createElement, (PhysicalComponent) source, targetComponent);

		}
		return targetComponent;
	}

	@Override
	public void executeSubRules(List<SystemComponent> _capellaSource, MappingRulesManager manager) {
		for (SystemComponent logicalComponent : _capellaSource) {
			ComponentMapping componentMapping = new ComponentMapping(getAlgo(), logicalComponent,
					getMappingExucution());
			PortMapping portMapping = new PortMapping(getAlgo(), logicalComponent, getMappingExucution());

			manager.add(ComponentMapping.class.getName() + logicalComponent.getId(), componentMapping);
			manager.add(PortMapping.class.getName() + logicalComponent.getId(), portMapping);

			PropertyMapping propertyMapping = new PropertyMapping(getAlgo(), logicalComponent, getMappingExucution());
			manager.add(propertyMapping.getClass().getName() + logicalComponent.getId(), propertyMapping);

		}

		for (SystemComponent logicalComponent : _capellaSource) {
			AggregationMapping aggregationMapping = new AggregationMapping(getAlgo(), logicalComponent,
					getMappingExucution());
			manager.add(aggregationMapping.getClass().getName(), aggregationMapping);
		}

	}

	@Override
	public String getUID(EObject key, String id) {
		if (key instanceof org.eclipse.uml2.uml.Class) {
			return "EAID_" + id;
		} else if (key instanceof Component) {
			return "EAID_" + id;
		}
		return "";
	}

}

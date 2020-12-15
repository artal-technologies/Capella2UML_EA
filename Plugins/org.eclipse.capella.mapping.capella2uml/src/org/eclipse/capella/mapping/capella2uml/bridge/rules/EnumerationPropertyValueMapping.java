/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyType;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.XmiFactory;
import xmi.attribute;
import xmi.attributes;
import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author didier
 *
 */
public class EnumerationPropertyValueMapping
		extends AbstractDynamicMapping<PropertyValuePkg, EnumerationPropertyType, Capella2UMLAlgo> {

	public EnumerationPropertyValueMapping(Capella2UMLAlgo algo, PropertyValuePkg pvp,
			IMappingExecution mappingExecution) {
		super(algo, pvp, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeTargetContainer(PropertyValuePkg capellaContainer) {

		return getAlgo().getXMIExtension();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeCapellaSource(java.lang.Object)
	 */
	@Override
	public List<EnumerationPropertyType> findSourceElements(PropertyValuePkg capellaContainer) {

		return capellaContainer.getOwnedEnumerationPropertyTypes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * compute (java.lang.Object, java.lang.Object)
	 */
	/**
	 */
	@Override
	public Object compute(Object eaContainer, EnumerationPropertyType source) {
		org.eclipse.uml2.uml.Enumeration enumerationTarget = UMLFactory.eINSTANCE.createEnumeration();

		MappingUtils.generateUID(getAlgo(), source, enumerationTarget, this);
		// Add element
		element addElement = XMIExtensionsUtils.createElement(enumerationTarget, getAlgo().getXMIExtension());

		CapellaElement ce = (CapellaElement) source;
		if (!CapellaUtils.hasStereotype(ce)||!getAlgo().isPVMTExport()) {
			XMIExtensionsUtils.createProperties(addElement, false, false, "Enumeration", 0, "public", false, false);
		} else {
			XMIExtensionsUtils.createPropertiesWithStereotype(addElement, false, false, "Enumeration", 0, "public",
					false, false, CapellaUtils.getSterotypeName(ce));
		}

		Project project = ProjectExt.getProject(source);
		Model capellaObjectFromAllRules = (Model) MappingRulesManager.getCapellaObjectFromAllRules(project);
		EList<PackageableElement> ownedMembers = ((Model) capellaObjectFromAllRules).getPackagedElements();
		for (PackageableElement ownedMember : ownedMembers) {
			if (ownedMember.getName().equals(SpecificUtils.getCapellaImportName(this)))
				((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(enumerationTarget);
		}
		enumerationTarget.setName(source.getName());

		EList<EnumerationPropertyLiteral> ownedLiterals = source.getOwnedLiterals();
		if (ownedLiterals.size() > 1) {
			// Add attributes
			attributes attributes = XmiFactory.eINSTANCE.createattributes();

			addElement.setAttributes(attributes);
			for (EnumerationPropertyLiteral enumerationLiteral : ownedLiterals) {
				// Add attribute for each literal
				org.eclipse.uml2.uml.EnumerationLiteral createEnumerationLiteral = UMLFactory.eINSTANCE
						.createEnumerationLiteral();
				attribute attribute = XmiFactory.eINSTANCE.createattribute();
				attribute.setName(enumerationLiteral.getName());
				MappingUtils.generateUID(getAlgo(), enumerationLiteral, createEnumerationLiteral, this);
				createEnumerationLiteral.setName(enumerationLiteral.getName());
				attributes.getAttribute().add(attribute);
				enumerationTarget.getOwnedLiterals().add(createEnumerationLiteral);
				toTrace(enumerationLiteral, createEnumerationLiteral);
			}
		}

		// if (eaContainer instanceof xmi.Extension) {
		//
		// xmi.Extension extension = (xmi.Extension) eaContainer;
		// addElement.setClassifier(enumerationTarget);
		//
		// EList<Element> ownedMembers =
		// extension.getOwnedElements().add(enumerationTarget);
		// for (Element ownedMember : ownedMembers) {
		// // if (ownedMember.getName().equals("Import Capella"))
		// ((org.eclipse.uml2.uml.Package)
		// ownedMember).getPackagedElements().add(enumerationTarget);
		// }
		//
		// }
		// enumerationTarget.destroy();

		return enumerationTarget;
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<EnumerationPropertyType> _capellaSource, MappingRulesManager manager) {

	}
}

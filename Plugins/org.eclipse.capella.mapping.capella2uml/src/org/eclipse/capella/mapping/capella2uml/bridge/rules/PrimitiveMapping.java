/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.PropertyValueGroup;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.datatype.BooleanType;
import org.polarsys.capella.core.data.information.datatype.DataType;
import org.polarsys.capella.core.data.information.datatype.DatatypePackage;
import org.polarsys.capella.core.data.information.datatype.NumericType;
import org.polarsys.capella.core.data.information.datatype.PhysicalQuantity;
import org.polarsys.capella.core.data.information.datatype.StringType;
import org.polarsys.capella.core.data.information.datavalue.LiteralNumericValue;
import org.polarsys.capella.core.data.information.datavalue.NumericValue;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonDatatypeMapping;

import xmi.constraints;
import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class PrimitiveMapping extends CommonDatatypeMapping<Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public PrimitiveMapping(Capella2UMLAlgo algo, DataPkg parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	public boolean isPrimitiveType(DataType type) {
		return (type instanceof NumericType) || type instanceof StringType || type instanceof BooleanType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#findSourceElements(
	 * java.lang.Object)
	 */
	@Override
	public List<DataType> findSourceElements(DataPkg capellaContainer) {

		List<DataType> findSourceElements = super.findSourceElements(capellaContainer);
		List<DataType> primitives = findSourceElements.stream().filter(dt -> isPrimitiveType(dt))
				.collect(Collectors.toList());
		return primitives;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#compute(java.lang.
	 * Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, DataType source) {
		org.eclipse.uml2.uml.DataType targetPrimitiveType = null;

		if (source instanceof PhysicalQuantity) {
			targetPrimitiveType = UMLFactory.eINSTANCE.createDataType();
		} else {
			targetPrimitiveType = UMLFactory.eINSTANCE.createPrimitiveType();
		}

		MappingUtils.generateUID(getAlgo(), source, targetPrimitiveType, this);
		((org.eclipse.uml2.uml.Package) eaContainer).getPackagedElements().add(targetPrimitiveType);
		element createElement = XMIExtensionsUtils.createElement(targetPrimitiveType, getAlgo().getXMIExtension());

		CapellaElement ce = (CapellaElement) source;
		if (CapellaUtils.hasStereotype(ce) && getAlgo().isPVMTExport()) {
			XMIExtensionsUtils.createStereotypeProperties(createElement, CapellaUtils.getSterotypeName(ce), "DataType");
			EList<PropertyValueGroup> pvgs = ce.getOwnedPropertyValueGroups();
			for (PropertyValueGroup propertyValueGroup : pvgs) {
				PropertyValuePkg propertyValuePkgFromName = SpecificUtils
						.getProfilePropertyValueGroup(ProjectExt.getProject(source), propertyValueGroup.getName());
				Profile capellaObjectFromAllRules = (Profile) MappingRulesManager
						.getCapellaObjectFromAllRules(propertyValuePkgFromName);

				Stereotype ownedStereotype = capellaObjectFromAllRules
						.getOwnedStereotype(propertyValueGroup.getName().split("\\.")[1]);

				getAlgo().getStereotypes().add(ownedStereotype);

				String typeBase = "DataType";

				org.eclipse.uml2.uml.DataType compStereo = UMLFactory.eINSTANCE.createDataType();
				SpecificUtils.createCustoStereotypeApplication((Element) eaContainer, targetPrimitiveType,
						SpecificUtils.getModel(targetPrimitiveType,source), propertyValueGroup, typeBase, compStereo, getAlgo());

			}
		}

		targetPrimitiveType.setName(source.getName());

		constraints createConstraints = XMIExtensionsUtils.createConstraints(createElement);

		if (source instanceof NumericType) {
			NumericValue ownedMaxValue = ((NumericType) source).getOwnedMaxValue();
			if (ownedMaxValue != null && ownedMaxValue instanceof LiteralNumericValue) {
				LiteralInteger maxInteger = UMLFactory.eINSTANCE.createLiteralInteger();
				MappingUtils.generateUID(getAlgo(), ownedMaxValue, maxInteger, this);
				maxInteger.setValue(1);

				String label2 = ((LiteralNumericValue) ownedMaxValue).getValue();
				XMIExtensionsUtils.addConstraint(createConstraints, "max = " + label2, "Invariant", "0,00", "Approved");
			}

			NumericValue ownedMinValue = ((NumericType) source).getOwnedMinValue();
			if (ownedMinValue != null && ownedMinValue instanceof LiteralNumericValue) {
				LiteralInteger minInteger = UMLFactory.eINSTANCE.createLiteralInteger();
				MappingUtils.generateUID(getAlgo(), ownedMinValue, minInteger, this);
				minInteger.setValue(1);
				String label = ((LiteralNumericValue) ownedMinValue).getValue();
				XMIExtensionsUtils.addConstraint(createConstraints, "min = " + label, "Invariant", "0,00", "Approved");
			}
		}

		return targetPrimitiveType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#executeSubRules(java.
	 * util.List, com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<DataType> _capellaSource, MappingRulesManager manager) {

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

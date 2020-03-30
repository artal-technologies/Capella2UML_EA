/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.polarsys.capella.core.data.capellacore.AbstractPropertyValue;
import org.polarsys.capella.core.data.capellacore.BooleanPropertyValue;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyValue;
import org.polarsys.capella.core.data.capellacore.FloatPropertyValue;
import org.polarsys.capella.core.data.capellacore.IntegerPropertyValue;
import org.polarsys.capella.core.data.capellacore.PropertyValueGroup;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.capellacore.StringPropertyValue;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentPort;
import org.polarsys.capella.core.data.fa.ComponentPortKind;
import org.polarsys.capella.core.data.fa.OrientationPortKind;
import org.polarsys.capella.core.data.information.Port;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponentKind;
import org.polarsys.capella.core.data.pa.PhysicalComponentNature;

import com.artal.capella.mapping.MappingUtils;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class SpecificUtils {

	static public PropertyValuePkg getExtensionsPropertyValuesPkg(Project capellaProject) {

		for (PropertyValuePkg pvp : capellaProject.getOwnedPropertyValuePkgs()) {
			if (pvp.getName().equals(("EXTENSIONS"))) {
				return pvp;
			}
		}
		return null;

	}

	static public PropertyValuePkg getProfilePropertyValueGroup(Project capellaProject, String name) {

		String[] split = name.split("\\.");
		String profileName = split[0];

		PropertyValuePkg extensionsPropertyValuesPkg = getExtensionsPropertyValuesPkg(capellaProject);
		EList<PropertyValuePkg> ownedPropertyValuePkgs = extensionsPropertyValuesPkg.getOwnedPropertyValuePkgs();
		for (PropertyValuePkg propertyValuePkg : ownedPropertyValuePkgs) {
			if (propertyValuePkg.getName().equals(profileName)) {
				return propertyValuePkg;
			}
		}
		return null;
	}

	static public PropertyValueGroup getStereotypePropertyValueGroup(Project capellaProject, String name) {

		String[] split = name.split("\\.");
		String profileName = split[1];

		PropertyValuePkg extensionsPropertyValuesPkg = getExtensionsPropertyValuesPkg(capellaProject);
		EList<PropertyValuePkg> ownedPropertyValuePkgs = extensionsPropertyValuesPkg.getOwnedPropertyValuePkgs();
		for (PropertyValuePkg propertyValuePkg : ownedPropertyValuePkgs) {
			EList<PropertyValueGroup> ownedPropertyValueGroups = propertyValuePkg.getOwnedPropertyValueGroups();
			for (PropertyValueGroup propertyValueGroup : ownedPropertyValueGroups) {
				if (propertyValueGroup.getName().equals(profileName)) {
					return propertyValueGroup;
				}
			}

		}
		return null;

	}

	static public PropertyValuePkg getPropertyValuePkgFromName(Project capellaProject, String name) {

		PropertyValuePkg extensionsPropertyValuesPkg = getExtensionsPropertyValuesPkg(capellaProject);
		EList<PropertyValuePkg> ownedPropertyValuePkgs = extensionsPropertyValuesPkg.getOwnedPropertyValuePkgs();
		for (PropertyValuePkg propertyValuePkg : ownedPropertyValuePkgs) {
			EList<PropertyValueGroup> ownedPropertyValueGroups = propertyValuePkg.getOwnedPropertyValueGroups();
			for (PropertyValueGroup propertyValueGroup : ownedPropertyValueGroups) {
				if (propertyValueGroup.getName().equals(name)) {
					return propertyValuePkg;
				}
			}
		}
		return null;

	}

	static public void applyPhysicalStereotypeAttribute(element element, PhysicalComponent component,
			EObject targetComponent) {
		PhysicalComponentKind kind = component.getKind();
		XMIExtensionsUtils.addTag(element, "Kind", kind.getLiteral(), targetComponent);
		PhysicalComponentNature nature = component.getNature();
		XMIExtensionsUtils.addTag(element, "Nature", nature.getLiteral(), targetComponent);

	}

	static public void applyComponentPortStereotypeAttribute(element element, ComponentPort componentPort,
			EObject targetPort) {

		OrientationPortKind orientation = componentPort.getOrientation();
		XMIExtensionsUtils.addTag(element, "Direction", orientation.getLiteral(), targetPort);

		
		ComponentPortKind kind = componentPort.getKind();
		XMIExtensionsUtils.addTag(element, "Kind", kind.getLiteral(), targetPort);

	}

	static public void applyComponentExchangeStereotypeAttribute(element element, ComponentExchange ce,
			EObject interf) {
		Port sourcePort = ce.getSourcePort();
		Resource eResource = ce.eResource();
		String sysMLIDSource = MappingUtils.getSysMLID(eResource, sourcePort);
		
		XMIExtensionsUtils.addTag(element, "SrcCapellaID", sysMLIDSource, interf);
		
		Port targetPort = ce.getTargetPort();
		String sysMLIDTarget = MappingUtils.getSysMLID(eResource, targetPort);
		XMIExtensionsUtils.addTag(element, "TargetCapellaID", sysMLIDTarget, interf);
		
	}

	static public void applyStereotypeAttribute(PropertyValueGroup propertyValueGroup, element createElement,
			EObject eobject) {
		EList<AbstractPropertyValue> ownedPropertyValues = propertyValueGroup.getOwnedPropertyValues();
		for (AbstractPropertyValue abstractPropertyValue : ownedPropertyValues) {
			String name = abstractPropertyValue.getName();
			String value = null;
			if (abstractPropertyValue instanceof StringPropertyValue) {
				value = ((StringPropertyValue) abstractPropertyValue).getValue();
			}
			if (abstractPropertyValue instanceof BooleanPropertyValue) {
				value = ((BooleanPropertyValue) abstractPropertyValue).isValue() + "#NOTES#Values: true,false&#xA;";
			}
			if (abstractPropertyValue instanceof EnumerationPropertyValue) {

				EnumerationPropertyLiteral valueLiteral = ((EnumerationPropertyValue) abstractPropertyValue).getValue();
				if (valueLiteral != null) {
					value = valueLiteral.getFullLabel();
				}
			}
			if (abstractPropertyValue instanceof FloatPropertyValue) {
				value = "" + ((FloatPropertyValue) abstractPropertyValue).getValue();
			}
			if (abstractPropertyValue instanceof IntegerPropertyValue) {
				value = "" + ((IntegerPropertyValue) abstractPropertyValue).getValue();
			}
			XMIExtensionsUtils.addTag(createElement, name, value, eobject);
		}
	}

	//
	// static public EObject applyStereotype(Element element, Stereotype stereotype)
	// {
	//
	//
	//
	//
	//
	//
	// }
	//

}

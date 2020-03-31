/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.polarsys.capella.core.data.capellacore.AbstractPropertyValue;
import org.polarsys.capella.core.data.capellacore.BooleanPropertyValue;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyValue;
import org.polarsys.capella.core.data.capellacore.FloatPropertyValue;
import org.polarsys.capella.core.data.capellacore.IntegerPropertyValue;
import org.polarsys.capella.core.data.capellacore.PropertyValueGroup;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.capellacore.StringPropertyValue;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.AbstractActor;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.Interface;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentPort;
import org.polarsys.capella.core.data.fa.ComponentPortKind;
import org.polarsys.capella.core.data.fa.OrientationPortKind;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeMechanism;
import org.polarsys.capella.core.data.information.Port;
import org.polarsys.capella.core.data.information.datatype.BooleanType;
import org.polarsys.capella.core.data.information.datatype.Enumeration;
import org.polarsys.capella.core.data.information.datatype.NumericType;
import org.polarsys.capella.core.data.information.datatype.PhysicalQuantity;
import org.polarsys.capella.core.data.information.datatype.StringType;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponentKind;
import org.polarsys.capella.core.data.pa.PhysicalComponentNature;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;
import com.artal.capella.mapping.rules.AbstractMapping;

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

	static public String getSType(CapellaElement capellaElement) {

		if (capellaElement instanceof AbstractActor) {
			return "Actor";
		}
		if (capellaElement instanceof Component) {
			return "Component";
		}

		if (capellaElement instanceof Port) {
			return "Port";
		}
		if (capellaElement instanceof Enumeration) {
			return "Enumeration";
		}
		if (capellaElement instanceof ComponentExchange) {
			return "ProxyConnector";
		}
		if (capellaElement instanceof ExchangeItem) {
			if (((ExchangeItem) capellaElement).getExchangeMechanism() == ExchangeMechanism.SHARED_DATA) {
				return "Class";
			}
			if (((ExchangeItem) capellaElement).getExchangeMechanism() == ExchangeMechanism.EVENT) {
				return "Signal";
			}
		}
		if (capellaElement instanceof Interface) {
			return "Interface";
		}
		if (capellaElement instanceof PhysicalQuantity) {
			return "DataType";
		}
		if (capellaElement instanceof NumericType || capellaElement instanceof StringType
				|| capellaElement instanceof BooleanType) {
			return "PrimitiveType";
		}
		if (capellaElement instanceof org.polarsys.capella.core.data.information.Class) {
			return "DataType";
		}

		return null;
	}

	static public String getCapellaImportName(AbstractMapping rule) {
		AbstractMappingAlgoMix<?, CapellaBridgeAlgo<?>> mix = rule.getAlgo().getMix();
		return mix.getMixName();
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

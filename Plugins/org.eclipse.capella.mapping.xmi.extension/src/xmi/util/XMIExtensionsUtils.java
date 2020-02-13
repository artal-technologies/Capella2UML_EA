/**
 * 
 */
package xmi.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import xmi.Documentation;
import xmi.Extension;
import xmi.XmiFactory;
import xmi.attribute;
import xmi.attributes;
import xmi.connectors;
import xmi.constraint;
import xmi.constraints;
import xmi.element;
import xmi.elements;
import xmi.properties;
import xmi.stereotype;
import xmi.xrefs;

/**
 * @author binot
 *
 */
public class XMIExtensionsUtils {

	public static xmi.element createElement(EObject element, xmi.Extension extension) {
		return addElement(element, extension, null, null);
	}

	public static xmi.element addElement(EObject element, xmi.Extension extension, String ids, String name) {
		EList<elements> elements = extension.getElements();
		if (elements.size() == 0) {
			xmi.elements xmielements = XmiFactory.eINSTANCE.createelements();
			extension.getElements().add(xmielements);
		}
		xmi.elements xmiElements = extension.getElements().get(0);
		xmi.element xmielement = XmiFactory.eINSTANCE.createelement();
		xmielement.setXmiidref(element);
		xmiElements.getElement().add(xmielement);

		xrefs xrefs = XmiFactory.eINSTANCE.createxrefs();
		xmielement.setXrefs(xrefs);
		if (ids != null) {
			setXRefsValue(xrefs, ids + name, name);
		}
		return xmielement;
	}

	public static void addConnector(EObject connector, Extension extension, String ids, String direction, String type) {
		EList<connectors> connectors = extension.getConnectors();
		if (connectors.size() == 0) {
			xmi.connectors xmiconnectors = XmiFactory.eINSTANCE.createconnectors();
			extension.getConnectors().add(xmiconnectors);
		}
		xmi.connectors xmiConnectors = extension.getConnectors().get(0);
		xmi.connector xmiconnector = XmiFactory.eINSTANCE.createconnector();
		xmiconnector.setXmiidref(connector);
		xmiConnectors.getConnector().add(xmiconnector);
		xmi.properties xmiproperties = XmiFactory.eINSTANCE.createproperties();
		xmiproperties.setEa_type(type);
		xmiproperties.setDirection(direction);
		xmiconnector.setProperties(xmiproperties);

	}

	// public static void addCustomProfile(Model model) {
	// model.
	// }

	static public void setXRefsValue(xrefs xrefs, String ids, String name) {
		String value = null;
		// value = "$XREFPROP=$XID={"+ids+"}$XID;$NAM=Stereotypes$NAM;$TYP=element
		// property$TYP;$VIS=Public$VIS;$PAR=0$PAR;$DES=@STEREO;Name=sign;GUID={1D3CEB02-60D8-41c9-9D8A-168ACA9D8E5E};@ENDSTEREO;$DES;$CLT={528D2027-4A69-48e6-8F05-CE3F31EC978D}$CLT;$SUP=&lt;none&gt;$SUP;$ENDXREF;";
		value = "$XREFPROP=$XID={" + ids
				+ "}$XID;$NAM=Stereotypes$NAM;$TYP=element property$TYP;$VIS=Public$VIS;$PAR=0$PAR;$DES=@STEREO;Name="
				+ name
				+ ";GUID={25076860-6280-4441-B4D3-B21668224ABF};@ENDSTEREO;$DES;$CLT={361DF415-5446-4841-88A0-64AE880F5A6E}$CLT;$SUP=&lt;none&gt;$SUP;$ENDXREF;";

		xrefs.setValue(value);
	}

	static public void createProperties(element addElement, boolean isAbstract, boolean isLeaf, String sType, int nType,
			String scope, boolean isRoot, boolean isSpecification) {
		properties createproperties = XmiFactory.eINSTANCE.createproperties();
		createproperties.setIsAbstract(isAbstract);
		createproperties.setIsLeaf(isLeaf);
		createproperties.setSType(sType);
		createproperties.setNType(nType);
		createproperties.setScope(scope);
		createproperties.setIsRoot(isRoot);
		createproperties.setIsSpecification(isSpecification);
		addElement.setProperties(createproperties);
	}

	static public attributes createAttributes(element addElement) {
		attributes createattributes = XmiFactory.eINSTANCE.createattributes();
		addElement.setAttributes(createattributes);
		return createattributes;
	}

	static public attribute createAttribute(attributes attr, EObject enumLiteral, String name) {
		attribute createattribute = XmiFactory.eINSTANCE.createattribute();
		createattribute.setName(name);
		createattribute.setXmiidref(enumLiteral);
		attr.getAttribute().add(createattribute);
		return createattribute;
	}

	static public stereotype createStereotypeAttr(attribute attr, String stereoName) {
		stereotype createstereotype = XmiFactory.eINSTANCE.createstereotype();
		createstereotype.setStereotype(stereoName);
		attr.setStereotype(createstereotype);
		return createstereotype;
	}

	public static Documentation createEnterpriseArchitectDocumentation() {
		Documentation documentationObject = XmiFactory.eINSTANCE.createDocumentation();
		documentationObject.setExporter("Enterprise Architect");
		documentationObject.setExporterVersion("6.5");
		return documentationObject;
	}

	public static Extension createEnterpriseArchitectExtension(EObject object) {
		Extension extensionObject = XmiFactory.eINSTANCE.createExtension();
		extensionObject.setExtender("Enterprise Architect");
		extensionObject.setExtenderID("6.5");

		elements createelements = XmiFactory.eINSTANCE.createelements();
		extensionObject.getElements().add(createelements);

		element createelement = XmiFactory.eINSTANCE.createelement();
		createelement.setXmiidref(object);
		createelements.getElement().add(createelement);

		xrefs createxrefs = XmiFactory.eINSTANCE.createxrefs();
		createelement.setXrefs(createxrefs);
		return extensionObject;
	}

	public static constraints createConstraints(element elem) {
		constraints createconstraints = XmiFactory.eINSTANCE.createconstraints();

		elem.setConstraints(createconstraints);
		return createconstraints;
	}

	public static void addConstraint(constraints constrs, String name, String type, String weight, String status) {
		constraint createconstraint = XmiFactory.eINSTANCE.createconstraint();
		createconstraint.setName(name);
		createconstraint.setType(type);
		createconstraint.setWeight(weight);
		createconstraint.setStatus(status);

		constrs.getConstraint().add(createconstraint);

	}

	// static public void modifyIDRefAttributeName() {
	// EStructuralFeature eStructuralFeature =
	// XmiPackage.eINSTANCE.getelement().getEStructuralFeature("xmiidref");
	// if (eStructuralFeature != null) {
	// eStructuralFeature.setName("xmi:idref");
	// }
	// }

}

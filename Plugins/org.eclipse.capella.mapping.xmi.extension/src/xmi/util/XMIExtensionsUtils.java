/**
 * 
 */
package xmi.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import xmi.Documentation;
import xmi.Extension;
import xmi.XmiFactory;
import xmi.element;
import xmi.elements;
import xmi.properties;
import xmi.xrefs;

/**
 * @author binot
 *
 */
public class XMIExtensionsUtils {

	public static xmi.element createElement(EObject element, xmi.Extension extension) {
		return addElement(element, extension, null);
	}

	public static xmi.element addElement(EObject element, xmi.Extension extension, String ids) {
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
			setXRefsValue(xrefs, ids);
		}
		return xmielement;
	}

	// public static void addCustomProfile(Model model) {
	// model.
	// }

	static public void setXRefsValue(xrefs xrefs, String ids) {
		String value = "$XREFPROP=$XID={" + ids
				+ "}$XID;$NAM=Stereotypes$NAM;$TYP=element property$TYP;$VIS=Public$VIS;$PAR=0$PAR;$DES=@STEREO;Name=entity;GUID={25076860-6280-4441-B4D3-B21668224ABF};@ENDSTEREO;$DES;$CLT={361DF415-5446-4841-88A0-64AE880F5A6E}$CLT;$SUP=&lt;none&gt;$SUP;$ENDXREF;";

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

	// static public void modifyIDRefAttributeName() {
	// EStructuralFeature eStructuralFeature =
	// XmiPackage.eINSTANCE.getelement().getEStructuralFeature("xmiidref");
	// if (eStructuralFeature != null) {
	// eStructuralFeature.setName("xmi:idref");
	// }
	// }

}

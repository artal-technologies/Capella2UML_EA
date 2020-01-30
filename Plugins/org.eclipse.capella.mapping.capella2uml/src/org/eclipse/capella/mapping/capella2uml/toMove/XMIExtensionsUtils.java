/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.toMove;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.impl.ExtensionImpl;

import xmi.XmiFactory;
import xmi.elements;
import xmi.profiles;
import xmi.xrefs;

/**
 * @author binot
 *
 */
public class XMIExtensionsUtils {

	static public EObject createExtensionXMITag(ResourceSet rset, EPackage bookStoreEPackage,
			EFactory bookFactoryInstance) {
		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		EcorePackage theCorePackage = EcorePackage.eINSTANCE;
		EClass extensionClass = theCoreFactory.createEClass();
		extensionClass.setName("Extension");
		bookStoreEPackage.getEClassifiers().add(extensionClass);

		EAttribute extender = theCoreFactory.createEAttribute();
		extender.setName("extender");
		extender.setEType(theCorePackage.getEString());

		EAttribute extenderID = theCoreFactory.createEAttribute();
		extenderID.setName("extenderID");
		extenderID.setEType(theCorePackage.getEString());

		// elements
		EReference elementsRef = theCoreFactory.createEReference();
		elementsRef.setName("elements");
		extensionClass.getEStructuralFeatures().add(elementsRef);

		EClass elements = theCoreFactory.createEClass();
		elements.setName("elements");
		bookStoreEPackage.getEClassifiers().add(elements);

		elementsRef.setEType(elements);
		elementsRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		elementsRef.setContainment(true);

		extensionClass.getEStructuralFeatures().add(elementsRef);

		EClass element = theCoreFactory.createEClass();
		element.setName("element");
		bookStoreEPackage.getEClassifiers().add(element);

		EReference elementRef = theCoreFactory.createEReference();
		elementRef.setName("element");
		elementRef.setEType(element);
		elementRef.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		elementRef.setContainment(true);

		elements.getEStructuralFeatures().add(elementRef);

		// EReference profileReference = theCoreFactory.createEReference();
		// profileReference.setName("profiles");
		// profileReference.setEType(UMLPackage.eINSTANCE.getProfile());
		// profileReference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		// profileReference.setContainment(true);

		EReference profileReference = theCoreFactory.createEReference();
		profileReference.setName("profiles");
		profileReference.setEType(UMLPackage.eINSTANCE.getProfile());
		profileReference.setUpperBound(EStructuralFeature.UNBOUNDED_MULTIPLICITY);
		profileReference.setContainment(true);

		extensionClass.getEStructuralFeatures().add(extender);
		extensionClass.getEStructuralFeatures().add(extenderID);
		extensionClass.getEStructuralFeatures().add(profileReference);

		/*
		 * Create dynamic instance of BookStoreEClass and BookEClass
		 */
		EObject extensionObject = bookFactoryInstance.create(extensionClass);
		extensionObject.eSet(extender, "Enterprise Architect");
		extensionObject.eSet(extenderID, "6.5");

		EObject elementsObject = bookFactoryInstance.create(elements);
		EObject elementObject = bookFactoryInstance.create(element);
		EObject elementObject2 = bookFactoryInstance.create(element);

		((List) (elementsObject.eGet(elementRef))).add(elementObject);
		((List) (elementsObject.eGet(elementRef))).add(elementObject2);

		((List) (extensionObject.eGet(elementsRef))).add(elementsObject);

		// loadProfile(rset, extensionObject);

		return extensionObject;
	}

	static public EObject createDocumentationXMITag(EPackage bookStoreEPackage, EFactory bookFactoryInstance) {
		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		EcorePackage theCorePackage = EcorePackage.eINSTANCE;
		EClass documentationEclass = theCoreFactory.createEClass();
		documentationEclass.setName("Documentation");
		bookStoreEPackage.getEClassifiers().add(documentationEclass);
		EAttribute exporter = theCoreFactory.createEAttribute();
		exporter.setName("exporter");
		exporter.setEType(theCorePackage.getEString());
		EAttribute exporterVersion = theCoreFactory.createEAttribute();
		exporterVersion.setName("extenderID");
		exporterVersion.setEType(theCorePackage.getEString());
		documentationEclass.getEStructuralFeatures().add(exporter);
		documentationEclass.getEStructuralFeatures().add(exporterVersion);

		EObject documentationObject = bookFactoryInstance.create(documentationEclass);
		documentationObject.eSet(exporter, "Enterprise Architect");
		documentationObject.eSet(exporterVersion, "6.5");

		return documentationObject;

	}

	static public EPackage createXMIPackage() {
		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		EPackage bookStoreEPackage = theCoreFactory.createEPackage();
		bookStoreEPackage.setName("xmi");
		bookStoreEPackage.setNsPrefix("xmi");
		bookStoreEPackage.setNsURI("http://schema.omg.org/spec/XMI/2.1");
		return bookStoreEPackage;
	}

	static public Profile loadProfile(ResourceSet rset, xmi.Extension extensionObject) {

		Profile createProfile = UMLFactory.eINSTANCE.createProfile();
		Comment createComment = UMLFactory.eINSTANCE.createComment();
		createComment.getAnnotatedElements().add(createProfile);
		createComment.setBody("Version:1.0");
		createProfile.getOwnedComments().add(createComment);

		PackageImport pkgImport = UMLFactory.eINSTANCE.createPackageImport();
		createProfile.getPackageImports().add(pkgImport);
		// pkgImport.getImportedPackage(UMLFactory.eINSTANCE.getUMLPackage());
		Stereotype createStereotype = UMLFactory.eINSTANCE.createStereotype();
		Extension createExtension = UMLFactory.eINSTANCE.createExtension();
		createExtension.setName("A_Class_entity");

		ExtensionEnd createExtensionEnd = UMLFactory.eINSTANCE.createExtensionEnd();
		createExtensionEnd.setName("extension_entity");
		createExtensionEnd.setType(createStereotype);
		createExtensionEnd.setIsComposite(true);
		createExtensionEnd.setLower(0);
		createExtensionEnd.setUpper(1);
		createExtension.getOwnedEnds().add(createExtensionEnd);

		createStereotype.setName("entity");
		Property createProperty = UMLFactory.eINSTANCE.createProperty();
		createProperty.setName("base_Class");
		createProperty.setAssociation(createExtension);
		createStereotype.getOwnedAttributes().add(createProperty);
		DataType createDataType = UMLFactory.eINSTANCE.createDataType();
		((InternalEObject) createDataType).eSetProxyURI(URI.createURI("http://schema.omg.org/spec/UML/2.1/Class"));
		createProperty.setType(createDataType);
		createProfile.getPackagedElements().add(createStereotype);
		createProfile.getPackagedElements().add(createExtension);

		// createComment.
		createProfile.getOwnedComments().add(createComment);

		extensionObject.setProfiles(XmiFactory.eINSTANCE.createprofiles());

		extensionObject.getProfiles().setProfile(createProfile);

		// addProfile(createProfile, extensionObject);
		return createProfile;
	}

	public static void addProfile(Profile profile, EObject extensionObject) {

		EClass eClass = extensionObject.eClass();
		EList<EReference> eAllAttributes = eClass.getEReferences();
		for (EReference eAttribute : eAllAttributes) {
			if (eAttribute.getName().equals("profiles")) {
				((List) (extensionObject.eGet(eAttribute))).add(profile);
				break;
			}
		}

	}

	public static xmi.element addElement(EObject element, xmi.Extension extension) {
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

}

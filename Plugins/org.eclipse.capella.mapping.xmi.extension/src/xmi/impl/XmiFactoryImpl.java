/**
 */
package xmi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import xmi.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XmiFactoryImpl extends EFactoryImpl implements XmiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XmiFactory init() {
		try {
			XmiFactory theXmiFactory = (XmiFactory)EPackage.Registry.INSTANCE.getEFactory(XmiPackage.eNS_URI);
			if (theXmiFactory != null) {
				return theXmiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XmiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmiFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XmiPackage.EXTENSION: return createExtension();
			case XmiPackage.DOCUMENTATION: return createDocumentation();
			case XmiPackage.ELEMENTS: return createelements();
			case XmiPackage.ELEMENT: return createelement();
			case XmiPackage.XREFS: return createxrefs();
			case XmiPackage.PROFILES: return createprofiles();
			case XmiPackage.PROPERTIES: return createproperties();
			case XmiPackage.PACKAGED_ELEMENT: return createPackagedElement();
			case XmiPackage.UML_PROFILE: return createumlProfile();
			case XmiPackage.OWNED_END: return createownedEnd();
			case XmiPackage.PACKAGE_IMPORT: return createpackageImport();
			case XmiPackage.IMPORTED_PACKAGE: return createimportedPackage();
			case XmiPackage.OWNED_ATTRIBUTE: return createownedAttribute();
			case XmiPackage.TYPE: return createtype();
			case XmiPackage.ATTRIBUTES: return createattributes();
			case XmiPackage.ATTRIBUTE: return createattribute();
			case XmiPackage.EXTENDED_PROPERTIES: return createextendedProperties();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Extension createExtension() {
		ExtensionImpl extension = new ExtensionImpl();
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Documentation createDocumentation() {
		DocumentationImpl documentation = new DocumentationImpl();
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public elements createelements() {
		elementsImpl elements = new elementsImpl();
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public element createelement() {
		elementImpl element = new elementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public xrefs createxrefs() {
		xrefsImpl xrefs = new xrefsImpl();
		return xrefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public profiles createprofiles() {
		profilesImpl profiles = new profilesImpl();
		return profiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public properties createproperties() {
		propertiesImpl properties = new propertiesImpl();
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackagedElement createPackagedElement() {
		PackagedElementImpl packagedElement = new PackagedElementImpl();
		return packagedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public umlProfile createumlProfile() {
		umlProfileImpl umlProfile = new umlProfileImpl();
		return umlProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ownedEnd createownedEnd() {
		ownedEndImpl ownedEnd = new ownedEndImpl();
		return ownedEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public packageImport createpackageImport() {
		packageImportImpl packageImport = new packageImportImpl();
		return packageImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public importedPackage createimportedPackage() {
		importedPackageImpl importedPackage = new importedPackageImpl();
		return importedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ownedAttribute createownedAttribute() {
		ownedAttributeImpl ownedAttribute = new ownedAttributeImpl();
		return ownedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public type createtype() {
		typeImpl type = new typeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public attributes createattributes() {
		attributesImpl attributes = new attributesImpl();
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public attribute createattribute() {
		attributeImpl attribute = new attributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public extendedProperties createextendedProperties() {
		extendedPropertiesImpl extendedProperties = new extendedPropertiesImpl();
		return extendedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmiPackage getXmiPackage() {
		return (XmiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XmiPackage getPackage() {
		return XmiPackage.eINSTANCE;
	}

} //XmiFactoryImpl

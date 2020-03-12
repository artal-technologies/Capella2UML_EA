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
			case XmiPackage.ATTRIBUTES: return createattributes();
			case XmiPackage.ATTRIBUTE: return createattribute();
			case XmiPackage.STEREOTYPE: return createstereotype();
			case XmiPackage.CONSTRAINTS: return createconstraints();
			case XmiPackage.CONSTRAINT: return createconstraint();
			case XmiPackage.CONNECTORS: return createconnectors();
			case XmiPackage.CONNECTOR: return createconnector();
			case XmiPackage.MODEL: return createmodel();
			case XmiPackage.SOURCE: return createsource();
			case XmiPackage.TARGET: return createtarget();
			case XmiPackage.ROLE: return createrole();
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
	public stereotype createstereotype() {
		stereotypeImpl stereotype = new stereotypeImpl();
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constraints createconstraints() {
		constraintsImpl constraints = new constraintsImpl();
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constraint createconstraint() {
		constraintImpl constraint = new constraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public connectors createconnectors() {
		connectorsImpl connectors = new connectorsImpl();
		return connectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public connector createconnector() {
		connectorImpl connector = new connectorImpl();
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model createmodel() {
		modelImpl model = new modelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public source createsource() {
		sourceImpl source = new sourceImpl();
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public target createtarget() {
		targetImpl target = new targetImpl();
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public role createrole() {
		roleImpl role = new roleImpl();
		return role;
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

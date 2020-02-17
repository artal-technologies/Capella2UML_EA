/**
 */
package xmi;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see xmi.XmiFactory
 * @model kind="package"
 * @generated
 */
public interface XmiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xmi";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://schema.omg.org/spec/XMI/2.1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xmi";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XmiPackage eINSTANCE = xmi.impl.XmiPackageImpl.init();

	/**
	 * The meta object id for the '{@link xmi.impl.ExtensionImpl <em>Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.ExtensionImpl
	 * @see xmi.impl.XmiPackageImpl#getExtension()
	 * @generated
	 */
	int EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Extender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__EXTENDER = 0;

	/**
	 * The feature id for the '<em><b>Extender ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__EXTENDER_ID = 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__ELEMENTS = 2;

	/**
	 * The feature id for the '<em><b>Profiles</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__PROFILES = 3;

	/**
	 * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__CONNECTORS = 4;

	/**
	 * The number of structural features of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link xmi.impl.DocumentationImpl <em>Documentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.DocumentationImpl
	 * @see xmi.impl.XmiPackageImpl#getDocumentation()
	 * @generated
	 */
	int DOCUMENTATION = 1;

	/**
	 * The feature id for the '<em><b>Exporter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__EXPORTER = 0;

	/**
	 * The feature id for the '<em><b>Exporter Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION__EXPORTER_VERSION = 1;

	/**
	 * The number of structural features of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Documentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTATION_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link xmi.impl.elementsImpl <em>elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.elementsImpl
	 * @see xmi.impl.XmiPackageImpl#getelements()
	 * @generated
	 */
	int ELEMENTS = 2;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTS__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Test</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTS__TEST = 1;

	/**
	 * The number of structural features of the '<em>elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link xmi.impl.elementImpl <em>element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.elementImpl
	 * @see xmi.impl.XmiPackageImpl#getelement()
	 * @generated
	 */
	int ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__SCOPE = 1;

	/**
	 * The feature id for the '<em><b>Xrefs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__XREFS = 2;

	/**
	 * The feature id for the '<em><b>Xmiidref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__XMIIDREF = 3;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__CLASSIFIER = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__PROPERTIES = 5;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ATTRIBUTES = 6;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__CONSTRAINTS = 7;

	/**
	 * The feature id for the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__MODEL = 8;

	/**
	 * The number of structural features of the '<em>element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link xmi.impl.xrefsImpl <em>xrefs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.xrefsImpl
	 * @see xmi.impl.XmiPackageImpl#getxrefs()
	 * @generated
	 */
	int XREFS = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XREFS__VALUE = 0;

	/**
	 * The number of structural features of the '<em>xrefs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XREFS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>xrefs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XREFS_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link xmi.impl.profilesImpl <em>profiles</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.profilesImpl
	 * @see xmi.impl.XmiPackageImpl#getprofiles()
	 * @generated
	 */
	int PROFILES = 5;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILES__PROFILE = 0;

	/**
	 * The number of structural features of the '<em>profiles</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>profiles</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILES_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link xmi.impl.propertiesImpl <em>properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.propertiesImpl
	 * @see xmi.impl.XmiPackageImpl#getproperties()
	 * @generated
	 */
	int PROPERTIES = 6;

	/**
	 * The feature id for the '<em><b>Is Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__IS_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>SType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__STYPE = 1;

	/**
	 * The feature id for the '<em><b>NType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__NTYPE = 2;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__SCOPE = 3;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__IS_ROOT = 4;

	/**
	 * The feature id for the '<em><b>Is Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__IS_LEAF = 5;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__IS_ABSTRACT = 6;

	/**
	 * The feature id for the '<em><b>Ea type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__EA_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES__DIRECTION = 8;

	/**
	 * The number of structural features of the '<em>properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link xmi.impl.attributesImpl <em>attributes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.attributesImpl
	 * @see xmi.impl.XmiPackageImpl#getattributes()
	 * @generated
	 */
	int ATTRIBUTES = 7;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTES__ATTRIBUTE = 0;

	/**
	 * The number of structural features of the '<em>attributes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTES_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>attributes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link xmi.impl.attributeImpl <em>attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.attributeImpl
	 * @see xmi.impl.XmiPackageImpl#getattribute()
	 * @generated
	 */
	int ATTRIBUTE = 8;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__STEREOTYPE = 0;

	/**
	 * The feature id for the '<em><b>Xmiidref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__XMIIDREF = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__SCOPE = 3;

	/**
	 * The number of structural features of the '<em>attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link xmi.impl.stereotypeImpl <em>stereotype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.stereotypeImpl
	 * @see xmi.impl.XmiPackageImpl#getstereotype()
	 * @generated
	 */
	int STEREOTYPE = 9;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE__STEREOTYPE = 0;

	/**
	 * The number of structural features of the '<em>stereotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>stereotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEREOTYPE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link xmi.impl.constraintsImpl <em>constraints</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.constraintsImpl
	 * @see xmi.impl.XmiPackageImpl#getconstraints()
	 * @generated
	 */
	int CONSTRAINTS = 10;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS__CONSTRAINT = 0;

	/**
	 * The number of structural features of the '<em>constraints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>constraints</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link xmi.impl.constraintImpl <em>constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.constraintImpl
	 * @see xmi.impl.XmiPackageImpl#getconstraint()
	 * @generated
	 */
	int CONSTRAINT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__WEIGHT = 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__STATUS = 3;

	/**
	 * The number of structural features of the '<em>constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link xmi.impl.connectorsImpl <em>connectors</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.connectorsImpl
	 * @see xmi.impl.XmiPackageImpl#getconnectors()
	 * @generated
	 */
	int CONNECTORS = 12;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTORS__CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Test</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTORS__TEST = 1;

	/**
	 * The number of structural features of the '<em>connectors</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTORS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>connectors</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTORS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link xmi.impl.connectorImpl <em>connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.connectorImpl
	 * @see xmi.impl.XmiPackageImpl#getconnector()
	 * @generated
	 */
	int CONNECTOR = 13;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PROPERTIES = 0;

	/**
	 * The feature id for the '<em><b>Xmiidref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__XMIIDREF = 1;

	/**
	 * The number of structural features of the '<em>connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link xmi.impl.modelImpl <em>model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see xmi.impl.modelImpl
	 * @see xmi.impl.XmiPackageImpl#getmodel()
	 * @generated
	 */
	int MODEL = 14;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__OWNER = 1;

	/**
	 * The feature id for the '<em><b>Tpos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__TPOS = 2;

	/**
	 * The feature id for the '<em><b>Ea localid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__EA_LOCALID = 3;

	/**
	 * The feature id for the '<em><b>Ea eletype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__EA_ELETYPE = 4;

	/**
	 * The number of structural features of the '<em>model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link xmi.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension</em>'.
	 * @see xmi.Extension
	 * @generated
	 */
	EClass getExtension();

	/**
	 * Returns the meta object for the attribute '{@link xmi.Extension#getExtender <em>Extender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extender</em>'.
	 * @see xmi.Extension#getExtender()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_Extender();

	/**
	 * Returns the meta object for the attribute '{@link xmi.Extension#getExtenderID <em>Extender ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extender ID</em>'.
	 * @see xmi.Extension#getExtenderID()
	 * @see #getExtension()
	 * @generated
	 */
	EAttribute getExtension_ExtenderID();

	/**
	 * Returns the meta object for the containment reference list '{@link xmi.Extension#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see xmi.Extension#getElements()
	 * @see #getExtension()
	 * @generated
	 */
	EReference getExtension_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link xmi.Extension#getProfiles <em>Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Profiles</em>'.
	 * @see xmi.Extension#getProfiles()
	 * @see #getExtension()
	 * @generated
	 */
	EReference getExtension_Profiles();

	/**
	 * Returns the meta object for the containment reference list '{@link xmi.Extension#getConnectors <em>Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connectors</em>'.
	 * @see xmi.Extension#getConnectors()
	 * @see #getExtension()
	 * @generated
	 */
	EReference getExtension_Connectors();

	/**
	 * Returns the meta object for class '{@link xmi.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documentation</em>'.
	 * @see xmi.Documentation
	 * @generated
	 */
	EClass getDocumentation();

	/**
	 * Returns the meta object for the attribute '{@link xmi.Documentation#getExporter <em>Exporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exporter</em>'.
	 * @see xmi.Documentation#getExporter()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_Exporter();

	/**
	 * Returns the meta object for the attribute '{@link xmi.Documentation#getExporterVersion <em>Exporter Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exporter Version</em>'.
	 * @see xmi.Documentation#getExporterVersion()
	 * @see #getDocumentation()
	 * @generated
	 */
	EAttribute getDocumentation_ExporterVersion();

	/**
	 * Returns the meta object for class '{@link xmi.elements <em>elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>elements</em>'.
	 * @see xmi.elements
	 * @generated
	 */
	EClass getelements();

	/**
	 * Returns the meta object for the containment reference list '{@link xmi.elements#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element</em>'.
	 * @see xmi.elements#getElement()
	 * @see #getelements()
	 * @generated
	 */
	EReference getelements_Element();

	/**
	 * Returns the meta object for the reference list '{@link xmi.elements#getTest <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Test</em>'.
	 * @see xmi.elements#getTest()
	 * @see #getelements()
	 * @generated
	 */
	EReference getelements_Test();

	/**
	 * Returns the meta object for class '{@link xmi.element <em>element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>element</em>'.
	 * @see xmi.element
	 * @generated
	 */
	EClass getelement();

	/**
	 * Returns the meta object for the attribute '{@link xmi.element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see xmi.element#getName()
	 * @see #getelement()
	 * @generated
	 */
	EAttribute getelement_Name();

	/**
	 * Returns the meta object for the attribute '{@link xmi.element#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see xmi.element#getScope()
	 * @see #getelement()
	 * @generated
	 */
	EAttribute getelement_Scope();

	/**
	 * Returns the meta object for the containment reference '{@link xmi.element#getXrefs <em>Xrefs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Xrefs</em>'.
	 * @see xmi.element#getXrefs()
	 * @see #getelement()
	 * @generated
	 */
	EReference getelement_Xrefs();

	/**
	 * Returns the meta object for the reference '{@link xmi.element#getXmiidref <em>Xmiidref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Xmiidref</em>'.
	 * @see xmi.element#getXmiidref()
	 * @see #getelement()
	 * @generated
	 */
	EReference getelement_Xmiidref();

	/**
	 * Returns the meta object for the reference '{@link xmi.element#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Classifier</em>'.
	 * @see xmi.element#getClassifier()
	 * @see #getelement()
	 * @generated
	 */
	EReference getelement_Classifier();

	/**
	 * Returns the meta object for the containment reference '{@link xmi.element#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Properties</em>'.
	 * @see xmi.element#getProperties()
	 * @see #getelement()
	 * @generated
	 */
	EReference getelement_Properties();

	/**
	 * Returns the meta object for the containment reference '{@link xmi.element#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attributes</em>'.
	 * @see xmi.element#getAttributes()
	 * @see #getelement()
	 * @generated
	 */
	EReference getelement_Attributes();

	/**
	 * Returns the meta object for the containment reference '{@link xmi.element#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Constraints</em>'.
	 * @see xmi.element#getConstraints()
	 * @see #getelement()
	 * @generated
	 */
	EReference getelement_Constraints();

	/**
	 * Returns the meta object for the containment reference '{@link xmi.element#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model</em>'.
	 * @see xmi.element#getModel()
	 * @see #getelement()
	 * @generated
	 */
	EReference getelement_Model();

	/**
	 * Returns the meta object for class '{@link xmi.xrefs <em>xrefs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>xrefs</em>'.
	 * @see xmi.xrefs
	 * @generated
	 */
	EClass getxrefs();

	/**
	 * Returns the meta object for the attribute '{@link xmi.xrefs#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see xmi.xrefs#getValue()
	 * @see #getxrefs()
	 * @generated
	 */
	EAttribute getxrefs_Value();

	/**
	 * Returns the meta object for class '{@link xmi.profiles <em>profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>profiles</em>'.
	 * @see xmi.profiles
	 * @generated
	 */
	EClass getprofiles();

	/**
	 * Returns the meta object for the containment reference '{@link xmi.profiles#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Profile</em>'.
	 * @see xmi.profiles#getProfile()
	 * @see #getprofiles()
	 * @generated
	 */
	EReference getprofiles_Profile();

	/**
	 * Returns the meta object for class '{@link xmi.properties <em>properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>properties</em>'.
	 * @see xmi.properties
	 * @generated
	 */
	EClass getproperties();

	/**
	 * Returns the meta object for the attribute '{@link xmi.properties#isIsSpecification <em>Is Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Specification</em>'.
	 * @see xmi.properties#isIsSpecification()
	 * @see #getproperties()
	 * @generated
	 */
	EAttribute getproperties_IsSpecification();

	/**
	 * Returns the meta object for the attribute '{@link xmi.properties#getSType <em>SType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SType</em>'.
	 * @see xmi.properties#getSType()
	 * @see #getproperties()
	 * @generated
	 */
	EAttribute getproperties_SType();

	/**
	 * Returns the meta object for the attribute '{@link xmi.properties#getNType <em>NType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>NType</em>'.
	 * @see xmi.properties#getNType()
	 * @see #getproperties()
	 * @generated
	 */
	EAttribute getproperties_NType();

	/**
	 * Returns the meta object for the attribute '{@link xmi.properties#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see xmi.properties#getScope()
	 * @see #getproperties()
	 * @generated
	 */
	EAttribute getproperties_Scope();

	/**
	 * Returns the meta object for the attribute '{@link xmi.properties#isIsRoot <em>Is Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Root</em>'.
	 * @see xmi.properties#isIsRoot()
	 * @see #getproperties()
	 * @generated
	 */
	EAttribute getproperties_IsRoot();

	/**
	 * Returns the meta object for the attribute '{@link xmi.properties#isIsLeaf <em>Is Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Leaf</em>'.
	 * @see xmi.properties#isIsLeaf()
	 * @see #getproperties()
	 * @generated
	 */
	EAttribute getproperties_IsLeaf();

	/**
	 * Returns the meta object for the attribute '{@link xmi.properties#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see xmi.properties#isIsAbstract()
	 * @see #getproperties()
	 * @generated
	 */
	EAttribute getproperties_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link xmi.properties#getEa_type <em>Ea type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ea type</em>'.
	 * @see xmi.properties#getEa_type()
	 * @see #getproperties()
	 * @generated
	 */
	EAttribute getproperties_Ea_type();

	/**
	 * Returns the meta object for the attribute '{@link xmi.properties#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see xmi.properties#getDirection()
	 * @see #getproperties()
	 * @generated
	 */
	EAttribute getproperties_Direction();

	/**
	 * Returns the meta object for class '{@link xmi.attributes <em>attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>attributes</em>'.
	 * @see xmi.attributes
	 * @generated
	 */
	EClass getattributes();

	/**
	 * Returns the meta object for the containment reference list '{@link xmi.attributes#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attribute</em>'.
	 * @see xmi.attributes#getAttribute()
	 * @see #getattributes()
	 * @generated
	 */
	EReference getattributes_Attribute();

	/**
	 * Returns the meta object for class '{@link xmi.attribute <em>attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>attribute</em>'.
	 * @see xmi.attribute
	 * @generated
	 */
	EClass getattribute();

	/**
	 * Returns the meta object for the containment reference '{@link xmi.attribute#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Stereotype</em>'.
	 * @see xmi.attribute#getStereotype()
	 * @see #getattribute()
	 * @generated
	 */
	EReference getattribute_Stereotype();

	/**
	 * Returns the meta object for the reference '{@link xmi.attribute#getXmiidref <em>Xmiidref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Xmiidref</em>'.
	 * @see xmi.attribute#getXmiidref()
	 * @see #getattribute()
	 * @generated
	 */
	EReference getattribute_Xmiidref();

	/**
	 * Returns the meta object for the attribute '{@link xmi.attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see xmi.attribute#getName()
	 * @see #getattribute()
	 * @generated
	 */
	EAttribute getattribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link xmi.attribute#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see xmi.attribute#getScope()
	 * @see #getattribute()
	 * @generated
	 */
	EAttribute getattribute_Scope();

	/**
	 * Returns the meta object for class '{@link xmi.stereotype <em>stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>stereotype</em>'.
	 * @see xmi.stereotype
	 * @generated
	 */
	EClass getstereotype();

	/**
	 * Returns the meta object for the attribute '{@link xmi.stereotype#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see xmi.stereotype#getStereotype()
	 * @see #getstereotype()
	 * @generated
	 */
	EAttribute getstereotype_Stereotype();

	/**
	 * Returns the meta object for class '{@link xmi.constraints <em>constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>constraints</em>'.
	 * @see xmi.constraints
	 * @generated
	 */
	EClass getconstraints();

	/**
	 * Returns the meta object for the containment reference list '{@link xmi.constraints#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraint</em>'.
	 * @see xmi.constraints#getConstraint()
	 * @see #getconstraints()
	 * @generated
	 */
	EReference getconstraints_Constraint();

	/**
	 * Returns the meta object for class '{@link xmi.constraint <em>constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>constraint</em>'.
	 * @see xmi.constraint
	 * @generated
	 */
	EClass getconstraint();

	/**
	 * Returns the meta object for the attribute '{@link xmi.constraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see xmi.constraint#getName()
	 * @see #getconstraint()
	 * @generated
	 */
	EAttribute getconstraint_Name();

	/**
	 * Returns the meta object for the attribute '{@link xmi.constraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see xmi.constraint#getType()
	 * @see #getconstraint()
	 * @generated
	 */
	EAttribute getconstraint_Type();

	/**
	 * Returns the meta object for the attribute '{@link xmi.constraint#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see xmi.constraint#getWeight()
	 * @see #getconstraint()
	 * @generated
	 */
	EAttribute getconstraint_Weight();

	/**
	 * Returns the meta object for the attribute '{@link xmi.constraint#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see xmi.constraint#getStatus()
	 * @see #getconstraint()
	 * @generated
	 */
	EAttribute getconstraint_Status();

	/**
	 * Returns the meta object for class '{@link xmi.connectors <em>connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>connectors</em>'.
	 * @see xmi.connectors
	 * @generated
	 */
	EClass getconnectors();

	/**
	 * Returns the meta object for the containment reference list '{@link xmi.connectors#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector</em>'.
	 * @see xmi.connectors#getConnector()
	 * @see #getconnectors()
	 * @generated
	 */
	EReference getconnectors_Connector();

	/**
	 * Returns the meta object for the reference list '{@link xmi.connectors#getTest <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Test</em>'.
	 * @see xmi.connectors#getTest()
	 * @see #getconnectors()
	 * @generated
	 */
	EReference getconnectors_Test();

	/**
	 * Returns the meta object for class '{@link xmi.connector <em>connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>connector</em>'.
	 * @see xmi.connector
	 * @generated
	 */
	EClass getconnector();

	/**
	 * Returns the meta object for the containment reference '{@link xmi.connector#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Properties</em>'.
	 * @see xmi.connector#getProperties()
	 * @see #getconnector()
	 * @generated
	 */
	EReference getconnector_Properties();

	/**
	 * Returns the meta object for the reference '{@link xmi.connector#getXmiidref <em>Xmiidref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Xmiidref</em>'.
	 * @see xmi.connector#getXmiidref()
	 * @see #getconnector()
	 * @generated
	 */
	EReference getconnector_Xmiidref();

	/**
	 * Returns the meta object for class '{@link xmi.model <em>model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>model</em>'.
	 * @see xmi.model
	 * @generated
	 */
	EClass getmodel();

	/**
	 * Returns the meta object for the reference '{@link xmi.model#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see xmi.model#getPackage()
	 * @see #getmodel()
	 * @generated
	 */
	EReference getmodel_Package();

	/**
	 * Returns the meta object for the reference '{@link xmi.model#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see xmi.model#getOwner()
	 * @see #getmodel()
	 * @generated
	 */
	EReference getmodel_Owner();

	/**
	 * Returns the meta object for the attribute '{@link xmi.model#getTpos <em>Tpos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tpos</em>'.
	 * @see xmi.model#getTpos()
	 * @see #getmodel()
	 * @generated
	 */
	EAttribute getmodel_Tpos();

	/**
	 * Returns the meta object for the attribute '{@link xmi.model#getEa_localid <em>Ea localid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ea localid</em>'.
	 * @see xmi.model#getEa_localid()
	 * @see #getmodel()
	 * @generated
	 */
	EAttribute getmodel_Ea_localid();

	/**
	 * Returns the meta object for the attribute '{@link xmi.model#getEa_eletype <em>Ea eletype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ea eletype</em>'.
	 * @see xmi.model#getEa_eletype()
	 * @see #getmodel()
	 * @generated
	 */
	EAttribute getmodel_Ea_eletype();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XmiFactory getXmiFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link xmi.impl.ExtensionImpl <em>Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.ExtensionImpl
		 * @see xmi.impl.XmiPackageImpl#getExtension()
		 * @generated
		 */
		EClass EXTENSION = eINSTANCE.getExtension();

		/**
		 * The meta object literal for the '<em><b>Extender</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__EXTENDER = eINSTANCE.getExtension_Extender();

		/**
		 * The meta object literal for the '<em><b>Extender ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION__EXTENDER_ID = eINSTANCE.getExtension_ExtenderID();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION__ELEMENTS = eINSTANCE.getExtension_Elements();

		/**
		 * The meta object literal for the '<em><b>Profiles</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION__PROFILES = eINSTANCE.getExtension_Profiles();

		/**
		 * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION__CONNECTORS = eINSTANCE.getExtension_Connectors();

		/**
		 * The meta object literal for the '{@link xmi.impl.DocumentationImpl <em>Documentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.DocumentationImpl
		 * @see xmi.impl.XmiPackageImpl#getDocumentation()
		 * @generated
		 */
		EClass DOCUMENTATION = eINSTANCE.getDocumentation();

		/**
		 * The meta object literal for the '<em><b>Exporter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__EXPORTER = eINSTANCE.getDocumentation_Exporter();

		/**
		 * The meta object literal for the '<em><b>Exporter Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTATION__EXPORTER_VERSION = eINSTANCE.getDocumentation_ExporterVersion();

		/**
		 * The meta object literal for the '{@link xmi.impl.elementsImpl <em>elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.elementsImpl
		 * @see xmi.impl.XmiPackageImpl#getelements()
		 * @generated
		 */
		EClass ELEMENTS = eINSTANCE.getelements();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENTS__ELEMENT = eINSTANCE.getelements_Element();

		/**
		 * The meta object literal for the '<em><b>Test</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENTS__TEST = eINSTANCE.getelements_Test();

		/**
		 * The meta object literal for the '{@link xmi.impl.elementImpl <em>element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.elementImpl
		 * @see xmi.impl.XmiPackageImpl#getelement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getelement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getelement_Name();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__SCOPE = eINSTANCE.getelement_Scope();

		/**
		 * The meta object literal for the '<em><b>Xrefs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__XREFS = eINSTANCE.getelement_Xrefs();

		/**
		 * The meta object literal for the '<em><b>Xmiidref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__XMIIDREF = eINSTANCE.getelement_Xmiidref();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__CLASSIFIER = eINSTANCE.getelement_Classifier();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__PROPERTIES = eINSTANCE.getelement_Properties();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__ATTRIBUTES = eINSTANCE.getelement_Attributes();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__CONSTRAINTS = eINSTANCE.getelement_Constraints();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__MODEL = eINSTANCE.getelement_Model();

		/**
		 * The meta object literal for the '{@link xmi.impl.xrefsImpl <em>xrefs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.xrefsImpl
		 * @see xmi.impl.XmiPackageImpl#getxrefs()
		 * @generated
		 */
		EClass XREFS = eINSTANCE.getxrefs();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XREFS__VALUE = eINSTANCE.getxrefs_Value();

		/**
		 * The meta object literal for the '{@link xmi.impl.profilesImpl <em>profiles</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.profilesImpl
		 * @see xmi.impl.XmiPackageImpl#getprofiles()
		 * @generated
		 */
		EClass PROFILES = eINSTANCE.getprofiles();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROFILES__PROFILE = eINSTANCE.getprofiles_Profile();

		/**
		 * The meta object literal for the '{@link xmi.impl.propertiesImpl <em>properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.propertiesImpl
		 * @see xmi.impl.XmiPackageImpl#getproperties()
		 * @generated
		 */
		EClass PROPERTIES = eINSTANCE.getproperties();

		/**
		 * The meta object literal for the '<em><b>Is Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__IS_SPECIFICATION = eINSTANCE.getproperties_IsSpecification();

		/**
		 * The meta object literal for the '<em><b>SType</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__STYPE = eINSTANCE.getproperties_SType();

		/**
		 * The meta object literal for the '<em><b>NType</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__NTYPE = eINSTANCE.getproperties_NType();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__SCOPE = eINSTANCE.getproperties_Scope();

		/**
		 * The meta object literal for the '<em><b>Is Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__IS_ROOT = eINSTANCE.getproperties_IsRoot();

		/**
		 * The meta object literal for the '<em><b>Is Leaf</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__IS_LEAF = eINSTANCE.getproperties_IsLeaf();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__IS_ABSTRACT = eINSTANCE.getproperties_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Ea type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__EA_TYPE = eINSTANCE.getproperties_Ea_type();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES__DIRECTION = eINSTANCE.getproperties_Direction();

		/**
		 * The meta object literal for the '{@link xmi.impl.attributesImpl <em>attributes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.attributesImpl
		 * @see xmi.impl.XmiPackageImpl#getattributes()
		 * @generated
		 */
		EClass ATTRIBUTES = eINSTANCE.getattributes();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTES__ATTRIBUTE = eINSTANCE.getattributes_Attribute();

		/**
		 * The meta object literal for the '{@link xmi.impl.attributeImpl <em>attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.attributeImpl
		 * @see xmi.impl.XmiPackageImpl#getattribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getattribute();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__STEREOTYPE = eINSTANCE.getattribute_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Xmiidref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__XMIIDREF = eINSTANCE.getattribute_Xmiidref();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getattribute_Name();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__SCOPE = eINSTANCE.getattribute_Scope();

		/**
		 * The meta object literal for the '{@link xmi.impl.stereotypeImpl <em>stereotype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.stereotypeImpl
		 * @see xmi.impl.XmiPackageImpl#getstereotype()
		 * @generated
		 */
		EClass STEREOTYPE = eINSTANCE.getstereotype();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEREOTYPE__STEREOTYPE = eINSTANCE.getstereotype_Stereotype();

		/**
		 * The meta object literal for the '{@link xmi.impl.constraintsImpl <em>constraints</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.constraintsImpl
		 * @see xmi.impl.XmiPackageImpl#getconstraints()
		 * @generated
		 */
		EClass CONSTRAINTS = eINSTANCE.getconstraints();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINTS__CONSTRAINT = eINSTANCE.getconstraints_Constraint();

		/**
		 * The meta object literal for the '{@link xmi.impl.constraintImpl <em>constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.constraintImpl
		 * @see xmi.impl.XmiPackageImpl#getconstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getconstraint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__NAME = eINSTANCE.getconstraint_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__TYPE = eINSTANCE.getconstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__WEIGHT = eINSTANCE.getconstraint_Weight();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__STATUS = eINSTANCE.getconstraint_Status();

		/**
		 * The meta object literal for the '{@link xmi.impl.connectorsImpl <em>connectors</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.connectorsImpl
		 * @see xmi.impl.XmiPackageImpl#getconnectors()
		 * @generated
		 */
		EClass CONNECTORS = eINSTANCE.getconnectors();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTORS__CONNECTOR = eINSTANCE.getconnectors_Connector();

		/**
		 * The meta object literal for the '<em><b>Test</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTORS__TEST = eINSTANCE.getconnectors_Test();

		/**
		 * The meta object literal for the '{@link xmi.impl.connectorImpl <em>connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.connectorImpl
		 * @see xmi.impl.XmiPackageImpl#getconnector()
		 * @generated
		 */
		EClass CONNECTOR = eINSTANCE.getconnector();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__PROPERTIES = eINSTANCE.getconnector_Properties();

		/**
		 * The meta object literal for the '<em><b>Xmiidref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__XMIIDREF = eINSTANCE.getconnector_Xmiidref();

		/**
		 * The meta object literal for the '{@link xmi.impl.modelImpl <em>model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see xmi.impl.modelImpl
		 * @see xmi.impl.XmiPackageImpl#getmodel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getmodel();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__PACKAGE = eINSTANCE.getmodel_Package();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__OWNER = eINSTANCE.getmodel_Owner();

		/**
		 * The meta object literal for the '<em><b>Tpos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__TPOS = eINSTANCE.getmodel_Tpos();

		/**
		 * The meta object literal for the '<em><b>Ea localid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__EA_LOCALID = eINSTANCE.getmodel_Ea_localid();

		/**
		 * The meta object literal for the '<em><b>Ea eletype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__EA_ELETYPE = eINSTANCE.getmodel_Ea_eletype();

	}

} //XmiPackage

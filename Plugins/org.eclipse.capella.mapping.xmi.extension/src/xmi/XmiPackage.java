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
	 * The number of structural features of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_FEATURE_COUNT = 4;

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
	 * The number of structural features of the '<em>element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 6;

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
	 * The number of structural features of the '<em>properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_OPERATION_COUNT = 0;


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

	}

} //XmiPackage

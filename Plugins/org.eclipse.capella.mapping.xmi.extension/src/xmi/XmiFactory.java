/**
 */
package xmi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see xmi.XmiPackage
 * @generated
 */
public interface XmiFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XmiFactory eINSTANCE = xmi.impl.XmiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension</em>'.
	 * @generated
	 */
	Extension createExtension();

	/**
	 * Returns a new object of class '<em>Documentation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documentation</em>'.
	 * @generated
	 */
	Documentation createDocumentation();

	/**
	 * Returns a new object of class '<em>elements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>elements</em>'.
	 * @generated
	 */
	elements createelements();

	/**
	 * Returns a new object of class '<em>element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>element</em>'.
	 * @generated
	 */
	element createelement();

	/**
	 * Returns a new object of class '<em>xrefs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>xrefs</em>'.
	 * @generated
	 */
	xrefs createxrefs();

	/**
	 * Returns a new object of class '<em>profiles</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>profiles</em>'.
	 * @generated
	 */
	profiles createprofiles();

	/**
	 * Returns a new object of class '<em>properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>properties</em>'.
	 * @generated
	 */
	properties createproperties();

	/**
	 * Returns a new object of class '<em>Packaged Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Packaged Element</em>'.
	 * @generated
	 */
	PackagedElement createPackagedElement();

	/**
	 * Returns a new object of class '<em>uml Profile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>uml Profile</em>'.
	 * @generated
	 */
	umlProfile createumlProfile();

	/**
	 * Returns a new object of class '<em>owned End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>owned End</em>'.
	 * @generated
	 */
	ownedEnd createownedEnd();

	/**
	 * Returns a new object of class '<em>package Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>package Import</em>'.
	 * @generated
	 */
	packageImport createpackageImport();

	/**
	 * Returns a new object of class '<em>imported Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>imported Package</em>'.
	 * @generated
	 */
	importedPackage createimportedPackage();

	/**
	 * Returns a new object of class '<em>owned Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>owned Attribute</em>'.
	 * @generated
	 */
	ownedAttribute createownedAttribute();

	/**
	 * Returns a new object of class '<em>type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>type</em>'.
	 * @generated
	 */
	type createtype();

	/**
	 * Returns a new object of class '<em>attributes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>attributes</em>'.
	 * @generated
	 */
	attributes createattributes();

	/**
	 * Returns a new object of class '<em>attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>attribute</em>'.
	 * @generated
	 */
	attribute createattribute();

	/**
	 * Returns a new object of class '<em>extended Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>extended Properties</em>'.
	 * @generated
	 */
	extendedProperties createextendedProperties();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XmiPackage getXmiPackage();

} //XmiFactory

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
	 * Returns a new object of class '<em>stereotype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>stereotype</em>'.
	 * @generated
	 */
	stereotype createstereotype();

	/**
	 * Returns a new object of class '<em>constraints</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>constraints</em>'.
	 * @generated
	 */
	constraints createconstraints();

	/**
	 * Returns a new object of class '<em>constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>constraint</em>'.
	 * @generated
	 */
	constraint createconstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XmiPackage getXmiPackage();

} //XmiFactory

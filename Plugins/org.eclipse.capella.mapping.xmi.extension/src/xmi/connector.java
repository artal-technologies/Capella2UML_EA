/**
 */
package xmi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xmi.connector#getProperties <em>Properties</em>}</li>
 *   <li>{@link xmi.connector#getXmiidref <em>Xmiidref</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#getconnector()
 * @model
 * @generated
 */
public interface connector extends EObject {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(properties)
	 * @see xmi.XmiPackage#getconnector_Properties()
	 * @model containment="true"
	 * @generated
	 */
	properties getProperties();

	/**
	 * Sets the value of the '{@link xmi.connector#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(properties value);

	/**
	 * Returns the value of the '<em><b>Xmiidref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmiidref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmiidref</em>' reference.
	 * @see #setXmiidref(EObject)
	 * @see xmi.XmiPackage#getconnector_Xmiidref()
	 * @model
	 * @generated
	 */
	EObject getXmiidref();

	/**
	 * Sets the value of the '{@link xmi.connector#getXmiidref <em>Xmiidref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmiidref</em>' reference.
	 * @see #getXmiidref()
	 * @generated
	 */
	void setXmiidref(EObject value);

} // connector

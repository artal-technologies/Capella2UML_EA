/**
 */
package org.capella.bridge.uml.ea.model.xmi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.target#getXmiidref <em>Xmiidref</em>}</li>
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.target#getRole <em>Role</em>}</li>
 * </ul>
 *
 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#gettarget()
 * @model
 * @generated
 */
public interface target extends EObject {
	/**
	 * Returns the value of the '<em><b>Xmiidref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmiidref</em>' reference.
	 * @see #setXmiidref(EObject)
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#gettarget_Xmiidref()
	 * @model
	 * @generated
	 */
	EObject getXmiidref();

	/**
	 * Sets the value of the '{@link org.capella.bridge.uml.ea.model.xmi.target#getXmiidref <em>Xmiidref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmiidref</em>' reference.
	 * @see #getXmiidref()
	 * @generated
	 */
	void setXmiidref(EObject value);

	/**
	 * Returns the value of the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' containment reference.
	 * @see #setRole(role)
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#gettarget_Role()
	 * @model containment="true"
	 * @generated
	 */
	role getRole();

	/**
	 * Sets the value of the '{@link org.capella.bridge.uml.ea.model.xmi.target#getRole <em>Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' containment reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(role value);

} // target

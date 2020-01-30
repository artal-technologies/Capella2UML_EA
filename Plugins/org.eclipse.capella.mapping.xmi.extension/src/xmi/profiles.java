/**
 */
package xmi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>profiles</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xmi.profiles#getProfile <em>Profile</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#getprofiles()
 * @model
 * @generated
 */
public interface profiles extends EObject {
	/**
	 * Returns the value of the '<em><b>Profile</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile</em>' containment reference.
	 * @see #setProfile(EObject)
	 * @see xmi.XmiPackage#getprofiles_Profile()
	 * @model containment="true"
	 * @generated
	 */
	EObject getProfile();

	/**
	 * Sets the value of the '{@link xmi.profiles#getProfile <em>Profile</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile</em>' containment reference.
	 * @see #getProfile()
	 * @generated
	 */
	void setProfile(EObject value);

} // profiles

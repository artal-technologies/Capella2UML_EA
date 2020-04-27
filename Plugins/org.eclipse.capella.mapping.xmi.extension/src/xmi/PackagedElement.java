/**
 */
package xmi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Packaged Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xmi.PackagedElement#getXmiid <em>Xmiid</em>}</li>
 *   <li>{@link xmi.PackagedElement#getName <em>Name</em>}</li>
 *   <li>{@link xmi.PackagedElement#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link xmi.PackagedElement#getOwnedEnd <em>Owned End</em>}</li>
 *   <li>{@link xmi.PackagedElement#getXmitype <em>Xmitype</em>}</li>
 *   <li>{@link xmi.PackagedElement#getOwnedAttribute <em>Owned Attribute</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#getPackagedElement()
 * @model
 * @generated
 */
public interface PackagedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Xmiid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmiid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmiid</em>' attribute.
	 * @see #setXmiid(String)
	 * @see xmi.XmiPackage#getPackagedElement_Xmiid()
	 * @model
	 * @generated
	 */
	String getXmiid();

	/**
	 * Sets the value of the '{@link xmi.PackagedElement#getXmiid <em>Xmiid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmiid</em>' attribute.
	 * @see #getXmiid()
	 * @generated
	 */
	void setXmiid(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see xmi.XmiPackage#getPackagedElement_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link xmi.PackagedElement#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see xmi.XmiPackage#getPackagedElement_Prefix()
	 * @model
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link xmi.PackagedElement#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Owned End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned End</em>' reference.
	 * @see #setOwnedEnd(ownedEnd)
	 * @see xmi.XmiPackage#getPackagedElement_OwnedEnd()
	 * @model
	 * @generated
	 */
	ownedEnd getOwnedEnd();

	/**
	 * Sets the value of the '{@link xmi.PackagedElement#getOwnedEnd <em>Owned End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned End</em>' reference.
	 * @see #getOwnedEnd()
	 * @generated
	 */
	void setOwnedEnd(ownedEnd value);

	/**
	 * Returns the value of the '<em><b>Xmitype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmitype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmitype</em>' attribute.
	 * @see #setXmitype(String)
	 * @see xmi.XmiPackage#getPackagedElement_Xmitype()
	 * @model
	 * @generated
	 */
	String getXmitype();

	/**
	 * Sets the value of the '{@link xmi.PackagedElement#getXmitype <em>Xmitype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmitype</em>' attribute.
	 * @see #getXmitype()
	 * @generated
	 */
	void setXmitype(String value);

	/**
	 * Returns the value of the '<em><b>Owned Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Attribute</em>' reference.
	 * @see #setOwnedAttribute(ownedAttribute)
	 * @see xmi.XmiPackage#getPackagedElement_OwnedAttribute()
	 * @model
	 * @generated
	 */
	ownedAttribute getOwnedAttribute();

	/**
	 * Sets the value of the '{@link xmi.PackagedElement#getOwnedAttribute <em>Owned Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Attribute</em>' reference.
	 * @see #getOwnedAttribute()
	 * @generated
	 */
	void setOwnedAttribute(ownedAttribute value);

} // PackagedElement

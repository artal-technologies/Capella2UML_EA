/**
 */
package xmi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xmi.attribute#getExtendedProperties <em>Extended Properties</em>}</li>
 *   <li>{@link xmi.attribute#getTagged <em>Tagged</em>}</li>
 *   <li>{@link xmi.attribute#getName <em>Name</em>}</li>
 *   <li>{@link xmi.attribute#getXmiidref <em>Xmiidref</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#getattribute()
 * @model
 * @generated
 */
public interface attribute extends EObject {
	/**
	 * Returns the value of the '<em><b>Extended Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended Properties</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extended Properties</em>' containment reference.
	 * @see #setExtendedProperties(extendedProperties)
	 * @see xmi.XmiPackage#getattribute_ExtendedProperties()
	 * @model containment="true"
	 * @generated
	 */
	extendedProperties getExtendedProperties();

	/**
	 * Sets the value of the '{@link xmi.attribute#getExtendedProperties <em>Extended Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Properties</em>' containment reference.
	 * @see #getExtendedProperties()
	 * @generated
	 */
	void setExtendedProperties(extendedProperties value);

	/**
	 * Returns the value of the '<em><b>Tagged</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tagged</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tagged</em>' attribute.
	 * @see #setTagged(String)
	 * @see xmi.XmiPackage#getattribute_Tagged()
	 * @model
	 * @generated
	 */
	String getTagged();

	/**
	 * Sets the value of the '{@link xmi.attribute#getTagged <em>Tagged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tagged</em>' attribute.
	 * @see #getTagged()
	 * @generated
	 */
	void setTagged(String value);

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
	 * @see xmi.XmiPackage#getattribute_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link xmi.attribute#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see xmi.XmiPackage#getattribute_Xmiidref()
	 * @model
	 * @generated
	 */
	EObject getXmiidref();

	/**
	 * Sets the value of the '{@link xmi.attribute#getXmiidref <em>Xmiidref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmiidref</em>' reference.
	 * @see #getXmiidref()
	 * @generated
	 */
	void setXmiidref(EObject value);

} // attribute

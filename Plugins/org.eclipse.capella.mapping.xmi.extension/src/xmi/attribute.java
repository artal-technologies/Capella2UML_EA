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
 *   <li>{@link xmi.attribute#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link xmi.attribute#getXmiidref <em>Xmiidref</em>}</li>
 *   <li>{@link xmi.attribute#getName <em>Name</em>}</li>
 *   <li>{@link xmi.attribute#getScope <em>Scope</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#getattribute()
 * @model
 * @generated
 */
public interface attribute extends EObject {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' containment reference.
	 * @see #setStereotype(stereotype)
	 * @see xmi.XmiPackage#getattribute_Stereotype()
	 * @model containment="true"
	 * @generated
	 */
	stereotype getStereotype();

	/**
	 * Sets the value of the '{@link xmi.attribute#getStereotype <em>Stereotype</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' containment reference.
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(stereotype value);

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
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see #setScope(String)
	 * @see xmi.XmiPackage#getattribute_Scope()
	 * @model
	 * @generated
	 */
	String getScope();

	/**
	 * Sets the value of the '{@link xmi.attribute#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(String value);

} // attribute

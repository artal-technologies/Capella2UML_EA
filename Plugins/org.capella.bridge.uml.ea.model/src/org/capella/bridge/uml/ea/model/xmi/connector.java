/**
 */
package org.capella.bridge.uml.ea.model.xmi;

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
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.connector#getSource <em>Source</em>}</li>
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.connector#getTarget <em>Target</em>}</li>
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.connector#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.connector#getXmiidref <em>Xmiidref</em>}</li>
 * </ul>
 *
 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getconnector()
 * @model
 * @generated
 */
public interface connector extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(source)
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getconnector_Source()
	 * @model containment="true"
	 * @generated
	 */
	source getSource();

	/**
	 * Sets the value of the '{@link org.capella.bridge.uml.ea.model.xmi.connector#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(source value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(target)
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getconnector_Target()
	 * @model containment="true"
	 * @generated
	 */
	target getTarget();

	/**
	 * Sets the value of the '{@link org.capella.bridge.uml.ea.model.xmi.connector#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(target value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(properties)
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getconnector_Properties()
	 * @model containment="true"
	 * @generated
	 */
	properties getProperties();

	/**
	 * Sets the value of the '{@link org.capella.bridge.uml.ea.model.xmi.connector#getProperties <em>Properties</em>}' containment reference.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmiidref</em>' reference.
	 * @see #setXmiidref(EObject)
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getconnector_Xmiidref()
	 * @model
	 * @generated
	 */
	EObject getXmiidref();

	/**
	 * Sets the value of the '{@link org.capella.bridge.uml.ea.model.xmi.connector#getXmiidref <em>Xmiidref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmiidref</em>' reference.
	 * @see #getXmiidref()
	 * @generated
	 */
	void setXmiidref(EObject value);

} // connector

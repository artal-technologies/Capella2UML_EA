/**
 */
package xmi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>connectors</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xmi.connectors#getConnector <em>Connector</em>}</li>
 *   <li>{@link xmi.connectors#getTest <em>Test</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#getconnectors()
 * @model
 * @generated
 */
public interface connectors extends EObject {
	/**
	 * Returns the value of the '<em><b>Connector</b></em>' containment reference list.
	 * The list contents are of type {@link xmi.connector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector</em>' containment reference list.
	 * @see xmi.XmiPackage#getconnectors_Connector()
	 * @model containment="true"
	 * @generated
	 */
	EList<connector> getConnector();

	/**
	 * Returns the value of the '<em><b>Test</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test</em>' reference list.
	 * @see xmi.XmiPackage#getconnectors_Test()
	 * @model derived="true"
	 * @generated
	 */
	EList<EObject> getTest();

} // connectors

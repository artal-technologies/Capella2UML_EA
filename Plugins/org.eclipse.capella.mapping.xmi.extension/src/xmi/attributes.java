/**
 */
package xmi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xmi.attributes#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#getattributes()
 * @model
 * @generated
 */
public interface attributes extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link xmi.attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see xmi.XmiPackage#getattributes_Attribute()
	 * @model containment="true"
	 * @generated
	 */
	EList<attribute> getAttribute();

} // attributes

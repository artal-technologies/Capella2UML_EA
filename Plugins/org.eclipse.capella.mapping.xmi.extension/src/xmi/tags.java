/**
 */
package xmi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>tags</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xmi.tags#getTag <em>Tag</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#gettags()
 * @model
 * @generated
 */
public interface tags extends EObject {
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' containment reference list.
	 * The list contents are of type {@link xmi.tag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' containment reference list.
	 * @see xmi.XmiPackage#gettags_Tag()
	 * @model containment="true"
	 * @generated
	 */
	EList<tag> getTag();

} // tags

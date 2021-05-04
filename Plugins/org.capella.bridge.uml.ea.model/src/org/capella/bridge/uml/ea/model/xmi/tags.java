/**
 */
package org.capella.bridge.uml.ea.model.xmi;

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
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.tags#getTag <em>Tag</em>}</li>
 * </ul>
 *
 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#gettags()
 * @model
 * @generated
 */
public interface tags extends EObject {
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' containment reference list.
	 * The list contents are of type {@link org.capella.bridge.uml.ea.model.xmi.tag}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' containment reference list.
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#gettags_Tag()
	 * @model containment="true"
	 * @generated
	 */
	EList<tag> getTag();

} // tags

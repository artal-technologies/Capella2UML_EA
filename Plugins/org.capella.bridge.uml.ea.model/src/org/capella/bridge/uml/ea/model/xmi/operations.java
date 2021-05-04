/**
 */
package org.capella.bridge.uml.ea.model.xmi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>operations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.operations#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getoperations()
 * @model
 * @generated
 */
public interface operations extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference list.
	 * The list contents are of type {@link org.capella.bridge.uml.ea.model.xmi.operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference list.
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getoperations_Operation()
	 * @model containment="true"
	 * @generated
	 */
	EList<operation> getOperation();

} // operations

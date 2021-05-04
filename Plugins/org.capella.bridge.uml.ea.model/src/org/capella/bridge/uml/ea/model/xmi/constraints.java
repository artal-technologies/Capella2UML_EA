/**
 */
package org.capella.bridge.uml.ea.model.xmi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>constraints</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.constraints#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getconstraints()
 * @model
 * @generated
 */
public interface constraints extends EObject {
	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link org.capella.bridge.uml.ea.model.xmi.constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference list.
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getconstraints_Constraint()
	 * @model containment="true"
	 * @generated
	 */
	EList<constraint> getConstraint();

} // constraints

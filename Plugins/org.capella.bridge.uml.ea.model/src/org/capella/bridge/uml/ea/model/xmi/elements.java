/**
 */
package org.capella.bridge.uml.ea.model.xmi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>elements</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.elements#getElement <em>Element</em>}</li>
 *   <li>{@link org.capella.bridge.uml.ea.model.xmi.elements#getTest <em>Test</em>}</li>
 * </ul>
 *
 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getelements()
 * @model
 * @generated
 */
public interface elements extends EObject {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.capella.bridge.uml.ea.model.xmi.element}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference list.
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getelements_Element()
	 * @model containment="true"
	 * @generated
	 */
	EList<element> getElement();

	/**
	 * Returns the value of the '<em><b>Test</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test</em>' reference list.
	 * @see org.capella.bridge.uml.ea.model.xmi.XmiPackage#getelements_Test()
	 * @model derived="true"
	 * @generated
	 */
	EList<EObject> getTest();

} // elements

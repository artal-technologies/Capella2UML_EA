/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.internal.operations.ElementOperations;

/**
 * @author binot
 *
 */
public class Capella2UMLElementOperations extends ElementOperations {

	/**
	 * 
	 */
	public Capella2UMLElementOperations() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Applies the specified stereotype to this element.
	 * @param element The receiving '<em><b>Element</b></em>' model object.
	 * @param stereotype The stereotype to apply.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static EObject applyStereotype(Element element,
			Stereotype stereotype) {
		EClass definition = getDefinition(element, stereotype, true);

		if (getExtension(element, stereotype) == null) {
			throw new IllegalArgumentException(
				String.format("stereotype \"%s\" is not applicable to %s", //$NON-NLS-1$
					stereotype.getQualifiedName(), element.eClass().getName()));
		}

		if (element.getStereotypeApplication(stereotype) != null) {
			throw new IllegalArgumentException(
				String.format("stereotype \"%s\" is already applied", //$NON-NLS-1$
					stereotype.getQualifiedName()));
		}

		return applyStereotype(element, definition);
	}
	
	
	static public EObject applyStereotype(Element element, EClass definition) {
		EObject stereotypeApplication = EcoreUtil.create(definition);

		CacheAdapter.getInstance().adapt(stereotypeApplication);

		addToContainmentList(element, stereotypeApplication);
		setBaseElement(stereotypeApplication, element);

		return stereotypeApplication;
	}
	
	static public boolean addToContainmentList(Element element,
			EObject stereotypeApplication) {
		boolean result = false;

		EList<EObject> containmentList = getContainmentList(element,
			stereotypeApplication.eClass());

		if (containmentList != null) {
			result = containmentList.add(stereotypeApplication);
		}

		return result;
	}
	
	static protected EList<EObject> getContainmentList(Element element,
			EClass definition) {
		Resource eResource = element.eResource();
		
		Model model = element.getModel();
		EList<EObject> eContents = model.eContents();
		return eContents;

//		if (eResource != null) {
//			return eResource.getContents();
//		}
//
//		return null;
	}
	
	
	
	
	
	
}

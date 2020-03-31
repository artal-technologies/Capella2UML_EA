/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.BlockArchitecture;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonDescriptionMapping;

import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class DescriptionMapping extends CommonDescriptionMapping<BlockArchitecture, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public DescriptionMapping(Capella2UMLAlgo algo, BlockArchitecture parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#compute(java.lang.
	 * Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, CapellaElement source) {

		Element capellaObjectFromAllRules = (Element) MappingRulesManager.getCapellaObjectFromAllRules(source);
		if (capellaObjectFromAllRules != null) {
			Comment createComment = UMLFactory.eINSTANCE.createComment();
			MappingUtils.generateUID(getAlgo(), source, createComment, this, "ct");

			createComment.setBody(source.getDescription());

			createComment.getAnnotatedElements().add(capellaObjectFromAllRules);

			if (eaContainer instanceof Model) {
				org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package) (((Model) eaContainer)
						.getPackagedElements().get(0));
				pkgCapella.getOwnedComments().add(createComment);
			}

			XMIExtensionsUtils.setDocumentation(capellaObjectFromAllRules, getAlgo().getXMIExtension(),
					source.getDescription(), SpecificUtils.getSType(source));

			return createComment;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#executeSubRules(java.
	 * util.List, com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<CapellaElement> _capellaSource, MappingRulesManager manager) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#getUID(org.eclipse.emf
	 * .ecore.EObject, java.lang.String)
	 */
	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping;
import org.eclipse.capella.mapping.capella2uml.toMove.MappingUtils;
import org.eclipse.capella.mapping.capella2uml.toMove.XMIExtensionsUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.EnumerationPropertyLiteral;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.datatype.DatatypePackage;
import org.polarsys.capella.core.data.information.datatype.Enumeration;
import org.polarsys.capella.core.data.information.datavalue.EnumerationLiteral;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class EnumerationMapping extends AbstractDynamicMapping<DataPkg, Enumeration, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public EnumerationMapping(Capella2UMLAlgo algo, DataPkg parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeEAContainer(DataPkg capellaContainer) {

		Project capellaProject = ProjectExt.getProject(capellaContainer);
		Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
		return model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeCapellaSource(java.lang.Object)
	 */
	@Override
	public List<Enumeration> computeCapellaSource(DataPkg capellaContainer) {

		List<Enumeration> enumerations = EObjectExt.getAll(capellaContainer, DatatypePackage.Literals.ENUMERATION)
				.stream().map(Enumeration.class::cast).collect(Collectors.toList());
		return enumerations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, Enumeration source) {
		org.eclipse.uml2.uml.Enumeration enumerationTarget = UMLFactory.eINSTANCE.createEnumeration();
		generateUID(source, enumerationTarget);
		enumerationTarget.setName(source.getName());

		EList<EnumerationLiteral> ownedLiterals = source.getOwnedLiterals();
		for (EnumerationLiteral enumerationLiteral : ownedLiterals) {
			org.eclipse.uml2.uml.EnumerationLiteral createEnumerationLiteral = UMLFactory.eINSTANCE
					.createEnumerationLiteral();
			generateUID(enumerationLiteral, createEnumerationLiteral);
			createEnumerationLiteral.setName(enumerationLiteral.getName());

			enumerationTarget.getOwnedLiterals().add(createEnumerationLiteral);
			toTrace(enumerationLiteral, createEnumerationLiteral);
		}

		if (eaContainer instanceof Model) {
			EList<PackageableElement> ownedMembers = ((Model) eaContainer).getPackagedElements();
			for (PackageableElement ownedMember : ownedMembers) {
				if (ownedMember.getName().equals("Import Capella"))
					((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(enumerationTarget);
			}
		}

		return enumerationTarget;
	}

	private void generateUID(CapellaElement source, EObject targetComponent) {
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		getAlgo().putId(targetComponent, this, sysMLID);
		XMIExtensionsUtils.addElement(targetComponent, getAlgo().getXMIExtension());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<Enumeration> _capellaSource, MappingRulesManager manager) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#getUID(
	 * org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	@Override
	public String getUID(EObject key, String id) {
		// TODO Auto-generated method stub
		return "EAID_" + id;
	}

}

/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.ComponentPkg;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponentPkg;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponentPkg;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class ActorPkgMapping extends AbstractDynamicMapping<CapellaElement, ComponentPkg, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public ActorPkgMapping(Capella2UMLAlgo algo, CapellaElement parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#computeTargetContainer
	 * (java.lang.Object)
	 */
	@Override
	public Object computeTargetContainer(CapellaElement capellaContainer) {
		if (!(capellaContainer instanceof ComponentPkg)) {
			Project project = ProjectExt.getProject(capellaContainer);
			Object capellaObjectFromAllRules = MappingRulesManager.getCapellaObjectFromAllRules(project);
			EList<PackageableElement> packagedElements = ((Model) capellaObjectFromAllRules).getPackagedElements();
			for (PackageableElement ownedMember : packagedElements) {
				if (ownedMember.getName().equals(SpecificUtils.getCapellaImportName(this)))
					return ownedMember;
			}
		}
		return MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#findSourceElements(
	 * java.lang.Object)
	 */
	@Override
	public List<ComponentPkg> findSourceElements(CapellaElement capellaContainer) {

		List<ComponentPkg> results = new ArrayList<ComponentPkg>();
		if (capellaContainer instanceof LogicalArchitecture) {
			ComponentPkg ownedInterfacePkg = ((LogicalArchitecture) capellaContainer).getOwnedLogicalComponentPkg();
			results.add(ownedInterfacePkg);
		}
		if (capellaContainer instanceof PhysicalArchitecture) {
			ComponentPkg ownedInterfacePkg = ((PhysicalArchitecture) capellaContainer).getOwnedPhysicalComponentPkg();
			results.add(ownedInterfacePkg);
		}
		if (capellaContainer instanceof LogicalComponentPkg) {
			EList<LogicalComponentPkg> ownedInterfacePkgs = ((LogicalComponentPkg) capellaContainer)
					.getOwnedLogicalComponentPkgs();
			results.addAll(ownedInterfacePkgs);
		}
		if (capellaContainer instanceof PhysicalComponentPkg) {
			EList<PhysicalComponentPkg> ownedInterfacePkgs = ((PhysicalComponentPkg) capellaContainer)
					.getOwnedPhysicalComponentPkgs();
			results.addAll(ownedInterfacePkgs);
		}
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#compute(java.lang.
	 * Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, ComponentPkg source) {
		Package createPackage = UMLFactory.eINSTANCE.createPackage();
		createPackage.setName(source.getName());
		MappingUtils.generateUID(getAlgo(), source, createPackage, this);

		((Package) eaContainer).getPackagedElements().add(createPackage);

		return createPackage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#executeSubRules(java.
	 * util.List, com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<ComponentPkg> _capellaSource, MappingRulesManager manager) {
		for (ComponentPkg interfacePkg : _capellaSource) {
			ActorPkgMapping interfacePkgMapping = new ActorPkgMapping(getAlgo(), interfacePkg, getMappingExucution());
			manager.add(interfacePkgMapping.getClass().getName() + interfacePkg.getId(), interfacePkgMapping);

			ActorMapping actorMapping = new ActorMapping(getAlgo(), interfacePkg, getMappingExucution());
			manager.add(interfacePkg.getClass().getName() + interfacePkg.getId(), actorMapping);
		}
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
		return "EAPK_" + id;
	}

}

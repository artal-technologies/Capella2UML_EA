/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.AbstractActor;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.fa.AbstractFunctionalStructure;
import org.polarsys.capella.core.data.la.LogicalActor;
import org.polarsys.capella.core.data.la.LogicalActorPkg;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonsActorMapping<ALGO extends CapellaBridgeAlgo<?>>
		extends AbstractDynamicMapping<AbstractFunctionalStructure, AbstractActor, ALGO> {

	public CommonsActorMapping(ALGO algo, AbstractFunctionalStructure parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object computeTargetContainer(AbstractFunctionalStructure capellaContainer) {
		Project capellaProject = ProjectExt.getProject(capellaContainer);
		Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
		return model;
	}

	@Override
	public List<AbstractActor> findSourceElements(AbstractFunctionalStructure capellaContainer) {
		List<AbstractActor> ownedLogicalActors = EObjectExt.getAll(capellaContainer, CsPackage.Literals.ABSTRACT_ACTOR)
				.stream().map(AbstractActor.class::cast).collect(Collectors.toList());
		return ownedLogicalActors;
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

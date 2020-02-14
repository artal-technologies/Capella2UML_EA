/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.polarsys.capella.core.data.capellamodeller.Project;
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
		extends AbstractDynamicMapping<LogicalActorPkg, LogicalActor, ALGO> {

	public CommonsActorMapping(ALGO algo, LogicalActorPkg parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object computeTargetContainer(LogicalActorPkg capellaContainer) {
		Project capellaProject = ProjectExt.getProject(capellaContainer);
		Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
		return model;
	}

	@Override
	public List<LogicalActor> findSourceElements(LogicalActorPkg capellaContainer) {
		List<LogicalActor> ownedLogicalActors = capellaContainer.getOwnedLogicalActors();
		return ownedLogicalActors;
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

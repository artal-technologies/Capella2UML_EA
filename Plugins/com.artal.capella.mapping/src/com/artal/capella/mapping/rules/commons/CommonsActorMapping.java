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
import org.polarsys.capella.core.data.la.LaPackage;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.la.LogicalComponentPkg;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonsActorMapping<ALGO extends CapellaBridgeAlgo<?>>
		extends AbstractDynamicMapping<LogicalComponentPkg, LogicalComponent, ALGO> {

	public CommonsActorMapping(ALGO algo, LogicalComponentPkg parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object computeTargetContainer(LogicalComponentPkg capellaContainer) {
		Project capellaProject = ProjectExt.getProject(capellaContainer);
		Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
		return model;
	}

	@Override
	public List<LogicalComponent> findSourceElements(LogicalComponentPkg capellaContainer) {

		List<LogicalComponent> actors = EObjectExt.getAll(capellaContainer, LaPackage.Literals.LOGICAL_COMPONENT)
				.stream().map(LogicalComponent.class::cast).filter(act -> act.isActor()).filter(act -> act.isHuman())
				.collect(Collectors.toList());

		return actors;
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

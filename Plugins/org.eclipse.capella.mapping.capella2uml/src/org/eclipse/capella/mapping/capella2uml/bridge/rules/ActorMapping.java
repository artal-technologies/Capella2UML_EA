/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.la.LogicalActor;
import org.polarsys.capella.core.data.la.LogicalActorPkg;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class ActorMapping extends AbstractDynamicMapping<LogicalActorPkg, LogicalActor, Capella2UMLAlgo> {

	public ActorMapping(Capella2UMLAlgo algo, LogicalActorPkg parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeTargetContainer(LogicalActorPkg capellaContainer) {

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
	public List<LogicalActor> findSourceElements(LogicalActorPkg capellaContainer) {
		List<LogicalActor> ownedLogicalActors = capellaContainer.getOwnedLogicalActors();
		return ownedLogicalActors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, LogicalActor source) {
		Actor targetActor = UMLFactory.eINSTANCE.createActor();

		Capella2UMLAlgo algo = getAlgo();

		MappingUtils.generateUID(algo, source, targetActor, this);
		XMIExtensionsUtils.createElement(targetActor, algo.getXMIExtension());

		targetActor.setName(source.getName());
		if (eaContainer instanceof Model) {
			EList<PackageableElement> packagedElements = ((Model) eaContainer).getPackagedElements();
			for (PackageableElement packageableElement : packagedElements) {
				if (packageableElement.getName().equals("Import Capella"))
					((Package) packageableElement).getPackagedElements().add(targetActor);
			}
		}
		return targetActor;
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<LogicalActor> _capellaSource, MappingRulesManager manager) {

		for (LogicalActor logicalActor : _capellaSource) {
			ActorFunctionalExchangeMapping functionalExchangeMapping = new ActorFunctionalExchangeMapping(getAlgo(),
					logicalActor, getMappingExucution());
			manager.add(functionalExchangeMapping.getClass().getName() + logicalActor.getId(),
					functionalExchangeMapping);
		}

	}

}

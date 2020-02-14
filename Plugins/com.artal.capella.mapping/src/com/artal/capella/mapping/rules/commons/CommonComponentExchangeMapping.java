/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Model;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonComponentExchangeMapping<ALGO extends CapellaBridgeAlgo<?>> extends
		AbstractDynamicMapping<org.polarsys.capella.core.data.cs.Component, org.polarsys.capella.core.data.fa.ComponentExchange, ALGO> {

	public CommonComponentExchangeMapping(ALGO algo, Component parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(Component capellaContainer) {

		BehavioredClassifier container = (BehavioredClassifier) MappingRulesManager
				.getCapellaObjectFromAllRules(capellaContainer);
		if (container != null) {
			return container;
		}
		Project project = ProjectExt.getProject(capellaContainer);

		return (Model) MappingRulesManager.getCapellaObjectFromAllRules(project);
	}

	@Override
	public List<ComponentExchange> findSourceElements(Component capellaContainer) {
		List<ComponentExchange> ownedComponentExchanges = capellaContainer.getOwnedComponentExchanges();
		return ownedComponentExchanges;
	}

}

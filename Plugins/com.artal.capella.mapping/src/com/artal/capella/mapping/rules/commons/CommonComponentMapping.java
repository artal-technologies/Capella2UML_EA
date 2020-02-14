/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonComponentMapping<ALGO extends CapellaBridgeAlgo<?>> extends
		AbstractDynamicMapping<org.polarsys.capella.core.data.capellacore.CapellaElement, org.polarsys.capella.core.data.la.LogicalComponent, ALGO> {

	public CommonComponentMapping(ALGO algo, CapellaElement parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(CapellaElement capellaContainer) {
		if (capellaContainer instanceof LogicalArchitecture) {
			Project capellaProject = ProjectExt.getProject(capellaContainer);
			Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
			return model;
		} else {
			return (Component) MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
		}
	}

	@Override
	public List<LogicalComponent> findSourceElements(CapellaElement capellaContainer) {
		if (capellaContainer instanceof LogicalArchitecture) {
			LogicalComponent logicalSystem = CapellaUtils.getLogicalSystemRoot(capellaContainer);
			List<LogicalComponent> resutls = new ArrayList<>();
			resutls.add(logicalSystem);
			return resutls;
		}

		if (capellaContainer instanceof LogicalComponent) {
			List<LogicalComponent> ownedLogicalComponents = ((LogicalComponent) capellaContainer)
					.getOwnedLogicalComponents();
			return ownedLogicalComponents;
		}

		return Collections.emptyList();
	}

}

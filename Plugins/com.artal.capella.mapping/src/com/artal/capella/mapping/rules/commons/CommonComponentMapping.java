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
import org.polarsys.capella.core.data.cs.SystemComponent;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
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
		AbstractDynamicMapping<org.polarsys.capella.core.data.capellacore.CapellaElement, SystemComponent, ALGO> {

	public CommonComponentMapping(ALGO algo, CapellaElement parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(CapellaElement capellaContainer) {
		if (capellaContainer instanceof LogicalArchitecture) {
			Project capellaProject = ProjectExt.getProject(capellaContainer);
			Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
			return model;
		} else if (capellaContainer instanceof PhysicalArchitecture) {
			Project capellaProject = ProjectExt.getProject(capellaContainer);
			Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
			return model;
		} else {

			return (Component) MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
		}
	}

	@Override
	public List<SystemComponent> findSourceElements(CapellaElement capellaContainer) {
		if (capellaContainer instanceof LogicalArchitecture) {
			LogicalComponent logicalSystem = CapellaUtils.getLogicalSystemRoot(capellaContainer);
			List<SystemComponent> resutls = new ArrayList<>();
			resutls.add(logicalSystem);
			return resutls;
		}
		if (capellaContainer instanceof PhysicalArchitecture) {
			PhysicalComponent logicalSystem = CapellaUtils.getPhysicalSystemRoot(capellaContainer);
			List<SystemComponent> resutls = new ArrayList<>();
			resutls.add(logicalSystem);
			return resutls;
		}
		if (capellaContainer instanceof LogicalComponent) {
			List<LogicalComponent> ownedLogicalComponents = ((LogicalComponent) capellaContainer)
					.getOwnedLogicalComponents();
			List<SystemComponent> resutls = new ArrayList<>();
			resutls.addAll(ownedLogicalComponents);
			return resutls;
		}
		if (capellaContainer instanceof PhysicalComponent) {
			List<PhysicalComponent> ownedLogicalComponents = ((PhysicalComponent) capellaContainer)
					.getOwnedPhysicalComponents();
			List<SystemComponent> resutls = new ArrayList<>();
			resutls.addAll(ownedLogicalComponents);
			return resutls;
		}

		return Collections.emptyList();
	}

}

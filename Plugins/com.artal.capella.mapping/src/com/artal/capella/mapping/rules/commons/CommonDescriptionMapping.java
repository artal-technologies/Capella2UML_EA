/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.uml2.uml.Model;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonDescriptionMapping<SOURCE_CONTAINER extends CapellaElement, ALGO extends CapellaBridgeAlgo<?>>
		extends AbstractDynamicMapping<SOURCE_CONTAINER, CapellaElement, ALGO> {

	public CommonDescriptionMapping(ALGO algo, SOURCE_CONTAINER parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(SOURCE_CONTAINER capellaContainer) {
		Project capellaProject = ProjectExt.getProject(capellaContainer);
		Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
		return model;
	}

	@Override
	public List<CapellaElement> findSourceElements(SOURCE_CONTAINER capellaContainer) {
		List<CapellaElement> collect = EObjectExt.getAll(capellaContainer, CapellacorePackage.Literals.CAPELLA_ELEMENT)
				.stream().map(CapellaElement.class::cast).filter(ce -> hasDescription(ce)).collect(Collectors.toList());

		return collect;
	}

	public boolean hasDescription(CapellaElement ce) {
		if (ce.getDescription() != null && !ce.getDescription().isEmpty()) {
			return true;
		}
		return false;
	}

}

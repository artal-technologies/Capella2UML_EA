/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.polarsys.capella.core.data.capellacore.CapellaElement;

import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class AlternativeComponentMapping extends ComponentMapping {

	/**
	 * @param algo
	 * @param component
	 * @param execution
	 */
	public AlternativeComponentMapping(Capella2UMLAlgo algo, CapellaElement component, IMappingExecution execution) {
		super(algo, component, execution);
	}

	@Override
	public void executeSubRules(List<org.polarsys.capella.core.data.cs.Component> _capellaSource, MappingRulesManager manager) {
		for (org.polarsys.capella.core.data.cs.Component logicalComponent : _capellaSource) {
			ComponentMapping componentMapping = new AlternativeComponentMapping(getAlgo(), logicalComponent,
					getMappingExucution());
			AlternativePortMapping portMapping = new AlternativePortMapping(getAlgo(), logicalComponent,
					getMappingExucution());

			manager.add(AlternativeComponentMapping.class.getName() + logicalComponent.getId(), componentMapping);
			manager.add(PortMapping.class.getName() + logicalComponent.getId(), portMapping);

		}

		for (org.polarsys.capella.core.data.cs.Component logicalComponent : _capellaSource) {
			AggregationMapping aggregationMapping = new AggregationMapping(getAlgo(), logicalComponent,
					getMappingExucution());
			manager.add(aggregationMapping.getClass().getName(), aggregationMapping);
		}

	}

}

/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.ComponentPort;

import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class AlternativePortMapping extends PortMapping {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public AlternativePortMapping(Capella2UMLAlgo algo, Component parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public void executeSubRules(List<ComponentPort> _capellaSource, MappingRulesManager manager) {
		super.executeSubRules(_capellaSource, manager);

		for (ComponentPort componentPort : _capellaSource) {
			PortInterfaceMapping interfaceMapping = new PortInterfaceMapping(getAlgo(), componentPort,
					getMappingExucution());
			manager.add(interfaceMapping.getClass().getName() + componentPort.getId(), interfaceMapping);
		}
	}

}

/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.mix;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.RootMapping;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 */
public class DefaultCapella2UMLMix extends AbstractMappingAlgoMix<Project, Capella2UMLAlgo> {

	MappingRulesManager _manager = new MappingRulesManager();

	@Override
	public void launch(Capella2UMLAlgo algo, Project source, IMappingExecution execution) {
		RootMapping rootMapping = new RootMapping(algo, source, execution);
		_manager.add(rootMapping.getClass().getName(), rootMapping);

		_manager.executeRules();
	}

	@Override
	public String getMixName() {
		return "Logical Architecture";
	}

}

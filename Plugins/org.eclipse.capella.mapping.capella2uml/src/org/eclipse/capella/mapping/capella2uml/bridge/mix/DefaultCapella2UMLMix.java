/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.mix;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.RootMapping;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;

/**
 * @author binot
 */
public class DefaultCapella2UMLMix extends AbstractMappingAlgoMix<Project, Capella2UMLAlgo> {

	// MappingRulesManager _manager = new MappingRulesManager();

	@Override
	public void launch(Capella2UMLAlgo algo, Project source, IMappingExecution execution) {
		RootMapping rootMapping = new RootMapping(algo, source, execution);
		getManagerRules().add(rootMapping.getClass().getName(), rootMapping);

		getManagerRules().executeRules();
	}

	@Override
	public String getMixName() {
		return "Logical Architecture (partially)";
	}

	@Override
	public String getPackageName() {
		return "Transformed from Capella Logical Architecture (partially)";
	}


}

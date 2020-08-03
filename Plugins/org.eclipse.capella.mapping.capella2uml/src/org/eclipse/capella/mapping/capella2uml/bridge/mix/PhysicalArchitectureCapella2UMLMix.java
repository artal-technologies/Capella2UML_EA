/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.mix;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.PhysicalRootMapping;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.RootMapping;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;

/**
 * @author binot
 */
public class PhysicalArchitectureCapella2UMLMix extends AbstractMappingAlgoMix<Project, Capella2UMLAlgo> {

	// MappingRulesManager _manager = new MappingRulesManager();

	@Override
	public void launch(Capella2UMLAlgo algo, Project source, IMappingExecution execution) {
		PhysicalRootMapping rootMapping = new PhysicalRootMapping(algo, source, execution);
		getManagerRules().add(rootMapping.getClass().getName(), rootMapping);

		getManagerRules().executeRules();
	}

	@Override
	public String getMixName() {
		return "Import Capella PA/Interfaces from Capella Interfaces";
	}

	
	@Override
	public String getPackageName() {
		return "Physical Architecture";
	}
	
}

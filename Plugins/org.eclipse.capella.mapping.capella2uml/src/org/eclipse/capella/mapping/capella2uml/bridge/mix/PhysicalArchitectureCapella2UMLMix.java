/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.mix;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.EAMappingService;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.PhysicalRootMapping;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;

/**
 * @author binot
 */
public class PhysicalArchitectureCapella2UMLMix
		extends AbstractMappingAlgoMix<Project, Capella2UMLAlgo, EAMappingService> {

	// MappingRulesManager _manager = new MappingRulesManager();

	public PhysicalArchitectureCapella2UMLMix(EAMappingService mappingService) {
		super(mappingService);
	}

	@Override
	public void launch(Capella2UMLAlgo algo, Project source, IMappingExecution execution) {
		PhysicalRootMapping rootMapping = new PhysicalRootMapping(algo, source, execution, getMappingService().isExportProfile());
		getManagerRules().add(rootMapping.getClass().getName(), rootMapping);

		getManagerRules().executeRules();
	}

	@Override
	public String getMixName() {
		return "Physical Architecture (partially)";
	}

	@Override
	public String getPackageName() {
		return "Transformed from Capella Physical Architecture (partially)";
	}

}

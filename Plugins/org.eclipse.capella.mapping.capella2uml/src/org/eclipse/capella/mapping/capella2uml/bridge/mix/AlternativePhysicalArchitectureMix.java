/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.mix;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.EAMappingService;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.AlternativePhysicalRootMapping;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;

/**
 * @author binot
 *
 */
public class AlternativePhysicalArchitectureMix extends AbstractMappingAlgoMix<Project, Capella2UMLAlgo, EAMappingService> {
	
	public AlternativePhysicalArchitectureMix(EAMappingService mappingService) {
		super(mappingService);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.mix.AbstractMappingAlgoMix#launch(com.artal.capella
	 * .mapping.CapellaBridgeAlgo, java.lang.Object,
	 * org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution)
	 */
	@Override
	public void launch(Capella2UMLAlgo algo, Project source, IMappingExecution execution) {
		AlternativePhysicalRootMapping rootMapping = new AlternativePhysicalRootMapping(algo, source, execution,
				getMappingService().isExportProfile());
		getManagerRules().add(rootMapping.getClass().getName(), rootMapping);

		getManagerRules().executeRules();
	}

	@Override
	public String getMixName() {
		return "Physical Architecture Component Exchanges to Interfaces (partially)";
	}
	
	@Override
	public String getPackageName() {
		return "Transformed from Capella PA CE to Interfaces";
	}

}

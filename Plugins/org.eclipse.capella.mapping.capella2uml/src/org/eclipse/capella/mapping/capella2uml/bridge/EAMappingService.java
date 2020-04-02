/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.mix.AlternativePhysicalArchitectureMix;
import org.eclipse.capella.mapping.capella2uml.bridge.mix.DefaultCapella2UMLMix;
import org.eclipse.capella.mapping.capella2uml.bridge.mix.PhysicalArchitectureCapella2UMLMix;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osgi.service.component.annotations.Component;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;
import com.artal.capella.mapping.services.MappingService;

/**
 * @author binot
 *
 */
@Component
public class EAMappingService implements MappingService {

	/**
	 * 
	 */
	public EAMappingService() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.artal.capella.mapping.services.MappingService#getTransfoName()
	 */
	@Override
	public String getTransfoName() {
		return "Capella to Enterprise Architect";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.services.MappingService#createBridgeJob(java.lang.
	 * String, org.polarsys.capella.core.data.capellamodeller.Project,
	 * org.eclipse.emf.common.util.URI,
	 * com.artal.capella.mapping.mix.AbstractMappingAlgoMix)
	 */
	@Override
	public BridgeJob<?> createBridgeJob(String jobName_p, Project sourceDataSet_p, URI targetURI_p,
			AbstractMappingAlgoMix<?, ?> mix) {
		Capella2UMLBridgeJob job = new Capella2UMLBridgeJob("", sourceDataSet_p, targetURI_p, mix);
		return job;
	}

	@Override
	public List<AbstractMappingAlgoMix<?, ?>> getMixes() {
		List<AbstractMappingAlgoMix<?, ?>> results = new ArrayList<AbstractMappingAlgoMix<?, ?>>();

		DefaultCapella2UMLMix mix = new DefaultCapella2UMLMix();
		PhysicalArchitectureCapella2UMLMix pamix = new PhysicalArchitectureCapella2UMLMix();
		AlternativePhysicalArchitectureMix altMix = new AlternativePhysicalArchitectureMix();
		results.add(mix);
		results.add(pamix);
		results.add(altMix);

		return results;
	}

	@Override
	public Control getOrCreateSpecificView(Composite specificGroup) {

		return null;
	}

	@Override
	public String getExtension() {
		return "xml";
	}

}

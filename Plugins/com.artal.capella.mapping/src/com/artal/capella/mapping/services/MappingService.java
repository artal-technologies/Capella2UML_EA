/**
 * 
 */
package com.artal.capella.mapping.services;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;

/**
 * @author binot
 *
 */
public interface MappingService {

	String getTransfoName();

	BridgeJob<?> createBridgeJob(String jobName_p, Project sourceDataSet_p, URI targetURI_p,
			AbstractMappingAlgoMix<?, ?, ?> mix);

	List<AbstractMappingAlgoMix<?, ?, ?>> getMixes();

	Control getOrCreateSpecificView(Composite specificGroup);

	String getExtension();

	void postProcess(String _outputPath);

}

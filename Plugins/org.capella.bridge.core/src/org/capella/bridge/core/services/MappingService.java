/*******************************************************************************
* Copyright (c) 2021 THALES GLOBAL SERVICES.
* All right reserved. This program and the accompanying materials are made 
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
*     Artal Technologies - initial API and implementation
*******************************************************************************/
package org.capella.bridge.core.services;

import java.util.List;

import org.capella.bridge.core.mix.AbstractMappingAlgoMix;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.polarsys.capella.core.data.capellamodeller.Project;

/**
 * @author Artal
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

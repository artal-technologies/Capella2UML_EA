/*******************************************************************************
* Copyright (c) 2021 THALES GLOBAL SERVICES.
* All right reserved. This program and the accompanying materials are made 
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
*     Artal Technologies - initial API and implementation
*******************************************************************************/
package com.artal.capella.mapping.mix;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author Artal
 *
 */
abstract public class AbstractMappingAlgoMix<SOURCE, ALGO extends CapellaBridgeAlgo<?>, MAPPINGSERVICE> {

	MAPPINGSERVICE mappingService;

	MappingRulesManager _managerRules = new MappingRulesManager();

	abstract public void launch(ALGO algo, SOURCE source, IMappingExecution execution);

	abstract public String getMixName();

	abstract public String getPackageName();

	public AbstractMappingAlgoMix(MAPPINGSERVICE mappingService) {
		this.mappingService = mappingService;
	}

	public MappingRulesManager getManagerRules() {
		return _managerRules;
	}

	public MAPPINGSERVICE getMappingService() {
		return mappingService;
	}

}

/**
 * 
 */
package com.artal.capella.mapping.mix;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
abstract public class AbstractMappingAlgoMix<SOURCE, ALGO extends CapellaBridgeAlgo<?>> {


	MappingRulesManager _managerRules= new MappingRulesManager();


	abstract public void launch(ALGO algo, SOURCE source, IMappingExecution execution);

	abstract public String getMixName();

	public MappingRulesManager getManagerRules() {
		return _managerRules;
	}
	
}

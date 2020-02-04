/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.uml2.uml.Profile;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.uml.UMLBridgeAlgo;

import xmi.Extension;

/**
 * @author binot
 *
 */
public class Capella2UMLAlgo extends UMLBridgeAlgo<Project> {

	public Capella2UMLAlgo(AbstractMappingAlgoMix<?, ?> mix) {
		super(mix);
	}

	private Extension _xmiExtension;
	private List<Profile> _profiles;

	@Override
	public void launch(Project source_p, IMappingExecution _mappingExecution) {
		MappingRulesManager.clearRules();

		super.launch(source_p, _mappingExecution);
	}

	public void setXMIExtension(Extension xmiExtension) {
		_xmiExtension = xmiExtension;
	}

	public Extension getXMIExtension() {
		return _xmiExtension;
	}

	public List<Profile> getProfiles() {
		if (_profiles == null) {
			_profiles = new ArrayList<>();
		}
		return _profiles;
	}

	/**
	 * @return
	 */
	public boolean useUIDs() {
		return true;
	}

	/**
	 * @return
	 */
	public boolean createUIDs() {
		return true;
	}

}

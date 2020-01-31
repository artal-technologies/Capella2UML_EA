/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge;

import java.util.Map;

import org.eclipse.capella.mapping.capella2uml.bridge.mix.DefaultCapella2UMLMix;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.uml.UMLBridgeJob;

/**
 * @author binot
 *
 */
public class Capella2UMLBridgeJob extends UMLBridgeJob<Project> {

	public Capella2UMLBridgeJob(String jobName_p, Project sourceDataSet_p, URI targetURI_p, DefaultCapella2UMLMix mix) {
		super(sourceDataSet_p, targetURI_p, new Capella2UMLAlgo(mix));
	}

	public void setTargetParentFolder(String folder) {

	}

	@Override
	protected Resource getCreateTraceResource(URI uri_p) {
		return super.getCreateTargetResource(uri_p);
	}

	/**
	 * @param saveOptions
	 */
	public void addOptions(final Map<Object, Object> saveOptions) {
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
	}

	/**
	 * @return
	 */
	public String getXMIVersion() {
		return XMIResource.VERSION_2_1_VALUE;
	}

	/**
	 * @return
	 */
	public String getEncoding() {
		return "windows-1252";
	}


}

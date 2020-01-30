/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.bridge.api.incremental.IIncrementalBridgeExecution;
import org.eclipse.emf.diffmerge.bridge.interactive.Messages;
import org.eclipse.emf.diffmerge.bridge.interactive.util.ResourceUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLInfoImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;
import com.artal.capella.mapping.uml.UMLBridgeJob;

/**
 * @author binot
 *
 */
public class Capella2UMLBridgeJob extends UMLBridgeJob<Project> {

	public Capella2UMLBridgeJob(String jobName_p, Project sourceDataSet_p, URI targetURI_p,
			AbstractMappingAlgoMix<?, ?> mix) {
		super(sourceDataSet_p, targetURI_p, new Capella2UMLAlgo(mix));
	}

	public void setTargetParentFolder(String folder) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Resource getCreateTraceResource(URI uri_p) {
		return super.getCreateTargetResource(uri_p);
	}

	@Override
	protected Resource getCreateTargetResource(URI uri_p) {
		// TODO Auto-generated method stub
		XMIResourceImpl resource = (XMIResourceImpl) getTargetResourceSet().getResource(uri_p, false);
		if (resource == null) {
			resource = new XMIResourceImpl(uri_p) {
				protected boolean useUUIDs() {
					return true;
				};

				@Override
				protected void attachedHelper(EObject eObject) {
					if (isTrackingModification()) {
						eObject.eAdapters().add(modificationTrackingAdapter);
					}

					Map<String, EObject> map = getIntrinsicIDToEObjectMap();
					if (map != null) {
						String id = EcoreUtil.getID(eObject);
						if (id != null) {
							map.put(id, eObject);
						}
					}

					if (useIDs()) {
						String id = getID(eObject);
						if (useUUIDs() && id == null) {
							if (assignIDsWhileLoading() || !isLoading()) {
								id = DETACHED_EOBJECT_TO_ID_MAP.remove(eObject);
								if (id == null) {
									id = ((Capella2UMLAlgo) getAlgo())._eaIds.get(eObject);
									// id = EcoreUtil.generateUUID();
								}
								setID(eObject, id);
							}
						} else if (id != null) {
							getIDToEObjectMap().put(id, eObject);
						}
					}
				}
			};
			getTargetResourceSet().getResources().add(resource);
			ResourceUtil.ensureLoaded(resource);
		}
		// XMIResource createTargetResource = (XMIResource)
		// super.getCreateTargetResource(uri_p);
		resource.setEncoding("windows-1252");
		resource.setXMIVersion(XMIResource.VERSION_2_1_VALUE);
		// try {
		// createTargetResource.load(options);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		return resource;
	}

	/**
	 * Ensure that the given resource becomes persistent and save its contents
	 * 
	 * @param resource_p
	 *            a non-null resource
	 * @return whether the operation succeeded
	 */
	public static boolean makePersistent(Resource resource_p) {
		boolean result = false;
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);

		// XMLResource.XMLMap xmlMap = new XMLMapImpl();
		// xmlMap.add(EcorePackage.Literals.ECLASS__INTERFACE, createXMLInfo()); // no
		// property
		// EMOFExtendedMetaData extend = new EMOFExtendedMetaData(xmlMap);
		//
		// saveOptions.put(XMIResource.OPTION_EXTENDED_META_DATA, extend);
		// XMIResourceFactoryImpl t ; t.

		try {
			resource_p.save(saveOptions);
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	// static protected XMLResource.XMLInfo createXMLInfo() {
	// XMLResource.XMLInfo info = new XMLInfoImpl();
	// info.setXMLRepresentation(XMLResource.XMLInfo.ELEMENT); // We will use an
	// xmi:Extension element for these
	// return info;
	// }

	@Override
	protected void saveAndClose(IIncrementalBridgeExecution execution_p, Resource targetResource_p,
			Resource traceResource_p, IProgressMonitor monitor_p) {
		// Save and unload
		monitor_p.subTask(Messages.BridgeJob_Step_Completion);
		monitor_p.worked(1);
		if (!execution_p.isActuallyIncremental())
			setTrace(traceResource_p, execution_p.getTrace());
		if (!traceResource_p.getContents().isEmpty())
			ResourceUtil.makePersistent(traceResource_p);
		ResourceUtil.closeResource(traceResource_p);
		if (isSaveAndCloseTarget()) {
			makePersistent(targetResource_p);
			ResourceUtil.closeResource(targetResource_p);
		}
	}

}

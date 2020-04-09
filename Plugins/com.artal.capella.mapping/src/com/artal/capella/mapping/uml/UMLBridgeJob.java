/*******************************************************************************
 * Copyright (c) 2019 Artal Technologies.
 * This program and the accompanying materials are made 
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Artal Technologies - initial API and implementation
 *******************************************************************************/
package com.artal.capella.mapping.uml;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace.Editable;
import org.eclipse.emf.diffmerge.bridge.api.incremental.IIncrementalBridge;
import org.eclipse.emf.diffmerge.bridge.api.incremental.IIncrementalBridgeExecution;
import org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob;
import org.eclipse.emf.diffmerge.bridge.interactive.EMFInteractiveBridge;
import org.eclipse.emf.diffmerge.bridge.interactive.Messages;
import org.eclipse.emf.diffmerge.bridge.interactive.util.ResourceUtil;
import org.eclipse.emf.diffmerge.bridge.traces.gen.bridgetraces.impl.TraceImpl;
import org.eclipse.emf.diffmerge.bridge.uml.incremental.UMLMergePolicy;
import org.eclipse.emf.diffmerge.gmf.GMFDiffPolicy;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.progress.IProgressConstants;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.cheat.TraceCheat;

/**
 * @author YBI
 *
 */
public class UMLBridgeJob<SD> extends BridgeJob<SD> {

	UMLBridgeAlgo<SD> _algo;

	UMLBridge<SD, IEditableModelScope> _mappingBridge;

	/**
	 * Constructor
	 * 
	 * @param context_p
	 *            a non-null physical architecture
	 */
	public UMLBridgeJob(SD context_p, URI targetURI_p, UMLBridgeAlgo<SD> algo) {
		super("UML Bridge Job", context_p, targetURI_p);
		setProperty(IProgressConstants.PROPERTY_IN_DIALOG, true);
		_algo = algo;
	}

	@Override
	protected ResourceSet initializeTargetResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new EMOFResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION,
				UMLResource.Factory.INSTANCE);
		return resourceSet;
	}

	protected Profile loadSysMLProfileForBridge() {
		return null;
	}

	/**
	 * @see org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob#getBridge()
	 */
	@Override
	protected EMFInteractiveBridge<SD, IEditableModelScope> getBridge() {
		createMappingBridge();
		_mappingBridge.registerRules();
		// Make the mapping bridge incremental
		GMFDiffPolicy diffPolicy = createDiffPolicy();
		diffPolicy.setIgnoreOrders(true);
		EMFInteractiveBridge<SD, IEditableModelScope> result = new EMFInteractiveBridge<SD, IEditableModelScope>(
				_mappingBridge, diffPolicy, new UMLMergePolicy(), null) {

			/**
			 * @see org.eclipse.emf.diffmerge.bridge.incremental.EMFIncrementalBridge#createTrace()
			 */
			@Override
			protected Editable createTrace() {
				TraceImpl trace = new TraceImpl() {
					/** {@inheritDoc} */
					@Override
					public String putCause(Object cause_p, Object target_p) {
						if (target_p == null) {
							return null;
						}

						if (target_p instanceof TraceCheat) {
							TraceCheat<?> cheat = (TraceCheat<?>) target_p;
							String stringCause = cheat.getCause();
							EObject targetItem = cheat.getTarget();
							return super.putCause(stringCause, targetItem);
						} else {
							return super.putCause(cause_p, target_p);
						}

					}
				};
				return trace;
			}

		};
		return result;
	}

	protected GMFDiffPolicy createDiffPolicy() {
		GMFDiffPolicy diffPolicy = new GMFDiffPolicy() {
			public boolean coverOutOfScopeValue(EObject element_p, org.eclipse.emf.ecore.EReference reference_p) {
				return false;
			};
		};
		return diffPolicy;
	}

	public UMLBridge<SD, IEditableModelScope> createMappingBridge() {
		_mappingBridge = new UMLBridge<SD, IEditableModelScope>(_algo) {
			@Override
			public Profile loadSysMLProfile() throws Exception {
				return loadSysMLProfileForBridge();
			}
		};
		return _mappingBridge;
	}

	public CapellaBridgeAlgo<SD> getAlgo() {
		return _algo;
	}

	public UMLBridge<SD, IEditableModelScope> getMappingBridge() {
		return _mappingBridge;
	}

	public XMLSave createOwnXMLSave(XMLHelper xmlHelper) {
		return new XMISaveImpl(xmlHelper);
	}

	protected XMLHelper createOwnedXMLHelper(XMIResource resource) {
		return new XMIHelperImpl(resource);
	}

	@Override
	protected Resource getCreateTargetResource(URI uri_p) {
		Resource resource = null;
		if (getAlgo().getManageUIDs().isCreateUIDs()) {
			resource = (XMIResourceImpl) getTargetResourceSet().getResource(uri_p, false);
			if (resource == null) {
				resource = new XMIResourceImpl(uri_p) {
					@Override
					protected XMLSave createXMLSave() {
						return createOwnXMLSave(createOwnedXMLHelper(this));
					}

					protected boolean useUUIDs() {
						return getAlgo().getManageUIDs().isUseUIDs();
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
										id = ((CapellaBridgeAlgo<?>) getAlgo()).getManageUIDs().getUId(eObject);
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
		} else {
			resource = super.getCreateTargetResource(uri_p);
		}
		if (resource instanceof XMIResource) {
			((XMIResource) resource).setEncoding(getEncoding());
			((XMIResource) resource).setXMIVersion(getXMIVersion());
		}
		return resource;
	}

	// @Override
	// protected void saveAndClose(IIncrementalBridgeExecution execution_p,
	// Resource targetResource_p,
	// Resource traceResource_p, IProgressMonitor monitor_p) {
	// // Save and unload
	// monitor_p.subTask(Messages.BridgeJob_Step_Completion);
	// monitor_p.worked(1);
	// if (!execution_p.isActuallyIncremental())
	// setTrace(traceResource_p, execution_p.getTrace());
	// if (!traceResource_p.getContents().isEmpty())
	// ResourceUtil.makePersistent(traceResource_p);
	// ResourceUtil.closeResource(traceResource_p);
	// if (isSaveAndCloseTarget()) {
	// makePersistent(targetResource_p);
	// ResourceUtil.closeResource(targetResource_p);
	// }
	// }

	/**
	 * An action that triggers the deferred completion of the execution of a
	 * bridge.
	 */
	protected static class CapellaDeferredBridgeExecutionAction extends Action
			implements ActionFactory.IWorkbenchAction {
		/** The initially non-null bridge */
		private IIncrementalBridge<?, ?, ?> _bridge;
		/** The initially non-null ongoing execution */
		private IIncrementalBridgeExecution _execution;
		/** The initially non-null target resource */
		private Resource _targetResource;
		/** The initially non-null trace resource */
		private Resource _traceResource;
		/** Whether the target must be saved and closed when done */
		private boolean _isSaveAndCloseTarget;
		/** The initially null execution status */
		private IStatus _status;
		/** The initially non-null progress monitor */
		private SubMonitor _monitor;
		private UMLBridgeJob<?> _bridgeJob;

		/**
		 * Constructor
		 * 
		 * @param bridge_p
		 *            the non-null bridge whose execution has to be completed
		 * @param execution_p
		 *            the non-null ongoing execution of the bridge
		 * @param monitor_p
		 *            a non-null progress monitor
		 */
		public CapellaDeferredBridgeExecutionAction(IIncrementalBridge<?, ?, ?> bridge_p,
				IIncrementalBridgeExecution execution_p, Resource targetResource_p, Resource traceResource_p,
				boolean isSaveAndCloseTarget_p, SubMonitor monitor_p, UMLBridgeJob<?> bridgeJob) {
			super(Messages.BridgeJob_ActionText);
			_bridge = bridge_p;
			_execution = execution_p;
			_targetResource = targetResource_p;
			_traceResource = traceResource_p;
			_isSaveAndCloseTarget = isSaveAndCloseTarget_p;
			_status = null;
			_monitor = monitor_p;
			_bridgeJob = bridgeJob;
		}

		/**
		 * @see org.eclipse.ui.actions.ActionFactory.IWorkbenchAction#dispose()
		 */
		public void dispose() {
			if (_execution instanceof IIncrementalBridgeExecution.Editable)
				((IIncrementalBridgeExecution.Editable) _execution).setInteractiveMergeData(null);
			_bridge = null;
			_execution = null;
			_targetResource = null;
			_traceResource = null;
			_monitor = null;
			_status = null;
			setEnabled(false);
		}

		/**
		 * Return the status of the execution of the action
		 * 
		 * @return a potentially null object
		 */
		public IStatus getStatus() {
			return _status;
		}

		/**
		 * @see org.eclipse.jface.action.Action#run()
		 */
		@Override
		public void run() {
			// Interactive merge
			_status = _bridge.mergeInteractively(_execution, _monitor);
			if (_status.isOK()) {
				// Save and unload
				_monitor.subTask(Messages.BridgeJob_Step_Completion);
				_monitor.worked(1);
				if (!_execution.isActuallyIncremental())
					setTrace(_traceResource, _execution.getTrace());
				if (!_traceResource.getContents().isEmpty())
					ResourceUtil.makePersistent(_traceResource);
				ResourceUtil.closeResource(_traceResource);
				if (_isSaveAndCloseTarget) {
					_bridgeJob.makePersistent(_targetResource);
					ResourceUtil.closeResource(_targetResource);
				}
			}
			if (_status.isOK() || _status.getSeverity() == IStatus.CANCEL || _status.getSeverity() == IStatus.INFO
					&& EMFInteractiveBridge.STATUS_SWITCH_TO_EDITOR.equals(_status.getMessage())) {
				_monitor.done();
				dispose();
			}
		}
	}

	protected void handleDeferrablePart(IIncrementalBridge<?, ?, ?> bridge_p,
			final IIncrementalBridgeExecution execution_p, Resource targetResource_p, Resource traceResource_p,
			final SubMonitor monitor_p) {
		monitor_p.subTask(Messages.BridgeJob_Step_InteractiveUpdate);
		// Defining the remaining part of the bridge process in a deferrable
		// action
		CapellaDeferredBridgeExecutionAction deferrableAction = new CapellaDeferredBridgeExecutionAction(bridge_p,
				execution_p, targetResource_p, traceResource_p, isSaveAndCloseTarget(), monitor_p, this);
		setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
		setProperty(IProgressConstants.ACTION_PROPERTY, deferrableAction);
		if (isModal()) {
			// The user has waited: immediate execution
			logger.info(Messages.BridgeLogger_InteractiveMergeStepMessage);
			deferrableAction.run();
			IStatus status = deferrableAction.getStatus();
			if (status != null) {
				if (status.getSeverity() == IStatus.CANCEL) {
					deferrableAction.dispose();
				} else if (status.getSeverity() == IStatus.INFO) {
					// Still ongoing: show progress view if possible
					final Display display = Display.getDefault();
					display.syncExec(new Runnable() {
						/**
						 * @see java.lang.Runnable#run()
						 */
						public void run() {
							try {
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
										.showView(IProgressConstants.PROGRESS_VIEW_ID);
							} catch (Exception e) {
								// Proceed
							}
						}
					});
				}
			}
		}
	}

	/**
	 * Ensure that the given resource becomes persistent and save its contents
	 * 
	 * @param resource_p
	 *            a non-null resource
	 * @return whether the operation succeeded
	 */
	public boolean makePersistent(Resource resource_p) {
		boolean result = false;
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		addOptions(saveOptions);

		try {
			resource_p.save(saveOptions);
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param saveOptions
	 */
	public void addOptions(final Map<Object, Object> saveOptions) {
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
	}

	/**
	 * @return
	 */
	public String getXMIVersion() {
		return XMIResource.VERSION_VALUE;
	}

	/**
	 * @return
	 */
	public String getEncoding() {
		return "ASCII";
	}

}

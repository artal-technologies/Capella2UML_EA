/**
 * 
 */
package com.artal.capella.mapping.ui;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.bridge.capella.integration.policies.Messages;
import org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.la.LogicalArchitecture;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;
import com.artal.capella.mapping.services.BridgeLicenseCheck;
import com.artal.licensing.ArtalFeature;
import com.artal.licensing.InvalidPrivilegeException;
import com.artal.licensing.LicenseUtils;

/**
 * @author binot
 *
 */
public class TransfoExportHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		new BridgeLicenseCheck() {
			@Override
			public void action() throws ExecutionException {
				StructuredSelection currentSelection = (StructuredSelection) HandlerUtil.getCurrentSelection(event);
				CapellaMappingDialog dialog = new CapellaMappingDialog(Display.getCurrent().getActiveShell());
				int status = dialog.open();

				String umlPath = null;
				AbstractMappingAlgoMix<?, ?, ?> mix = null;

				if (status == IStatus.OK) {

					umlPath = dialog.getOutputPath();

					mix = dialog.getMix();
				}

				if (umlPath == null || mix == null) {
					return;
				}

				File file = new File(umlPath);
				if (file.exists()) {
					boolean openConfirm = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(),
							"Overwritte existing output file",
							"Are you sure to overwrite the existing " + file.getName() + " file ?");
					if (!openConfirm) {
						return;
					} else {
						file.delete();
					}

				}

				// String folder = umlPath.substring(0, umlPath.lastIndexOf(File.separator));
				URI targetUri = URI.createFileURI(umlPath);

				CapellaElement firstElement = (CapellaElement) currentSelection.getFirstElement();
				Resource capellaResource = firstElement.eResource();
				ResourceSet resourceSet = capellaResource.getResourceSet();
				URI semanticResourceURI = capellaResource.getURI().trimFileExtension()
						.appendFileExtension("melodymodeller");
				Resource semanticResource = resourceSet.getResource(semanticResourceURI, false);
				Project context = null;
				if (semanticResource != null) {
					EObject root = semanticResource.getContents().get(0);
					if (root instanceof Project) {
						context = (Project) root;
					}
				}

				if (context != null) {
					if (targetUri != null) {

						// TODO
						// Capella2UMLBridgeJob job = new Capella2UMLBridgeJob("", context, targetUri,
						// mix);
						// bridgeJob.setTargetParentFolder(folder);
						BridgeJob<?> bridgeJob = dialog.createBridgeJob("", context, targetUri, mix);

						ProgressMonitorDialog pmd = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
						try {
							pmd.run(false, false, new IRunnableWithProgress() {

								@Override
								public void run(IProgressMonitor monitor)
										throws InvocationTargetException, InterruptedException {
									bridgeJob.run(monitor);

								}
							});
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}
				// for this moment the bridge trace is not saved
				File f = new File(umlPath + ".bridgetraces");
				if (f.exists()) {
					f.delete();
				}

				dialog.postProcess();
			}
		};
		return null;
	}
}

/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.ui;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLBridgeJob;
import org.eclipse.capella.mapping.capella2uml.bridge.mix.DefaultCapella2UMLMix;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.la.LogicalArchitecture;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;

/**
 * @author binot
 *
 */
public class EAExportHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		StructuredSelection currentSelection = (StructuredSelection) HandlerUtil.getCurrentSelection(event);
		Capella2UMLLaunchDialog dialog = new Capella2UMLLaunchDialog(Display.getCurrent().getActiveShell());
		int status = dialog.open();

		String umlPath = null;
		DefaultCapella2UMLMix mix = null;

		if (status == IStatus.OK) {

			umlPath = dialog.getUmlPath();
			mix = dialog.getMix();
		}

		if (umlPath == null || mix == null) {
			return null;
		}

		String folder = umlPath.substring(0, umlPath.lastIndexOf(File.separator));
		URI targetUri = URI.createFileURI(umlPath);

		LogicalArchitecture firstElement = (LogicalArchitecture) currentSelection.getFirstElement();
		Resource capellaResource = firstElement.eResource();
		ResourceSet resourceSet = capellaResource.getResourceSet();
		URI semanticResourceURI = capellaResource.getURI().trimFileExtension().appendFileExtension("melodymodeller");
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

				Capella2UMLBridgeJob job = new Capella2UMLBridgeJob("", context, targetUri, mix);
				job.setTargetParentFolder(folder);
				ProgressMonitorDialog pmd = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
				try {
					pmd.run(false, false, new IRunnableWithProgress() {

						@Override
						public void run(IProgressMonitor monitor)
								throws InvocationTargetException, InterruptedException {
							job.run(monitor);

						}
					});
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

//				try {
//					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//					DocumentBuilder builder = factory.newDocumentBuilder();
//
//					Document document = builder.parse(umlPath);
//					Element racine = document.getDocumentElement();
//					if (racine.getNodeName().equals("xmi:XMI")) {
//						Element documentation = document.createElement("xmi:Documentation");
//						documentation.setAttribute("exporter", "Enterprise Architect");
//						documentation.setAttribute("exporterVersion", "6.5");
//						racine.insertBefore(documentation, racine.getFirstChild());
//					}
//
//					TransformerFactory transformerFactory = TransformerFactory.newInstance();
//					Transformer transformer = transformerFactory.newTransformer();
//					DOMSource source = new DOMSource(document);
//					StreamResult result = new StreamResult(new File(umlPath));
//					transformer.transform(source, result);
//
//				} catch (ParserConfigurationException e) {
//					e.printStackTrace();
//				} catch (SAXException e) {
//					e.printStackTrace();
//				} catch (IOException e) {
//					e.printStackTrace();
//				} catch (TransformerConfigurationException e) {
//					e.printStackTrace();
//				} catch (TransformerException e) {
//					e.printStackTrace();
//				}

			}
		}
		return null;
	}

}

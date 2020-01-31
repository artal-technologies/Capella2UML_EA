/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.ui;

import java.io.File;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.mix.DefaultCapella2UMLMix;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;

/**
 * @author binot
 *
 */
public class Capella2UMLLaunchDialog extends TitleAreaDialog {

	private String _umlPath = "";

	private DefaultCapella2UMLMix _selectedMix = null;

	public Capella2UMLLaunchDialog(Shell parentShell) {
		super(parentShell);
	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Launch Export Capella to Enterprise Architect");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		setTitle("Select a target XML file.");
		Group selectUMLGroup = new Group(container, SWT.NONE);
		selectUMLGroup.setText("XML selection");
		selectUMLGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
		selectUMLGroup.setLayout(new GridLayout(3, false));

		Label label = new Label(selectUMLGroup, SWT.NONE);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		label.setText("Select a target XML Enterprise Architect file");

		Text umlText = new Text(selectUMLGroup, SWT.BORDER);
		umlText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		umlText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				_umlPath = umlText.getText();
				validate();

			}
		});
		Button button = new Button(selectUMLGroup, SWT.NONE);
		button.setLayoutData(new GridData());
		button.setText("Browse..");

		button.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell());
				dialog.setFilterExtensions(new String[] { "*.xml" });
				String filePath = dialog.open();
				if (!filePath.endsWith(".xml")) {
					filePath += ".xml";
				}
				umlText.setText(filePath);

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);

			}
		});

		Label mixLabel = new Label(selectUMLGroup, SWT.NONE);
		mixLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		mixLabel.setText("Select an predifined alternative algorithm");

		ComboViewer combo = new ComboViewer(selectUMLGroup, SWT.NONE);
		combo.getCombo().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		combo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof DefaultCapella2UMLMix) {
					return ((DefaultCapella2UMLMix) element).getMixName();
				}
				return super.getText(element);
			}
		});
		combo.add(new DefaultCapella2UMLMix());

		combo.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				DefaultCapella2UMLMix firstElement = (DefaultCapella2UMLMix) selection.getFirstElement();
				_selectedMix = firstElement;
				validate();
			}
		});

		return container;
	}

	public String getUmlPath() {
		return _umlPath;
	}

	@Override
	protected Control createButtonBar(Composite parent) {

		Control createButtonBar = super.createButtonBar(parent);
		validate();
		return createButtonBar;

	}

	private void validate() {
		String errorMessage = null;
		if (_umlPath == null || _umlPath.trim().isEmpty()) {
			errorMessage = "No input file.";
		} else {
			File file = new File(_umlPath);
			File parentFile = file.getParentFile();
			if (parentFile == null || !parentFile.exists()) {
				errorMessage = "Invalid parent folder.";
			}
		}
		if (_selectedMix == null) {
			errorMessage = "No selected mix";
		}
		setErrorMessage(errorMessage);
		if (errorMessage != null) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		} else {
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		}
	}

	public DefaultCapella2UMLMix getMix() {
		return _selectedMix;
	}

}

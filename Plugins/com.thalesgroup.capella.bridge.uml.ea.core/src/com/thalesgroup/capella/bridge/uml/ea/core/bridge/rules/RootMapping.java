/*******************************************************************************
* Copyright (c) 2021 THALES GLOBAL SERVICES.
* All right reserved. This program and the accompanying materials are made 
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
*     Artal Technologies - initial API and implementation
*******************************************************************************/
package com.thalesgroup.capella.bridge.uml.ea.core.bridge.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.impl.scopes.AbstractEditableModelScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.information.Class;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;

import com.artal.capella.bridge.core.CapellaUtils;
import com.artal.capella.bridge.core.MappingUtils;
import com.artal.capella.bridge.core.rules.AbstractDynamicMapping;
import com.artal.capella.bridge.core.rules.MappingRulesManager;
import com.thalesgroup.capella.bridge.uml.ea.core.bridge.Capella2UMLAlgo;
import com.thalesgroup.capella.bridge.uml.ea.core.bridge.rules.utils.SpecificUtils;
import com.thalesgroup.capella.bridge.uml.ea.model.XMIExtensionsUtils;
import com.thalesgroup.capella.bridge.uml.ea.model.xmi.Documentation;
import com.thalesgroup.capella.bridge.uml.ea.model.xmi.Extension;

/**
 * @author Yann BINOT
 *
 */
public class RootMapping extends AbstractDynamicMapping<Project, Project, Capella2UMLAlgo> {

	private boolean _pvmtExport = false;

	public RootMapping(Capella2UMLAlgo algo, Project parent, IMappingExecution execution, boolean pvmtExport) {
		super(algo, parent, execution);
		_pvmtExport = pvmtExport;
	}

	@Override
	public Object computeTargetContainer(Project capellaContainer) {

		Object targetDataSet = getMappingExucution().getTargetDataSet();

		Documentation documentationObject = XMIExtensionsUtils.createEnterpriseArchitectDocumentation();

		((AbstractEditableModelScope) targetDataSet).add(documentationObject);

		Model model = UMLFactory.eINSTANCE.createModel();
		Resource eResource = capellaContainer.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, capellaContainer);
		getAlgo().putId(model, this, sysMLID);
		((AbstractEditableModelScope) targetDataSet).add(model);
		model.setName("EA_Model");
		model.setVisibility(VisibilityKind.PUBLIC_LITERAL);

		Package createPackage = UMLFactory.eINSTANCE.createPackage();
		createPackage.setName(SpecificUtils.getCapellaImportName(this));
		LogicalArchitecture logicalArchitecture = CapellaUtils.getLogicalArchitecture(capellaContainer);
		String sysMLID2 = MappingUtils.getSysMLID(eResource, logicalArchitecture);
		getAlgo().putId(createPackage, this, sysMLID2);
		model.getPackagedElements().add(createPackage);

		Extension extensionObject = XMIExtensionsUtils
				.createEnterpriseArchitectExtension(model.getPackagedElements().get(0));
		getAlgo().setXMIExtension(extensionObject);

		((AbstractEditableModelScope) targetDataSet).add(extensionObject);
		return model;

	}

	@Override
	public List<Project> findSourceElements(Project capellaContainer) {
		List<Project> results = new ArrayList<Project>();
		results.add(capellaContainer);
		return results;
	}

	@Override
	public Object compute(Object eaContainer, Project source) {
		return eaContainer;
	}

	@Override
	public void executeSubRules(List<Project> _capellaSource, MappingRulesManager manager) {

		Project project = _capellaSource.get(0);

		LogicalArchitecture logicalArchitecture = CapellaUtils.getLogicalArchitecture(project);
		if (logicalArchitecture == null) {
			return;
		}

		DataPkg dataPkgRoot = CapellaUtils.getDataPkgRoot(project, LogicalArchitecture.class);
		// EnumerationMapping enumerationMapping = new EnumerationMapping(getAlgo(),
		// dataPkgRoot, getMappingExucution());
		// manager.add(EnumerationMapping.class.getName() + dataPkgRoot.getId(),
		// enumerationMapping);
		//
		// PrimitiveMapping primitiveMapping = new PrimitiveMapping(getAlgo(),
		// dataPkgRoot, getMappingExucution());
		// manager.add(primitiveMapping.getClass().getName() + dataPkgRoot.getId(),
		// primitiveMapping);
		//
		// ClassMapping classMapping = new ClassMapping(getAlgo(), dataPkgRoot,
		// getMappingExucution());
		// manager.add(ClassMapping.class.getName() + dataPkgRoot.getId(),
		// classMapping);

		if (_pvmtExport) {
			RootPropertyValuePkgMapping pvpMapping = new RootPropertyValuePkgMapping(getAlgo(), project,
					getMappingExucution());
			manager.add(RootPropertyValuePkgMapping.class.getName() + project.getId(), pvpMapping);
		}
		DataPkgMapping dataPkgMapping = new DataPkgMapping(getAlgo(), logicalArchitecture, getMappingExucution());
		manager.add(dataPkgMapping.getClass().getName() + logicalArchitecture.getId(), dataPkgMapping);

		List<Class> classes = EObjectExt.getAll(dataPkgRoot, InformationPackage.Literals.CLASS).stream()
				.map(Class.class::cast).collect(Collectors.toList());
		for (Class class1 : classes) {
			PropertyMapping propertyMapping = new PropertyMapping(getAlgo(), class1, getMappingExucution());
			manager.add(propertyMapping.getClass().getName() + class1.getId(), propertyMapping);
		}

		InterfacePkgMapping interfacePkgMapping = new InterfacePkgMapping(getAlgo(), logicalArchitecture,
				getMappingExucution());
		manager.add(interfacePkgMapping.getClass().getName() + logicalArchitecture.getId(), interfacePkgMapping);
		ShareDataExchangeItemMapping dataExchangeItemMapping = new ShareDataExchangeItemMapping(getAlgo(),
				logicalArchitecture, getMappingExucution());
		manager.add(dataExchangeItemMapping.getClass().getName() + logicalArchitecture.getName(),
				dataExchangeItemMapping);

		EventExchangeItemMapping eventExchangeItemMapping = new EventExchangeItemMapping(getAlgo(), logicalArchitecture,
				getMappingExucution());
		manager.add(eventExchangeItemMapping.getClass().getName() + logicalArchitecture.getName(),
				eventExchangeItemMapping);

		InterfacePkg interfacePkg = CapellaUtils.getInterfacePkgRoot(project, LogicalArchitecture.class);
		if (interfacePkg != null) {
			InterfaceMapping interfaceMapping = new InterfaceMapping(getAlgo(), interfacePkg, getMappingExucution());
			manager.add(InterfaceMapping.class.getName() + interfacePkg.getId(), interfaceMapping);
		}

		ComponentMapping componentMapping = new ComponentMapping(getAlgo(), logicalArchitecture, getMappingExucution());
		manager.add(componentMapping.getClass().getName() + logicalArchitecture.getId(), componentMapping);

		ActorPkgMapping actorPkgMapping = new ActorPkgMapping(getAlgo(), logicalArchitecture, getMappingExucution());
		manager.add(actorPkgMapping.getClass().getName() + logicalArchitecture.getId(), actorPkgMapping);

		List<Component> collect = EObjectExt.getAll(logicalArchitecture, CsPackage.Literals.COMPONENT).stream()
				.map(Component.class::cast).collect(Collectors.toList());
		for (Component component : collect) {
			ExchangeMapping mapping = new ExchangeMapping(getAlgo(), component, getMappingExucution());
			manager.add(mapping.getClass().getName() + component.getId(), mapping);
		}
		LogicalComponent logicalSystemRoot = CapellaUtils.getLogicalSystemRoot(project);
		if (logicalSystemRoot != null) {
			ExchangeMapping mapping = new ExchangeMapping(getAlgo(), (CapellaElement) logicalSystemRoot.eContainer(),
					getMappingExucution());
			manager.add(mapping.getClass().getName() + ((CapellaElement) logicalSystemRoot.eContainer()).getId(),
					mapping);
		}
//		LogicalComponentPkg logicalComponentPkg = CapellaUtils.getLogicalComponentPkg(project);
//		ActorMapping actorMapping = new ActorMapping(getAlgo(), logicalComponentPkg, getMappingExucution());
//		manager.add(logicalComponentPkg.getClass().getName() + logicalComponentPkg.getId(), actorMapping);

		DescriptionMapping descriptionMapping = new DescriptionMapping(getAlgo(), logicalArchitecture,
				getMappingExucution());
		manager.add(descriptionMapping.getClass().getName() + logicalArchitecture.getId(), descriptionMapping);

	}

	@Override
	public String getUID(EObject key, String id) {
		if (key instanceof Model) {
			return "MX_EAID_" + id;
		} else if (key instanceof org.eclipse.uml2.uml.Package) {
			return "EAPK_" + id;
		}
		return "";
	}

}

/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.impl.scopes.AbstractEditableModelScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.information.Class;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.data.la.LogicalActorPkg;
import org.polarsys.capella.core.data.la.LogicalArchitecture;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.Documentation;
import xmi.Extension;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class RootMapping extends AbstractDynamicMapping<Project, Project, Capella2UMLAlgo> {

	public RootMapping(Capella2UMLAlgo algo, Project parent, IMappingExecution execution) {
		super(algo, parent, execution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.bridge.rules.AbstractDynamicMapping#
	 * getEAContainer(java.lang.Object)
	 */
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
		createPackage.setName("Import Capella");
		String sysMLID2 = MappingUtils.getSysMLID(eResource, capellaContainer);
		getAlgo().putId(createPackage, this, sysMLID2);
		model.getPackagedElements().add(createPackage);

		Extension extensionObject = XMIExtensionsUtils
				.createEnterpriseArchitectExtension(model.getPackagedElements().get(0));
		getAlgo().setXMIExtension(extensionObject);

		((AbstractEditableModelScope) targetDataSet).add(extensionObject);
		return model;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.bridge.rules.AbstractDynamicMapping#
	 * getCapellaSource(java.lang.Object)
	 */
	@Override
	public List<Project> findSourceElements(Project capellaContainer) {
		List<Project> results = new ArrayList<Project>();
		results.add(capellaContainer);
		return results;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.bridge.rules.AbstractDynamicMapping#
	 * compute(java.lang.Object, java.util.List)
	 */
	@Override
	public Object compute(Object eaContainer, Project source) {
		return eaContainer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.bridge.rules.AbstractDynamicMapping#
	 * executeSubRules(java.util.List)
	 */
	@Override
	public void executeSubRules(List<Project> _capellaSource, MappingRulesManager manager) {

		Project project = _capellaSource.get(0);

		DataPkg dataPkgRoot = CapellaUtils.getDataPkgRoot(project,LogicalArchitecture.class);

		EnumerationMapping enumerationMapping = new EnumerationMapping(getAlgo(), dataPkgRoot, getMappingExucution());
		manager.add(EnumerationMapping.class.getName() + dataPkgRoot.getId(), enumerationMapping);

		PrimitiveMapping primitiveMapping = new PrimitiveMapping(getAlgo(), dataPkgRoot, getMappingExucution());
		manager.add(primitiveMapping.getClass().getName() + dataPkgRoot.getId(), primitiveMapping);

		ClassMapping classMapping = new ClassMapping(getAlgo(), dataPkgRoot, getMappingExucution());
		manager.add(ClassMapping.class.getName() + dataPkgRoot.getId(), classMapping);

		List<Class> classes = EObjectExt.getAll(dataPkgRoot, InformationPackage.Literals.CLASS).stream()
				.map(Class.class::cast).collect(Collectors.toList());
		for (Class class1 : classes) {
			PropertyMapping propertyMapping = new PropertyMapping(getAlgo(), class1, getMappingExucution());
			manager.add(propertyMapping.getClass().getName() + class1.getId(), propertyMapping);
		}

		LogicalArchitecture logicalArchitecture = CapellaUtils.getLogicalArchitecture(project);

		ShareDataExchangeItemMapping dataExchangeItemMapping = new ShareDataExchangeItemMapping(getAlgo(),
				logicalArchitecture, getMappingExucution());
		manager.add(dataExchangeItemMapping.getClass().getName() + logicalArchitecture.getName(),
				dataExchangeItemMapping);

		EventExchangeItemMapping eventExchangeItemMapping = new EventExchangeItemMapping(getAlgo(), logicalArchitecture,
				getMappingExucution());
		manager.add(eventExchangeItemMapping.getClass().getName() + logicalArchitecture.getName(),
				eventExchangeItemMapping);

		InterfacePkg interfacePkg = CapellaUtils.getInterfacePkgRoot(project,LogicalArchitecture.class);
		InterfaceMapping interfaceMapping = new InterfaceMapping(getAlgo(), interfacePkg, getMappingExucution());
		manager.add(InterfaceMapping.class.getName() + interfacePkg.getId(), interfaceMapping);


		ComponentMapping componentMapping = new ComponentMapping(getAlgo(), logicalArchitecture, getMappingExucution());
		manager.add(componentMapping.getClass().getName() + logicalArchitecture.getId(), componentMapping);

		List<Component> collect = EObjectExt.getAll(logicalArchitecture, CsPackage.Literals.COMPONENT).stream()
				.map(Component.class::cast).collect(Collectors.toList());
		for (Component component : collect) {
			ExchangeMapping mapping = new ExchangeMapping(getAlgo(), component, getMappingExucution());
			manager.add(mapping.getClass().getName() + component.getId(), mapping);
		}

		LogicalActorPkg logicalActorPkg = CapellaUtils.getLogicalActorPkg(project);
		ActorMapping actorMapping = new ActorMapping(getAlgo(), logicalActorPkg, getMappingExucution());
		manager.add(logicalActorPkg.getClass().getName() + logicalActorPkg.getId(), actorMapping);

		DescriptionMapping descriptionMapping = new DescriptionMapping(getAlgo(), logicalArchitecture,
				getMappingExucution());
		manager.add(descriptionMapping.getClass().getName() + logicalArchitecture.getId(), descriptionMapping);

		RootPropertyValuePkgMapping pvpMapping = new RootPropertyValuePkgMapping(getAlgo(), project, getMappingExucution());
		manager.add(RootPropertyValuePkgMapping.class.getName() + project.getId(), pvpMapping);

		
	
		
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

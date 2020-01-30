/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping;
import org.eclipse.capella.mapping.capella2uml.toMove.CapellaUtils;
import org.eclipse.capella.mapping.capella2uml.toMove.MappingUtils;
import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.impl.scopes.AbstractEditableModelScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.la.LogicalActorPkg;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;

import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.Documentation;
import xmi.Extension;
import xmi.XmiFactory;
import xmi.XmiPackage;
import xmi.element;
import xmi.elements;
import xmi.xrefs;

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
	public Object computeEAContainer(Project capellaContainer) {

		EStructuralFeature eStructuralFeature = XmiPackage.eINSTANCE.getelement().getEStructuralFeature("xmiidref");
		if (eStructuralFeature != null) {
			eStructuralFeature.setName("xmi:idref");
		}

		Object targetDataSet = getMappingExucution().getTargetDataSet();

		// EPackage bookStoreEPackage = XMIExtensionsUtils.createXMIPackage();
		// EObject documentationObject =
		// XMIExtensionsUtils.createDocumentationXMITag(bookStoreEPackage,
		// bookStoreEPackage.getEFactoryInstance());

		Documentation documentationObject = XmiFactory.eINSTANCE.createDocumentation();
		documentationObject.setExporter("Enterprise Architect");
		documentationObject.setExporterVersion("6.5");

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

		ResourceSet targetResourceSet = MappingUtils.getTargetResourceSet((IModelScope) targetDataSet);

		Extension extensionObject = XmiFactory.eINSTANCE.createExtension();
		extensionObject.setExtender("Enterprise Architect");
		extensionObject.setExtenderID("6.5");
		getAlgo().setXMIExtension(extensionObject);

		elements createelements = XmiFactory.eINSTANCE.createelements();
		extensionObject.getElements().add(createelements);

		element createelement = XmiFactory.eINSTANCE.createelement();
		createelement.setXmiidref(model.getPackagedElements().get(0));
		createelements.getElement().add(createelement);

		xrefs createxrefs = XmiFactory.eINSTANCE.createxrefs();
		createelement.setXrefs(createxrefs);

		// Profile customProfile = UMLFactory.eINSTANCE.createProfile();
		// customProfile.setName("thecustomprofile");
		//
		// Model uml = UML2Util.load(targetResourceSet,
		// URI.createURI(UMLResource.UML_METAMODEL_URI),
		// UMLPackage.Literals.MODEL);
		//
		// customProfile.createMetamodelReference(uml);
		//
		// org.eclipse.uml2.uml.Extension createExtension =
		// UMLFactory.eINSTANCE.createExtension();
		// createExtension.setName("A_Class_entity");
		//
		// Stereotype entityStereotype = customProfile.createOwnedStereotype("entity",
		// false);
		// Property createOwnedAttribute =
		// entityStereotype.createOwnedAttribute("base_Class",
		// (org.eclipse.uml2.uml.Class) uml.getOwnedType("Classifier"),
		// UMLPackage.eINSTANCE.getProperty());
		//
		// createOwnedAttribute.setAssociation(createExtension);
		//
		// customProfile.getPackagedElements().add(createExtension);
		//
		// customProfile.define();
		// model.applyProfile(customProfile);
		//
		// extensionObject.setProfiles(XmiFactory.eINSTANCE.createprofiles());
		// extensionObject.getProfiles().setProfile(customProfile);

		// Profile loadProfile = XMIExtensionsUtils.loadProfile(targetResourceSet,
		// extensionObject);

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
	public List<Project> computeCapellaSource(Project capellaContainer) {
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
		// Resource eResource = source.eResource();
		// String sysMLID = MappingUtils.getSysMLID(eResource, source);
		// getAlgo().putId(source, sysMLID);
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

		DataPkg dataPkgRoot = CapellaUtils.getDataPkgRoot(project);

		EnumerationMapping enumerationMapping = new EnumerationMapping(getAlgo(), dataPkgRoot, getMappingExucution());
		manager.add(EnumerationMapping.class.getName() + dataPkgRoot.getId(), enumerationMapping);

		ClassMapping classMapping = new ClassMapping(getAlgo(), dataPkgRoot, getMappingExucution());
		manager.add(ClassMapping.class.getName() + dataPkgRoot.getId(), classMapping);

		LogicalArchitecture logicalArchitecture = CapellaUtils.getLogicalArchitecture(project);

		ShareDataExchangeItemMapping dataExchangeItemMapping = new ShareDataExchangeItemMapping(getAlgo(),
				logicalArchitecture, getMappingExucution());
		manager.add(dataExchangeItemMapping.getClass().getName() + logicalArchitecture.getName(),
				dataExchangeItemMapping);

		EventExchangeItemMapping eventExchangeItemMapping = new EventExchangeItemMapping(getAlgo(), logicalArchitecture,
				getMappingExucution());
		manager.add(eventExchangeItemMapping.getClass().getName() + logicalArchitecture.getName(),
				eventExchangeItemMapping);

		InterfacePkg interfacePkg = CapellaUtils.getInterfacePkgRoot(project);
		InterfaceMapping interfaceMapping = new InterfaceMapping(getAlgo(), interfacePkg, getMappingExucution());
		manager.add(InterfaceMapping.class.getName() + interfacePkg.getId(), interfaceMapping);

		LogicalComponent logicalSystem = CapellaUtils.getLogicalSystemRoot(project);

		ComponentMapping componentMapping = new ComponentMapping(getAlgo(), logicalSystem, getMappingExucution());
		manager.add(componentMapping.getClass().getName() + logicalSystem.getId(), componentMapping);

		List<Component> collect = EObjectExt.getAll(logicalArchitecture, CsPackage.Literals.COMPONENT).stream()
				.map(Component.class::cast).collect(Collectors.toList());
		for (Component component : collect) {
			ExchangeMapping mapping = new ExchangeMapping(getAlgo(), component, getMappingExucution());
			manager.add(mapping.getClass().getName() + component.getId(), mapping);
		}

		LogicalActorPkg logicalActorPkg = CapellaUtils.getLogicalActorPkg(project);
		ActorMapping actorMapping = new ActorMapping(getAlgo(), logicalActorPkg, getMappingExucution());
		manager.add(logicalActorPkg.getClass().getName() + logicalActorPkg.getId(), actorMapping);

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

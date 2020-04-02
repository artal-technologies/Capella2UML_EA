/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.FaPackage;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonComponentExchangeMapping;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class AlternativeExchangeMapping extends CommonComponentExchangeMapping<Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public AlternativeExchangeMapping(Capella2UMLAlgo algo, Component parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(Component capellaContainer) {

		Project project = ProjectExt.getProject(capellaContainer);
		Model capellaObjectFromAllRules = (Model) MappingRulesManager.getCapellaObjectFromAllRules(project);
		EList<PackageableElement> packagedElements = capellaObjectFromAllRules.getPackagedElements();
		for (PackageableElement ownedMember : packagedElements) {
			if (ownedMember.getName().equals(SpecificUtils.getCapellaImportName(this))) {
				EList<PackageableElement> packagedElements2 = ((Package) ownedMember).getPackagedElements();
				for (PackageableElement packageableElement : packagedElements2) {
					if (packageableElement.getName().equals("Interfaces")) {
						return packageableElement;
					}
				}
			}
		}

		return MappingRulesManager.getCapellaObjectFromAllRules(project);
	}

	@Override
	public List<ComponentExchange> findSourceElements(Component capellaContainer) {
		PhysicalComponent logicalSystemRoot = CapellaUtils.getPhysicalSystemRoot(capellaContainer);
		List<ComponentExchange> collect = EObjectExt.getAll(logicalSystemRoot, FaPackage.Literals.COMPONENT_EXCHANGE)
				.stream().map(ComponentExchange.class::cast).collect(Collectors.toList());
		return collect;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#compute(java.lang.
	 * Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, ComponentExchange source) {
		Interface createInterface = UMLFactory.eINSTANCE.createInterface();
		MappingUtils.generateUID(getAlgo(), source, createInterface, this);
		createInterface.setName(source.getName());
		element targetelement = XMIExtensionsUtils.createElement(createInterface, getAlgo().getXMIExtension());
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		CapellaElement ce = (CapellaElement) source;
		List<String>stereoNames = new ArrayList<String>();
		if (CapellaUtils.hasStereotype(ce)) {
			String sterotypeName = CapellaUtils.getSterotypeName(ce);
			stereoNames.add(sterotypeName);
			XMIExtensionsUtils.createStereotypeProperties(targetelement, stereoNames,
					"Interface",sysMLID);
		}
		stereoNames.add("Exchange Interface");
		XMIExtensionsUtils.createStereotypeProperties(targetelement, stereoNames, "Interface", sysMLID);
		SpecificUtils.applyComponentExchangeStereotypeAttribute(targetelement, source, createInterface);

		((Package) eaContainer).getPackagedElements().add(createInterface);

		return createInterface;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#executeSubRules(java.
	 * util.List, com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<ComponentExchange> _capellaSource, MappingRulesManager manager) {
		for (ComponentExchange componentExchange : _capellaSource) {
			AlternativeExchangeItemMapping itemMapping = new AlternativeExchangeItemMapping(getAlgo(),
					componentExchange, getMappingExucution());
			manager.add(itemMapping.getClass().getName() + componentExchange.getId(), itemMapping);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#getUID(org.eclipse.emf
	 * .ecore.EObject, java.lang.String)
	 */
	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

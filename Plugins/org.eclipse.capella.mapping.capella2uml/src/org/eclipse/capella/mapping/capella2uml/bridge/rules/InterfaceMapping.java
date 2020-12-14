/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Usage;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.PropertyValueGroup;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Interface;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonInterfaceMapping;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class InterfaceMapping extends CommonInterfaceMapping<Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public InterfaceMapping(Capella2UMLAlgo algo, InterfacePkg parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, Interface source) {
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		org.eclipse.uml2.uml.Interface targetInterface = UMLFactory.eINSTANCE.createInterface();
		MappingUtils.generateUID(getAlgo(), source, targetInterface, this);
		Object capellaObjectFromAllRules0 = MappingRulesManager.getCapellaObjectFromAllRules(source.eContainer());
		((org.eclipse.uml2.uml.Package) capellaObjectFromAllRules0).getPackagedElements().add(targetInterface);
		element targetelement = XMIExtensionsUtils.createElement(targetInterface, getAlgo().getXMIExtension());

		CapellaElement ce = (CapellaElement) source;
		if (CapellaUtils.hasStereotype(ce) && getAlgo().isPVMTExport()) {
			List<String> stereoNames = new ArrayList<String>();
			stereoNames.addAll(CapellaUtils.getListStereotypeName(ce));
			XMIExtensionsUtils.createStereotypeProperties(targetelement, stereoNames,
					"Interface", sysMLID);
			EList<PropertyValueGroup> pvgs = ce.getOwnedPropertyValueGroups();
			for (PropertyValueGroup propertyValueGroup : pvgs) {
				PropertyValuePkg propertyValuePkgFromName = SpecificUtils
						.getProfilePropertyValueGroup(ProjectExt.getProject(source), propertyValueGroup.getName());
				Profile capellaObjectFromAllRules = (Profile) MappingRulesManager
						.getCapellaObjectFromAllRules(propertyValuePkgFromName);

				Stereotype ownedStereotype = capellaObjectFromAllRules
						.getOwnedStereotype(propertyValueGroup.getName().split("\\.")[1]);

				SpecificUtils.applyStereotypeAttribute(propertyValueGroup, targetelement, targetInterface);
				
				getAlgo().getStereotypes().add(ownedStereotype);

				String typeBase = "Interface";

				org.eclipse.uml2.uml.Interface compStereo = UMLFactory.eINSTANCE.createInterface();
				SpecificUtils.createCustoStereotypeApplication((Element) eaContainer, targetInterface,
						SpecificUtils.getModel(targetInterface, source), propertyValueGroup, typeBase, compStereo,
						getAlgo());

			}
		}

		targetInterface.setName(source.getName());

		String beginId = sysMLID.substring(0, 10);

		EList<ExchangeItem> exchangeItems = source.getExchangeItems();
		for (ExchangeItem exchangeItem : exchangeItems) {
			String sysMLID2 = MappingUtils.getSysMLID(eResource, exchangeItem);
			String endID = sysMLID2.substring(10);
			Object capellaObjectFromAllRules = MappingRulesManager.getCapellaObjectFromAllRules(exchangeItem);
			if (capellaObjectFromAllRules instanceof Classifier) {
				Property createProperty = UMLFactory.eINSTANCE.createProperty();
				createProperty.setName(exchangeItem.getName());
				MappingUtils.generateNamesUID(getAlgo(), createProperty, this, beginId + endID + "property");
				XMIExtensionsUtils.createElement(createProperty, getAlgo().getXMIExtension());
				targetInterface.getOwnedAttributes().add(createProperty);
				createProperty.setType((Classifier) capellaObjectFromAllRules);

				if (capellaObjectFromAllRules != null) {
					Usage createUsage = UMLFactory.eINSTANCE.createUsage();
					MappingUtils.generateNamesUID(getAlgo(), createUsage, this, beginId + endID + "us");

					createUsage.getClients().add((org.eclipse.uml2.uml.Interface) targetInterface);
					createUsage.getSuppliers().add((org.eclipse.uml2.uml.Type) capellaObjectFromAllRules);

					Project project = ProjectExt.getProject(source);
					Object capellaObjectFromAllRules2 = MappingRulesManager.getCapellaObjectFromAllRules(project);

					EList<PackageableElement> packagedElements = ((Model) capellaObjectFromAllRules2)
							.getPackagedElements();
					for (PackageableElement ownedMember : packagedElements) {
						if (ownedMember.getName().equals(SpecificUtils.getCapellaImportName(this)))
							((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(createUsage);
					}

				}

			}
		}

		return targetInterface;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<Interface> _capellaSource, MappingRulesManager manager) {
		for (Interface interface1 : _capellaSource) {
			OperationExchangeItemMapping exchangeItemMapping = new OperationExchangeItemMapping(getAlgo(), interface1,
					getMappingExucution());
			manager.add(exchangeItemMapping.getClass().getName() + interface1.getId(), exchangeItemMapping);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#getUID(
	 * org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

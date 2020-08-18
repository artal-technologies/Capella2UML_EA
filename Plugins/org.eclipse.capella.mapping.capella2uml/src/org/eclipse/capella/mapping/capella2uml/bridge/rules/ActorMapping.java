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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.PropertyValueGroup;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.cs.AbstractActor;
import org.polarsys.capella.core.data.fa.AbstractFunctionalStructure;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonsActorMapping;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class ActorMapping extends CommonsActorMapping<Capella2UMLAlgo> {

	public ActorMapping(Capella2UMLAlgo algo, AbstractFunctionalStructure parent, IMappingExecution mappingExecution) {
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
	public Object compute(Object eaContainer, AbstractActor source) {
		
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		Actor targetActor = UMLFactory.eINSTANCE.createActor();

		Capella2UMLAlgo algo = getAlgo();

		MappingUtils.generateUID(algo, source, targetActor, this);
		element targetelement = XMIExtensionsUtils.createElement(targetActor, algo.getXMIExtension());

		targetActor.setName(source.getName());

		CapellaElement ce = (CapellaElement) source;

		((org.eclipse.uml2.uml.Package) eaContainer).getPackagedElements().add(targetActor);
		if (CapellaUtils.hasStereotype(ce)) {
			List<String> stereoNames = new ArrayList<String>();
			stereoNames.addAll(CapellaUtils.getListStereotypeName(ce));
			
			XMIExtensionsUtils.createStereotypeProperties(targetelement, stereoNames, "Actor", sysMLID);

			EList<PropertyValueGroup> pvgs = ce.getOwnedPropertyValueGroups();
			for (PropertyValueGroup propertyValueGroup : pvgs) {
				PropertyValuePkg propertyValuePkgFromName = SpecificUtils
						.getProfilePropertyValueGroup(ProjectExt.getProject(source), propertyValueGroup.getName());
				Profile capellaObjectFromAllRules = (Profile) MappingRulesManager
						.getCapellaObjectFromAllRules(propertyValuePkgFromName);

				Stereotype ownedStereotype = capellaObjectFromAllRules
						.getOwnedStereotype(propertyValueGroup.getName().split("\\.")[1]);
				SpecificUtils.applyStereotypeAttribute(propertyValueGroup, targetelement, targetActor);
				getAlgo().getStereotypes().add(ownedStereotype);

				String typeBase = "Actor";

				Actor compStereo = UMLFactory.eINSTANCE.createActor();
				SpecificUtils.createCustoStereotypeApplication((Element) eaContainer, targetActor,
						SpecificUtils.getModel(targetActor,source), propertyValueGroup, typeBase, compStereo, getAlgo());

			}
		}
		return targetActor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<AbstractActor> _capellaSource, MappingRulesManager manager) {

		for (AbstractActor logicalActor : _capellaSource) {
			// ActorFunctionalExchangeMapping functionalExchangeMapping = new
			// ActorFunctionalExchangeMapping(getAlgo(),
			// logicalActor, getMappingExucution());
			// manager.add(functionalExchangeMapping.getClass().getName() +
			// logicalActor.getId(),
			// functionalExchangeMapping);

			PropertyMapping propertyMapping = new PropertyMapping(getAlgo(), logicalActor, getMappingExucution());
			manager.add(propertyMapping.getClass().getName() + logicalActor.getId(), propertyMapping);

			PortMapping portMapping = new PortMapping(getAlgo(), logicalActor, getMappingExucution());
			manager.add(PortMapping.class.getName() + logicalActor.getId(), portMapping);

		}

	}

}

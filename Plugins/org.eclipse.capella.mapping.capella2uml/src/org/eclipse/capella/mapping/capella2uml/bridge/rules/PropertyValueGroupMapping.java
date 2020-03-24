/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.PropertyValue;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.AbstractPropertyValue;
import org.polarsys.capella.core.data.capellacore.PropertyValueGroup;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.util.XMIExtensionsUtils;

/**
 * @author didier
 *
 */
public class PropertyValueGroupMapping extends AbstractDynamicMapping<PropertyValuePkg, PropertyValueGroup, Capella2UMLAlgo> {

	public PropertyValueGroupMapping(Capella2UMLAlgo algo, PropertyValuePkg pvp, IMappingExecution mappingExecution) {
		super(algo, pvp, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeTargetContainer(PropertyValuePkg capellaContainer) {

		Object container = MappingRulesManager
				.getCapellaObjectFromAllRules(capellaContainer);
		if (container != null) {
			return container;
		}
//		Project project = ProjectExt.getProject(capellaContainer);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeCapellaSource(java.lang.Object)
	 */
	@Override
	public List<PropertyValueGroup> findSourceElements(PropertyValuePkg capellaContainer) {
		
		return capellaContainer.getOwnedPropertyValueGroups();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	/**
	 * Sub property value package are transformed into stereotype
	 */
	@Override
	public Object compute(Object eaContainer, PropertyValueGroup source) {
		
		Stereotype stereo= UMLFactory.eINSTANCE.createStereotype();
		MappingUtils.generateUID(getAlgo(), source, stereo, this);
		if (eaContainer instanceof Profile) {
			Profile profile = (Profile) eaContainer;
			profile.getPackagedElements().add(stereo);
			stereo.setName(source.getName());
			XMIExtensionsUtils.createElement(stereo, getAlgo().getXMIExtension());//TODO
			
			for (AbstractPropertyValue pv:source.getOwnedPropertyValues()){
				Property property = UMLFactory.eINSTANCE.createProperty();
				MappingUtils.generateUID(getAlgo(), source, property, this);
				stereo.getOwnedAttributes().add(property);
				property.setName(pv.getName());
				XMIExtensionsUtils.createElement(property, getAlgo().getXMIExtension());//TODO
			}
		}
		return stereo;
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<PropertyValueGroup> _capellaSource, MappingRulesManager manager) {


	}
}

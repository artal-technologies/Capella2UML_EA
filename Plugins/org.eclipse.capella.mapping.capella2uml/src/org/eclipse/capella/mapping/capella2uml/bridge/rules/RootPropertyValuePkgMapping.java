/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.AbstractPropertyValue;
import org.polarsys.capella.core.data.capellacore.PropertyValuePkg;
import org.polarsys.capella.core.data.capellacore.StringPropertyValue;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.Extension;
import xmi.XmiFactory;
import xmi.profiles;

/**
 * @author didier
 *
 */
public class RootPropertyValuePkgMapping extends AbstractDynamicMapping<Project, PropertyValuePkg, Capella2UMLAlgo> {

	public RootPropertyValuePkgMapping(Capella2UMLAlgo algo, Project project, IMappingExecution mappingExecution) {
		super(algo, project, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeTargetContainer(Project capellaContainer) {

		Extension extension=getAlgo().getXMIExtension();
		profiles profiles = extension.getProfiles();
		if (profiles==null) {
			extension.setProfiles(XmiFactory.eINSTANCE.createprofiles());
		}
		return extension.getProfiles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeCapellaSource(java.lang.Object)
	 */
	@Override
	public List<PropertyValuePkg> findSourceElements(Project capellaContainer) {
		
		for(PropertyValuePkg pvp:capellaContainer.getOwnedPropertyValuePkgs()){
			if (pvp.getName().equals(("EXTENSIONS"))){
				return pvp.getOwnedPropertyValuePkgs();
			}
		};
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	/**
	 * Root property value package is transformed into profiles -> profile
	 */
	@Override
	public Object compute(Object eaContainer, PropertyValuePkg source) {
		org.eclipse.uml2.uml.Profile profile = UMLFactory.eINSTANCE.createProfile();
		profiles profiles= (profiles) eaContainer;
		profiles.getProfile().add(profile);
//		Package packageProfile = UMLFactory.eINSTANCE.createPackage();
//		MappingUtils.generateUID(getAlgo(), source, packageProfile, this);

		MappingUtils.generateUID(getAlgo(), source, profile, this);
		for (AbstractPropertyValue pv:source.getAppliedPropertyValues()){
			if (pv.getName().equals("version")){
				StringPropertyValue spv= (StringPropertyValue) pv;
				Comment comment= UMLFactory.eINSTANCE.createComment();
				comment.setBody(pv.getName()+" "+spv.getValue());
				profile.getOwnedComments().add(comment);
			}
		}
		profile.setName(source.getName());
		return profile;
		
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
	public void executeSubRules(List<PropertyValuePkg> _capellaSource, MappingRulesManager manager) {

		for (PropertyValuePkg pvp : _capellaSource) {
			PropertyValueGroupMapping pvgMapping = new PropertyValueGroupMapping(getAlgo(), pvp,
					getMappingExucution());
			manager.add(PropertyValueGroupMapping.class.getName() + pvp.getId(), pvgMapping);

			EnumerationPropertyValueMapping epvMapping = new EnumerationPropertyValueMapping(getAlgo(), pvp,
					getMappingExucution());
			manager.add(EnumerationPropertyValueMapping.class.getName() + pvp.getId(), epvMapping);

		}

	}
}

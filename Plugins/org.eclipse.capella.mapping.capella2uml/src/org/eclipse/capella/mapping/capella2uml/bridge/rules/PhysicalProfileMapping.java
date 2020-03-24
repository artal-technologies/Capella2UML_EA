/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.AbstractPropertyValue;
import org.polarsys.capella.core.data.capellacore.StringPropertyValue;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.Extension;
import xmi.XmiFactory;
import xmi.profiles;
import xmi.util.XMIExtensionsUtils;

/**
 * @author didier
 *
 */
public class PhysicalProfileMapping extends AbstractDynamicMapping<Project, PhysicalArchitecture, Capella2UMLAlgo> {

	public PhysicalProfileMapping(Capella2UMLAlgo algo, Project project, IMappingExecution mappingExecution) {
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

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
//	 * computeCapellaSource(java.lang.Object)
//	 */
//	@Override
//	public PhysicalArchitecture findSourceElements(Project capellaContainer) {
//		
//		return CapellaUtils.getPhysicalArchitecture(capellaContainer);
//	}

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
	public Object compute(Object eaContainer, PhysicalArchitecture source) {
		org.eclipse.uml2.uml.Profile profile = UMLFactory.eINSTANCE.createProfile();
		profiles profiles= (profiles) eaContainer;
		profiles.getProfile().add(profile);
		profile.setName("Physical Architecture");

		MappingUtils.generateUID(getAlgo(), source, profile, this);

		Stereotype nodeStereotype= UMLFactory.eINSTANCE.createStereotype();
		nodeStereotype.setName("Node");
		
		Stereotype behaviorStereotype= UMLFactory.eINSTANCE.createStereotype();
		behaviorStereotype.setName("Behavior");

		profile.getPackagedElements().add(nodeStereotype);
		profile.getPackagedElements().add(behaviorStereotype);
		XMIExtensionsUtils.createElement(nodeStereotype, getAlgo().getXMIExtension());
		XMIExtensionsUtils.createElement(behaviorStereotype, getAlgo().getXMIExtension());
		
		for (AbstractPropertyValue pv:source.getOwnedPropertyValues()){
			Property property = UMLFactory.eINSTANCE.createProperty();
			MappingUtils.generateUID(getAlgo(), source, property, this);
//			stereo.getOwnedAttributes().add(property);
			property.setName(pv.getName());
			XMIExtensionsUtils.createElement(property, getAlgo().getXMIExtension());//TODO
		}
		return profile;
		
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

	@Override
	public List<PhysicalArchitecture> findSourceElements(Project capellaContainer) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void executeSubRules(List<PhysicalArchitecture> _capellaSource, MappingRulesManager manager) {
		
	}

}

/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.cs.SystemComponent;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.pa.PhysicalComponent;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class AggregationMapping extends AbstractDynamicMapping<SystemComponent, SystemComponent, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public AggregationMapping(Capella2UMLAlgo algo, SystemComponent parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#computeTargetContainer
	 * (java.lang.Object)
	 */
	@Override
	public Object computeTargetContainer(SystemComponent capellaContainer) {
		Component lc = (Component) MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
		return lc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#findSourceElements(
	 * java.lang.Object)
	 */
	@Override
	public List<SystemComponent> findSourceElements(SystemComponent capellaContainer) {
		List<SystemComponent> result = new ArrayList<SystemComponent>();
		if (capellaContainer instanceof LogicalComponent) {
			EList<LogicalComponent> ownedLogicalComponents = ((LogicalComponent) capellaContainer)
					.getOwnedLogicalComponents();
			result.addAll(ownedLogicalComponents);
		} else if (capellaContainer instanceof PhysicalComponent) {
			EList<PhysicalComponent> ownedLogicalComponents = ((PhysicalComponent) capellaContainer)
					.getOwnedPhysicalComponents();
			result.addAll(ownedLogicalComponents);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#compute(java.lang.
	 * Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, SystemComponent source) {
		// LogicalComponent sourceContainer = getSourceContainer();
		Association targetAssociation = UMLFactory.eINSTANCE.createAssociation();
		MappingUtils.generateUID(getAlgo(), source, targetAssociation, this, "a");
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);

		Component parent = (Component) eaContainer;
		((org.eclipse.uml2.uml.Package) parent.getModel().getPackagedElements().get(0)).getPackagedElements()
				.add(targetAssociation);

		Property targetProperty = UMLFactory.eINSTANCE.createProperty();
		MappingUtils.generateUID(getAlgo(), source, targetProperty, this, "tp");
		targetProperty.setIsComposite(false);
		targetAssociation.getOwnedEnds().add(targetProperty);

		Component targetC = (Component) MappingRulesManager.getCapellaObjectFromAllRules(source);
		Property subProp = UMLFactory.eINSTANCE.createProperty();
		MappingUtils.generateUID(getAlgo(), source, subProp, this, "p");

		targetProperty.setType(parent);
		subProp.setType(targetC);
		subProp.setIsComposite(true);

		subProp.setAssociation(targetAssociation);
		targetProperty.setAssociation(targetAssociation);
		parent.getOwnedAttributes().add(subProp);

		XMIExtensionsUtils.addConnector(targetAssociation, getAlgo().getXMIExtension(), sysMLID, "Unspecified",
				"Association", subProp, targetProperty, true);
		return targetAssociation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#executeSubRules(java.
	 * util.List, com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<SystemComponent> _capellaSource, MappingRulesManager manager) {
		// TODO Auto-generated method stub

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

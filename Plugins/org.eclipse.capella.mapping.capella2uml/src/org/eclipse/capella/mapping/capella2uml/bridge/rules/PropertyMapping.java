/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.Classifier;
import org.polarsys.capella.core.data.capellacore.Type;
import org.polarsys.capella.core.data.information.Property;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class PropertyMapping extends AbstractDynamicMapping<Classifier, Property, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public PropertyMapping(Capella2UMLAlgo algo, Classifier parent, IMappingExecution mappingExecution) {
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
	public Object computeTargetContainer(Classifier capellaContainer) {
		Object capellaObjectFromAllRules = MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
		return capellaObjectFromAllRules;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#findSourceElements(
	 * java.lang.Object)
	 */
	@Override
	public List<Property> findSourceElements(Classifier capellaContainer) {

		List<Property> properties = capellaContainer.getOwnedFeatures().stream()
				.filter(prop -> prop instanceof Property).map(Property.class::cast).collect(Collectors.toList());

		return properties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#compute(java.lang.
	 * Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, Property source) {

		org.eclipse.uml2.uml.Property targetProperty = UMLFactory.eINSTANCE.createProperty();
		MappingUtils.generateUID(getAlgo(), source, targetProperty, this);
		targetProperty.setName(source.getName());

		Type type = source.getType();
		Object capellaObjectFromAllRules = MappingRulesManager.getCapellaObjectFromAllRules(type);
		targetProperty.setType((org.eclipse.uml2.uml.Type) capellaObjectFromAllRules);

		if (eaContainer instanceof org.eclipse.uml2.uml.DataType) {
			((org.eclipse.uml2.uml.DataType) eaContainer).getOwnedAttributes().add(targetProperty);
		}

		return targetProperty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#executeSubRules(java.
	 * util.List, com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<Property> _capellaSource, MappingRulesManager manager) {
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
		// TODO Auto-generated method stub
		return null;
	}

}

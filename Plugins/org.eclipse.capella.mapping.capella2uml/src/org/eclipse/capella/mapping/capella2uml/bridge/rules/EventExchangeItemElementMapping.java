/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.polarsys.capella.core.data.capellacore.Type;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeItemElement;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonExchangeItemElement;

/**
 * @author binot
 *
 */
public class EventExchangeItemElementMapping extends CommonExchangeItemElement<Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public EventExchangeItemElementMapping(Capella2UMLAlgo algo, ExchangeItem parent,
			IMappingExecution mappingExecution) {
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
	public Object compute(Object eaContainer, ExchangeItemElement source) {
		Property targetProperty = UMLFactory.eINSTANCE.createProperty();

		MappingUtils.generateUID(getAlgo(), source, targetProperty, this);

		targetProperty.setName(source.getName());

		targetProperty.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		targetProperty.setIsStatic(false);
		targetProperty.setIsReadOnly(false);
		targetProperty.setIsDerived(false);
		targetProperty.setIsOrdered(source.isOrdered());
		targetProperty.setIsUnique(source.isUnique());
		targetProperty.setIsDerivedUnion(false);

		Type type = source.getType();
		Object capellaObjectFromAllRules = MappingRulesManager.getCapellaObjectFromAllRules(type);
		if (capellaObjectFromAllRules instanceof org.eclipse.uml2.uml.Type) {
			targetProperty.setType((org.eclipse.uml2.uml.Type) capellaObjectFromAllRules);
		}

		if (eaContainer instanceof Signal) {
			((Signal) eaContainer).getOwnedAttributes().add(targetProperty);
			if (capellaObjectFromAllRules != null) {
				Usage createUsage = UMLFactory.eINSTANCE.createUsage();
				MappingUtils.generateUID(getAlgo(), source, createUsage, this, "us");

				createUsage.getClients().add((Signal) eaContainer);
				createUsage.getSuppliers().add((org.eclipse.uml2.uml.Type) capellaObjectFromAllRules);

				EList<PackageableElement> packagedElements = ((Signal) eaContainer).getModel().getPackagedElements();
				for (PackageableElement ownedMember : packagedElements) {
					if (ownedMember.getName().equals("Import Capella"))
						((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(createUsage);
				}

			}
		}

		return targetProperty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<ExchangeItemElement> _capellaSource, MappingRulesManager manager) {
		// TODO Auto-generated method stub

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

/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.Type;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeItemElement;
import org.polarsys.capella.core.data.information.ParameterDirection;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class OperationExchangeItemElementMapping
		extends AbstractDynamicMapping<ExchangeItem, ExchangeItemElement, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public OperationExchangeItemElementMapping(Capella2UMLAlgo algo, ExchangeItem parent,
			IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeTargetContainer(ExchangeItem capellaContainer) {
		return (Operation) MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeCapellaSource(java.lang.Object)
	 */
	@Override
	public List<ExchangeItemElement> findSourceElements(ExchangeItem capellaContainer) {
		List<ExchangeItemElement> ownedElements = capellaContainer.getOwnedElements();
		return ownedElements;
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
		Parameter targetParameter = UMLFactory.eINSTANCE.createParameter();
		targetParameter.setName(source.getName());
		MappingUtils.generateUID(getAlgo(), source, targetParameter, this);

		setDirection(targetParameter, source.getDirection());
		Type type = source.getType();
		Object capellaObjectFromAllRules = MappingRulesManager.getCapellaObjectFromAllRules(type);
		if (capellaObjectFromAllRules instanceof org.eclipse.uml2.uml.Type) {
			targetParameter.setType((org.eclipse.uml2.uml.Type) capellaObjectFromAllRules);
		}
		if (eaContainer instanceof Operation) {
			((Operation) eaContainer).getOwnedParameters().add(targetParameter);
		}

		return targetParameter;
	}

	private void setDirection(Parameter parameter, ParameterDirection direction) {
		switch (direction) {
		case IN:
			parameter.setDirection(ParameterDirectionKind.IN_LITERAL);
			break;
		case OUT:
			parameter.setDirection(ParameterDirectionKind.OUT_LITERAL);
			break;
		case INOUT:
			parameter.setDirection(ParameterDirectionKind.INOUT_LITERAL);
			break;
		case RETURN:
			parameter.setDirection(ParameterDirectionKind.RETURN_LITERAL);
			break;
		case EXCEPTION:
		case UNSET:
		default:
			break;
		}
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

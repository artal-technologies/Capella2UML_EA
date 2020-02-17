/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeItemElement;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonExchangeItemElement<ALGO extends CapellaBridgeAlgo<?>> extends
		AbstractDynamicMapping<org.polarsys.capella.core.data.information.ExchangeItem, org.polarsys.capella.core.data.information.ExchangeItemElement, ALGO> {

	public CommonExchangeItemElement(ALGO algo, ExchangeItem parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(ExchangeItem capellaContainer) {
		return MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	@Override
	public List<ExchangeItemElement> findSourceElements(ExchangeItem capellaContainer) {
		List<ExchangeItemElement> ownedElements = capellaContainer.getOwnedElements();
		return ownedElements;
	}

}

/**
 * 
 */
package com.artal.capella.mapping.rules;

import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.MappingUtils;

/**
 * @author binot
 *
 */
public abstract class AbstractDynamicMapping<CAPELLA_CONTAINER, CAPELLA_SOURCE, ALGO extends CapellaBridgeAlgo<?>>
		extends AbstractMapping {

	CAPELLA_CONTAINER _containerCapella;

	List<CAPELLA_SOURCE> _capellaSource;

	protected MappingRulesManager _manager = new MappingRulesManager();

	IMappingExecution _mappingExecution;

	private ALGO _algo;

	public AbstractDynamicMapping(ALGO algo, CAPELLA_CONTAINER parent, IMappingExecution mappingExecution) {
		super(algo);
		_algo = algo;
		_containerCapella = parent;
		_mappingExecution = mappingExecution;
	}

	public CAPELLA_CONTAINER getCapellaContainer() {
		return _containerCapella;
	}

	public List<CAPELLA_SOURCE> getChildren() {
		return null;
	}

	private boolean isActivated() {
		return true;
	}

	public IMappingExecution getMappingExucution() {
		return _mappingExecution;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.artal.capella.mapping.rules.AbstractMapping#computeMapping()
	 */
	@Override
	public void computeMapping() {
		if (!isActivated()) {
			return;
		}
		Object eaContainer = computeEAContainer(_containerCapella);
		List<CAPELLA_SOURCE> capellaSource = computeCapellaSource(_containerCapella);
		if (eaContainer != null && capellaSource != null && !capellaSource.isEmpty()) {
			for (CAPELLA_SOURCE capella_SOURCE : capellaSource) {
				Object object = compute(eaContainer, capella_SOURCE);
				toTrace(capella_SOURCE, object);
			}

			executeSubRules(capellaSource, _manager);
			_manager.executeRules();
		}

	}

	protected void toTrace(Object sourceElement, Object targetElement) {
		toTrace(sourceElement, targetElement, sourceElement.getClass().getName());
	}

	protected void toTrace(Object sourceElement, Object targetElement, String prefix) {
		Resource eResource = null;
		if (sourceElement instanceof EObject) {
			eResource = ((EObject) sourceElement).eResource();
		}
		MappingUtils.trace(this, eResource, sourceElement, targetElement, prefix);
	}

	abstract public Object computeEAContainer(CAPELLA_CONTAINER capellaContainer);

	abstract public List<CAPELLA_SOURCE> computeCapellaSource(CAPELLA_CONTAINER capellaContainer);

	abstract public Object compute(Object eaContainer, CAPELLA_SOURCE source);

	abstract public void executeSubRules(List<CAPELLA_SOURCE> _capellaSource, MappingRulesManager manager);

	abstract public String getUID(EObject key, String id);

	@Override
	public ALGO getAlgo() {
		return _algo;
	}
	
	
	
}

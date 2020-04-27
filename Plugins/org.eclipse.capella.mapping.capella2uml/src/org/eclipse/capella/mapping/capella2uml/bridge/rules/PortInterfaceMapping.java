/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.bridge.rules.utils.SpecificUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Usage;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentPort;
import org.polarsys.capella.core.data.fa.OrientationPortKind;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class PortInterfaceMapping extends AbstractDynamicMapping<ComponentPort, ComponentExchange, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public PortInterfaceMapping(Capella2UMLAlgo algo, ComponentPort parent, IMappingExecution mappingExecution) {
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
	public Object computeTargetContainer(ComponentPort capellaContainer) {
		return MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#findSourceElements(
	 * java.lang.Object)
	 */
	@Override
	public List<ComponentExchange> findSourceElements(ComponentPort capellaContainer) {
		EList<ComponentExchange> componentExchanges = capellaContainer.getComponentExchanges();
		return componentExchanges;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#compute(java.lang.
	 * Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, ComponentExchange source) {

		ComponentPort sourceContainer = getSourceContainer();
		OrientationPortKind orientation = sourceContainer.getOrientation();

		Port port = (Port) eaContainer;
		org.eclipse.uml2.uml.Interface inter = (org.eclipse.uml2.uml.Interface) MappingRulesManager
				.getCapellaObjectFromAllRules(source);
		port.setType(inter);
		Interface createInterface = null;
		if (inter != null) {
			if (orientation == OrientationPortKind.IN) {

				createInterface = UMLFactory.eINSTANCE.createInterface();
				MappingUtils.generateUID(getAlgo(), getSourceContainer(), createInterface, this, "P");
				createInterface.setName(inter.getName());
				XMIResource res = (XMIResource) (inter.eResource());
				SpecificUtils.addCustoRef(res, port, "provided", createInterface, false, true);
				SpecificUtils.addCustoAttr(res, createInterface, "xmi:idref", MappingUtils.getSysMLID(res, inter));

			} else if (orientation == OrientationPortKind.OUT) {
				port.setIsConjugated(true);

				createInterface = UMLFactory.eINSTANCE.createInterface();
				MappingUtils.generateUID(getAlgo(), getSourceContainer(), createInterface, this, "R");
				createInterface.setName(inter.getName());
				XMIResource res = (XMIResource) (inter.eResource());
				SpecificUtils.addCustoRef(res, port, "required", createInterface, false, true);
				SpecificUtils.addCustoAttr(res, createInterface, "xmi:idref", MappingUtils.getSysMLID(res, inter));
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.artal.capella.mapping.rules.AbstractDynamicMapping#executeSubRules(java.
	 * util.List, com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<ComponentExchange> _capellaSource, MappingRulesManager manager) {
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

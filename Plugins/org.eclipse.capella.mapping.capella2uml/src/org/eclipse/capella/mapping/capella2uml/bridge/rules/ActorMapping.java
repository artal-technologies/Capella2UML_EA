/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.data.la.LogicalComponentPkg;

import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonsActorMapping;

import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class ActorMapping extends CommonsActorMapping< Capella2UMLAlgo> {

	public ActorMapping(Capella2UMLAlgo algo, LogicalComponentPkg parent, IMappingExecution mappingExecution) {
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
	public Object compute(Object eaContainer, LogicalComponent source) {
		Actor targetActor = UMLFactory.eINSTANCE.createActor();

		Capella2UMLAlgo algo = getAlgo();

		MappingUtils.generateUID(algo, source, targetActor, this);
		XMIExtensionsUtils.createElement(targetActor, algo.getXMIExtension());

		targetActor.setName(source.getName());
		if (eaContainer instanceof Model) {
			EList<PackageableElement> packagedElements = ((Model) eaContainer).getPackagedElements();
			for (PackageableElement packageableElement : packagedElements) {
				if (packageableElement.getName().equals("Import Capella"))
					((Package) packageableElement).getPackagedElements().add(targetActor);
			}
		}
		return targetActor;
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
	public void executeSubRules(List<LogicalComponent> _capellaSource, MappingRulesManager manager) {

		for (LogicalComponent logicalActor : _capellaSource) {
			ActorFunctionalExchangeMapping functionalExchangeMapping = new ActorFunctionalExchangeMapping(getAlgo(),
					logicalActor, getMappingExucution());
			manager.add(functionalExchangeMapping.getClass().getName() + logicalActor.getId(),
					functionalExchangeMapping);
		}

	}




}

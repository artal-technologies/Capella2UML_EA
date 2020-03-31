/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.AbstractActor;
import org.polarsys.capella.core.data.fa.AbstractFunctionalStructure;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonsActorMapping;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class ActorMapping extends CommonsActorMapping<Capella2UMLAlgo> {

	public ActorMapping(Capella2UMLAlgo algo, AbstractFunctionalStructure parent, IMappingExecution mappingExecution) {
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
	public Object compute(Object eaContainer, AbstractActor source) {
		Actor targetActor = UMLFactory.eINSTANCE.createActor();

		Capella2UMLAlgo algo = getAlgo();

		MappingUtils.generateUID(algo, source, targetActor, this);
		element targetelement = XMIExtensionsUtils.createElement(targetActor, algo.getXMIExtension());

		targetActor.setName(source.getName());

		CapellaElement ce = (CapellaElement) source;
		if (CapellaUtils.hasStereotype(ce)) {
			XMIExtensionsUtils.createStereotypeProperties(targetelement, CapellaUtils.getSterotypeName(ce), "Actor");
		}

		((org.eclipse.uml2.uml.Package) eaContainer).getPackagedElements().add(targetActor);
		// if (eaContainer instanceof Model) {
		// EList<PackageableElement> packagedElements = ((Model)
		// eaContainer).getPackagedElements();
		// for (PackageableElement packageableElement : packagedElements) {
		// if
		// (packageableElement.getName().equals(SpecificUtils.getCapellaImportName(this)))
		// ((Package) packageableElement).getPackagedElements().add(targetActor);
		// }
		// }
		return targetActor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<AbstractActor> _capellaSource, MappingRulesManager manager) {

		for (AbstractActor logicalActor : _capellaSource) {
			// ActorFunctionalExchangeMapping functionalExchangeMapping = new
			// ActorFunctionalExchangeMapping(getAlgo(),
			// logicalActor, getMappingExucution());
			// manager.add(functionalExchangeMapping.getClass().getName() +
			// logicalActor.getId(),
			// functionalExchangeMapping);

			PortMapping portMapping = new PortMapping(getAlgo(), logicalActor, getMappingExucution());
			manager.add(PortMapping.class.getName() + logicalActor.getId(), portMapping);

		}

	}

}

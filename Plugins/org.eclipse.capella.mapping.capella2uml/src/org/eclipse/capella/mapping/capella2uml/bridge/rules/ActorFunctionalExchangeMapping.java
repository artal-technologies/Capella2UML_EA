/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.FaPackage;
import org.polarsys.capella.core.data.fa.FunctionInputPort;
import org.polarsys.capella.core.data.fa.FunctionOutputPort;
import org.polarsys.capella.core.data.fa.FunctionalExchange;
import org.polarsys.capella.core.data.la.LogicalActor;
import org.polarsys.capella.core.data.la.LogicalFunctionPkg;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class ActorFunctionalExchangeMapping
		extends AbstractDynamicMapping<LogicalActor, FunctionalExchange, Capella2UMLAlgo> {

	public ActorFunctionalExchangeMapping(Capella2UMLAlgo algo, LogicalActor parent,
			IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(LogicalActor capellaContainer) {
		Actor actor = (Actor) MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
		return actor;
	}

	@Override
	public List<FunctionalExchange> findSourceElements(LogicalActor capellaContainer) {

		LogicalFunctionPkg logicalFunctionPackage = CapellaUtils.getLogicalFunctionPackage(capellaContainer);
		List<FunctionalExchange> collect = EObjectExt
				.getAll(logicalFunctionPackage, FaPackage.eINSTANCE.getFunctionalExchange()).stream()
				.map(FunctionalExchange.class::cast).filter(lf -> isInActor(lf, capellaContainer))
				.collect(Collectors.toList());

		return collect;
	}

	public boolean isInActor(FunctionalExchange lf, LogicalActor capellaContainer) {
		FunctionOutputPort sourceFunctionOutputPort = lf.getSourceFunctionOutputPort();
		FunctionInputPort targetFunctionInputPort = lf.getTargetFunctionInputPort();

		AbstractFunction sourceFunction = (AbstractFunction) sourceFunctionOutputPort.eContainer();
		AbstractFunction targetFunction = (AbstractFunction) targetFunctionInputPort.eContainer();

		Component sourceComponent = CapellaUtils.getInverseComponent(sourceFunction);
		Component targetComponent = CapellaUtils.getInverseComponent(targetFunction);

		if (capellaContainer.equals(sourceComponent) && capellaContainer.equals(targetComponent)) {
			return false;
		}
		if (capellaContainer.equals(sourceComponent) || capellaContainer.equals(targetComponent)) {
			return true;
		}

		return false;
	}

	@Override
	public Object compute(Object eaContainer, FunctionalExchange source) {

		Association createAssociation = UMLFactory.eINSTANCE.createAssociation();
		MappingUtils.generateUID(getAlgo(), source, createAssociation, this);

		FunctionInputPort targetFunctionInputPort = source.getTargetFunctionInputPort();
		FunctionOutputPort sourceFunctionOutputPort = source.getSourceFunctionOutputPort();

		AbstractFunction sourceFunction = (AbstractFunction) sourceFunctionOutputPort.eContainer();
		AbstractFunction targetFunction = (AbstractFunction) targetFunctionInputPort.eContainer();

		Component sourceComponent = CapellaUtils.getInverseComponent(sourceFunction);
		Component targetComponent = CapellaUtils.getInverseComponent(targetFunction);

		Element sourceElement = (Element) MappingRulesManager.getCapellaObjectFromAllRules(sourceComponent);
		Element targetElement = (Element) MappingRulesManager.getCapellaObjectFromAllRules(targetComponent);

		Property sourceProperty = UMLFactory.eINSTANCE.createProperty();
		MappingUtils.generateUID(getAlgo(), source, sourceProperty, this, "s");
		Property targetProperty = UMLFactory.eINSTANCE.createProperty();
		MappingUtils.generateUID(getAlgo(), source, targetProperty, this, "t");

		sourceProperty.setAssociation(createAssociation);
		targetProperty.setAssociation(createAssociation);

		sourceProperty.setType((Type) sourceElement);
		targetProperty.setType((Type) targetElement);

		createAssociation.getOwnedEnds().add(sourceProperty);
		createAssociation.getOwnedEnds().add(targetProperty);

		if (eaContainer instanceof Element) {
			Model model = ((Element) eaContainer).getModel();
			org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package) model.getPackagedElements().get(0);
			pkgCapella.getPackagedElements().add(createAssociation);
		}

		return createAssociation;
	}

	@Override
	public void executeSubRules(List<FunctionalExchange> _capellaSource, MappingRulesManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

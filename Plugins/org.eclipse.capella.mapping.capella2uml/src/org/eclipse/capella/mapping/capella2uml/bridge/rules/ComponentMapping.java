/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class ComponentMapping extends AbstractDynamicMapping<CapellaElement, LogicalComponent, Capella2UMLAlgo> {

	private boolean _isLogicalSystem = false;

	public ComponentMapping(Capella2UMLAlgo algo, CapellaElement component, IMappingExecution execution) {
		super(algo, component, execution);
	}

	@Override
	public Object computeTargetContainer(CapellaElement capellaContainer) {
		if (capellaContainer instanceof LogicalArchitecture) {
			_isLogicalSystem = true;
			Project capellaProject = ProjectExt.getProject(capellaContainer);
			Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
			return model;
		} else {
			_isLogicalSystem = false;
			return (Component) MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
		}
	}

	@Override
	public List<LogicalComponent> findSourceElements(CapellaElement capellaContainer) {
		if (capellaContainer instanceof LogicalArchitecture) {
			LogicalComponent logicalSystem = CapellaUtils.getLogicalSystemRoot(capellaContainer);
			List<LogicalComponent> resutls = new ArrayList<>();
			resutls.add(logicalSystem);
			return resutls;
		}

		if (capellaContainer instanceof LogicalComponent) {
			List<LogicalComponent> ownedLogicalComponents = ((LogicalComponent) capellaContainer)
					.getOwnedLogicalComponents();
			return ownedLogicalComponents;
		}

		return Collections.emptyList();
	}

	@Override
	public Object compute(Object eaContainer, LogicalComponent source) {
		org.eclipse.uml2.uml.Component targetComponent = UMLFactory.eINSTANCE.createComponent();

		MappingUtils.generateUID(getAlgo(), source, targetComponent, this);
		XMIExtensionsUtils.createElement(targetComponent, getAlgo().getXMIExtension());

		targetComponent.setName(source.getName());
		if (eaContainer instanceof Model) {
			EList<PackageableElement> ownedMembers = ((Model) eaContainer).getPackagedElements();
			for (PackageableElement ownedMember : ownedMembers) {
				if (ownedMember.getName().equals("Import Capella"))
					((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(targetComponent);
			}

		} else if (eaContainer instanceof Component) {
			((Component) eaContainer).getNestedClassifiers().add(targetComponent);
		}

		return targetComponent;
	}

	@Override
	public void executeSubRules(List<LogicalComponent> _capellaSource, MappingRulesManager manager) {
		for (LogicalComponent logicalComponent : _capellaSource) {
			ComponentMapping componentMapping = new ComponentMapping(getAlgo(), logicalComponent,
					getMappingExucution());
			PortMapping portMapping = new PortMapping(getAlgo(), logicalComponent, getMappingExucution());

			// ExchangeMapping exchangeMapping = new ExchangeMapping(getAlgo(),
			// logicalComponent, getMappingExucution());

			manager.add(ComponentMapping.class.getName() + logicalComponent.getId(), componentMapping);
			manager.add(PortMapping.class.getName() + logicalComponent.getId(), portMapping);
			// manager.add(ExchangeMapping.class.getName() + logicalComponent.getId(),
			// exchangeMapping);
		}

		for (LogicalComponent logicalComponent : _capellaSource) {
			AggregationMapping aggregationMapping = new AggregationMapping(getAlgo(), logicalComponent,
					getMappingExucution());
			manager.add(aggregationMapping.getClass().getName(), aggregationMapping);

		}

	}

	@Override
	public String getUID(EObject key, String id) {
		if (key instanceof org.eclipse.uml2.uml.Class) {
			return "EAID_" + id;
		} else if (key instanceof Component) {
			return "EAID_" + id;
		}
		return "";
	}

}

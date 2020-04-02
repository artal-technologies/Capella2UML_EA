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
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Usage;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.core.data.fa.ComponentPort;
import org.polarsys.capella.core.data.fa.OrientationPortKind;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

import xmi.element;
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
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		port.setType(inter);
		if (inter != null) {
			if (orientation == OrientationPortKind.IN) {

				port.setIsConjugated(false);

				Realization realizationTarget = UMLFactory.eINSTANCE.createRealization();
				MappingUtils.generateUID(getAlgo(), source, realizationTarget, this, "r");
				realizationTarget.getClients().add(inter);

				realizationTarget.getSuppliers().add(port);

				XMIExtensionsUtils.addConnector(realizationTarget, getAlgo().getXMIExtension(), sysMLID, "Unspecified",
						"Relization", inter, port, false);

				Model model = port.getModel();
				org.eclipse.uml2.uml.Package pkgCapella = (org.eclipse.uml2.uml.Package) ((model).getPackagedElements()
						.get(0));
				int indexOf = pkgCapella.getPackagedElements().indexOf(inter);
				pkgCapella.getPackagedElements().add(indexOf + 1, realizationTarget);

			} else if (orientation == OrientationPortKind.OUT) {
				port.setIsConjugated(true);

				XMIExtensionsUtils.addXredPropIsConjugated(port, getAlgo().getXMIExtension());
				Usage createUsage = UMLFactory.eINSTANCE.createUsage();
				MappingUtils.generateUID(getAlgo(), source, createUsage, this, "us");

				createUsage.getClients().add(port);
				createUsage.getSuppliers().add((org.eclipse.uml2.uml.Interface) inter);

				Project project = ProjectExt.getProject(source);
				Object capellaObjectFromAllRules2 = MappingRulesManager.getCapellaObjectFromAllRules(project);

				EList<PackageableElement> packagedElements = ((Model) capellaObjectFromAllRules2).getPackagedElements();
				for (PackageableElement ownedMember : packagedElements) {
					if (ownedMember.getName().equals(SpecificUtils.getCapellaImportName(this)))
						((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(createUsage);
				}
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

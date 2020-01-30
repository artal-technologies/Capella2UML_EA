/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping;
import org.eclipse.capella.mapping.capella2uml.toMove.MappingUtils;
import org.eclipse.capella.mapping.capella2uml.toMove.XMIExtensionsUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.Interface;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class InterfaceMapping extends AbstractDynamicMapping<InterfacePkg, Interface, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public InterfaceMapping(Capella2UMLAlgo algo, InterfacePkg parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeEAContainer(java.lang.Object)
	 */
	@Override
	public Object computeEAContainer(InterfacePkg capellaContainer) {

		Project capellaProject = ProjectExt.getProject(capellaContainer);
		Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
		return model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * computeCapellaSource(java.lang.Object)
	 */
	@Override
	public List<Interface> computeCapellaSource(InterfacePkg capellaContainer) {
		List<Interface> ownedInterfaces = capellaContainer.getOwnedInterfaces();
		return ownedInterfaces;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, Interface source) {
		org.eclipse.uml2.uml.Interface targetInterface = UMLFactory.eINSTANCE.createInterface();
		generateUID(source, targetInterface, null);
		targetInterface.setName(source.getName());

		EList<ExchangeItem> exchangeItems = source.getExchangeItems();

		for (ExchangeItem exchangeItem : exchangeItems) {
			Object capellaObjectFromAllRules = MappingRulesManager.getCapellaObjectFromAllRules(exchangeItem);
			if (capellaObjectFromAllRules instanceof Classifier) {
				Property createProperty = UMLFactory.eINSTANCE.createProperty();
				createProperty.setName(exchangeItem.getName());
				generateUID(exchangeItem, createProperty, "property");
				targetInterface.getOwnedAttributes().add(createProperty);
				createProperty.setType((Classifier) capellaObjectFromAllRules);
			}
		}

		if (eaContainer instanceof Model) {
			EList<PackageableElement> ownedMembers = ((Model) eaContainer).getPackagedElements();
			for (PackageableElement ownedMember : ownedMembers) {
				if (ownedMember.getName().equals("Import Capella"))
					((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(targetInterface);
			}

		}

		return targetInterface;
	}

	private void generateUID(CapellaElement source, EObject targetComponent, String suffix) {
		if (suffix == null) {
			suffix = "";
		}
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		getAlgo().putId(targetComponent, this, sysMLID + suffix);
		XMIExtensionsUtils.addElement(targetComponent, getAlgo().getXMIExtension());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<Interface> _capellaSource, MappingRulesManager manager) {
		for (Interface interface1 : _capellaSource) {
			OperationExchangeItemMapping exchangeItemMapping = new OperationExchangeItemMapping(getAlgo(), interface1,
					getMappingExucution());
			manager.add(exchangeItemMapping.getClass().getName() + interface1.getId(), exchangeItemMapping);
		}

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

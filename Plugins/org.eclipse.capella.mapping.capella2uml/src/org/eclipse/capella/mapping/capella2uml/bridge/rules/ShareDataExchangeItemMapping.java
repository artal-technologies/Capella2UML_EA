/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping;
import org.eclipse.capella.mapping.capella2uml.toMove.MappingUtils;
import org.eclipse.capella.mapping.capella2uml.toMove.XMIExtensionsUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeMechanism;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public class ShareDataExchangeItemMapping
		extends AbstractDynamicMapping<LogicalArchitecture, ExchangeItem, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */	
	public ShareDataExchangeItemMapping(Capella2UMLAlgo algo, LogicalArchitecture parent,
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
	public Object computeEAContainer(LogicalArchitecture capellaContainer) {
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
	public List<ExchangeItem> computeCapellaSource(LogicalArchitecture capellaContainer) {

		List<ExchangeItem> eventEIs = EObjectExt.getAll(capellaContainer, InformationPackage.Literals.EXCHANGE_ITEM)
				.stream().map(ExchangeItem.class::cast)
				.filter(ei -> (ei.getExchangeMechanism() == ExchangeMechanism.SHARED_DATA))
				.collect(Collectors.toList());

		return eventEIs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#compute
	 * (java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object compute(Object eaContainer, ExchangeItem source) {
		Class classTarget = UMLFactory.eINSTANCE.createClass();
		generateUID(source, classTarget);
		classTarget.setName(source.getName());

		if (eaContainer instanceof Model) {
			EList<PackageableElement> ownedMembers = ((Model) eaContainer).getPackagedElements();
			for (PackageableElement ownedMember : ownedMembers) {
				if (ownedMember.getName().equals("Import Capella"))
					((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(classTarget);
			}

//			Profile profile = (Profile) getAlgo().getXMIExtension().getProfiles().getProfile();
//			Stereotype ownedStereotype = profile.getOwnedStereotype("entity");
//			classTarget.applyStereotype(ownedStereotype);

		}

		// TODO manage entity profile

		return classTarget;
	}

	private void generateUID(CapellaElement source, EObject targetComponent) {
		Resource eResource = source.eResource();
		String sysMLID = MappingUtils.getSysMLID(eResource, source);
		getAlgo().putId(targetComponent, this, sysMLID);
		XMIExtensionsUtils.addElement(targetComponent, getAlgo().getXMIExtension(), sysMLID + "entity");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<ExchangeItem> _capellaSource, MappingRulesManager manager) {
		for (ExchangeItem exchangeItem : _capellaSource) {
			ShareDataExchangeItemElementMapping elementMapping = new ShareDataExchangeItemElementMapping(getAlgo(),
					exchangeItem, getMappingExucution());
			manager.add(elementMapping.getClass().getName() + exchangeItem.getId(), elementMapping);
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

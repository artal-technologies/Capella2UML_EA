/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge.rules;

import java.util.List;

import org.eclipse.capella.mapping.capella2uml.bridge.Capella2UMLAlgo;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.information.Class;
import org.polarsys.capella.core.data.information.DataPkg;

import com.artal.capella.mapping.CapellaUtils;
import com.artal.capella.mapping.MappingUtils;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.rules.commons.CommonClassMapping;

import xmi.element;
import xmi.util.XMIExtensionsUtils;

/**
 * @author binot
 *
 */
public class ClassMapping extends CommonClassMapping<DataPkg, Capella2UMLAlgo> {

	/**
	 * @param algo
	 * @param parent
	 * @param mappingExecution
	 */
	public ClassMapping(Capella2UMLAlgo algo, DataPkg parent, IMappingExecution mappingExecution) {
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
	public Object compute(Object eaContainer, Class source) {

		DataType targetdataType = UMLFactory.eINSTANCE.createDataType();

		MappingUtils.generateUID(getAlgo(), source, targetdataType, this);
		element targetelement = XMIExtensionsUtils.createElement(targetdataType, getAlgo().getXMIExtension());

		CapellaElement ce = (CapellaElement)source;
		if (CapellaUtils.hasStereotype(ce)){
		 XMIExtensionsUtils.createStereotypeProperties(targetelement, CapellaUtils.getSterotypeName(ce), "Class");
		}

		targetdataType.setName(source.getName());
		if (eaContainer instanceof Model) {
			EList<PackageableElement> ownedMembers = ((Model) eaContainer).getPackagedElements();
			for (PackageableElement ownedMember : ownedMembers) {
				if (ownedMember.getName().equals("Import Capella"))
					((org.eclipse.uml2.uml.Package) ownedMember).getPackagedElements().add(targetdataType);
			}
		}

		return targetdataType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.capella.mapping.capella2uml.toMove.AbstractDynamicMapping#
	 * executeSubRules(java.util.List,
	 * com.artal.capella.mapping.rules.MappingRulesManager)
	 */
	@Override
	public void executeSubRules(List<Class> _capellaSource, MappingRulesManager manager) {

	}

}

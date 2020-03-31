/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.information.datatype.DataType;
import org.polarsys.capella.core.data.information.datatype.DatatypePackage;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonDatatypeMapping< ALGO extends CapellaBridgeAlgo<?>>
		extends
		AbstractDynamicMapping<DataPkg, org.polarsys.capella.core.data.information.datatype.DataType, ALGO> {

	public CommonDatatypeMapping(ALGO algo, DataPkg parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
	}

	@Override
	public Object computeTargetContainer(DataPkg capellaContainer) {

//		Project capellaProject = ProjectExt.getProject(capellaContainer);
//		Model model = (Model) MappingRulesManager.getCapellaObjectFromAllRules(capellaProject);
		return MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);
	}

	@Override
	public List<DataType> findSourceElements(DataPkg capellaContainer) {

		EList<DataType> ownedDataTypes = capellaContainer.getOwnedDataTypes();
		
//		List<DataType> primitives = EObjectExt.getAll(capellaContainer, DatatypePackage.Literals.DATA_TYPE).stream()
//				.map(DataType.class::cast).collect(Collectors.toList());

		return ownedDataTypes;

	}

}

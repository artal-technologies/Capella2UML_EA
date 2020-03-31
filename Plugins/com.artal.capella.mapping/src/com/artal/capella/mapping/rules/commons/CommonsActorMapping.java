/**
 * 
 */
package com.artal.capella.mapping.rules.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.AbstractActor;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.data.fa.AbstractFunctionalStructure;
import org.polarsys.capella.core.data.la.LogicalActor;
import org.polarsys.capella.core.data.la.LogicalActorPkg;
import org.polarsys.capella.core.data.pa.PhysicalActor;
import org.polarsys.capella.core.data.pa.PhysicalActorPkg;
import org.polarsys.capella.core.model.helpers.ProjectExt;

import com.artal.capella.mapping.CapellaBridgeAlgo;
import com.artal.capella.mapping.rules.AbstractDynamicMapping;
import com.artal.capella.mapping.rules.MappingRulesManager;

/**
 * @author binot
 *
 */
public abstract class CommonsActorMapping<ALGO extends CapellaBridgeAlgo<?>>
		extends AbstractDynamicMapping<AbstractFunctionalStructure, AbstractActor, ALGO> {

	public CommonsActorMapping(ALGO algo, AbstractFunctionalStructure parent, IMappingExecution mappingExecution) {
		super(algo, parent, mappingExecution);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object computeTargetContainer(AbstractFunctionalStructure capellaContainer) {
		return MappingRulesManager.getCapellaObjectFromAllRules(capellaContainer);

	}

	@Override
	public List<AbstractActor> findSourceElements(AbstractFunctionalStructure capellaContainer) {
		List<AbstractActor> results = new ArrayList<AbstractActor>();
		if (capellaContainer instanceof LogicalActorPkg) {
			results.addAll(((LogicalActorPkg) capellaContainer).getOwnedLogicalActors());
		}
		if (capellaContainer instanceof PhysicalActorPkg) {
			results.addAll(((PhysicalActorPkg) capellaContainer).getOwnedPhysicalActors());
		}
		return results;
	}

	@Override
	public String getUID(EObject key, String id) {
		return "EAID_" + id;
	}

}

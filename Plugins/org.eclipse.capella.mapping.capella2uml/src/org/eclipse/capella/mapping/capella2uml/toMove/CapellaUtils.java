/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.toMove;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.polarsys.capella.core.data.capellacore.ModellingArchitecture;
import org.polarsys.capella.core.data.capellamodeller.ModelRoot;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.capellamodeller.SystemEngineering;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.InterfacePkg;
import org.polarsys.capella.core.data.information.DataPkg;
import org.polarsys.capella.core.data.la.LogicalActorPkg;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.la.LogicalComponent;

/**
 * @author binot
 *
 */
public class CapellaUtils {

	static public boolean isLogicalSystem(Component component) {
		if (component.eContainer() instanceof LogicalArchitecture) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the logical component system root given a semantic object
	 * 
	 * @param source_p
	 *            the semantic object
	 * @return the logical component root
	 */
	public static LogicalComponent getLogicalSystemRoot(EObject source_p) {
		ResourceSet resourceSet = source_p.eResource().getResourceSet();
		URI semanticResourceURI = source_p.eResource().getURI().trimFileExtension()
				.appendFileExtension("melodymodeller");
		Resource semanticResource = resourceSet.getResource(semanticResourceURI, false);
		if (semanticResource != null) {
			EObject root = semanticResource.getContents().get(0);
			if (root instanceof Project) {
				EList<ModelRoot> ownedModelRoots = ((Project) root).getOwnedModelRoots();
				for (ModelRoot modelRoot : ownedModelRoots) {
					if (modelRoot instanceof SystemEngineering) {
						EList<ModellingArchitecture> containedLogicalArchitecture = ((SystemEngineering) modelRoot)
								.getOwnedArchitectures();
						for (ModellingArchitecture arch : containedLogicalArchitecture) {
							if (arch instanceof LogicalArchitecture)
								return ((LogicalArchitecture) arch).getOwnedLogicalComponent();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the logical component system root given a semantic object
	 * 
	 * @param source_p
	 *            the semantic object
	 * @return the logical component root
	 */
	public static LogicalActorPkg getLogicalActorPkg(EObject source_p) {
		ResourceSet resourceSet = source_p.eResource().getResourceSet();
		URI semanticResourceURI = source_p.eResource().getURI().trimFileExtension()
				.appendFileExtension("melodymodeller");
		Resource semanticResource = resourceSet.getResource(semanticResourceURI, false);
		if (semanticResource != null) {
			EObject root = semanticResource.getContents().get(0);
			if (root instanceof Project) {
				EList<ModelRoot> ownedModelRoots = ((Project) root).getOwnedModelRoots();
				for (ModelRoot modelRoot : ownedModelRoots) {
					if (modelRoot instanceof SystemEngineering) {
						EList<ModellingArchitecture> containedLogicalArchitecture = ((SystemEngineering) modelRoot)
								.getOwnedArchitectures();
						for (ModellingArchitecture arch : containedLogicalArchitecture) {
							if (arch instanceof LogicalArchitecture)
								return ((LogicalArchitecture) arch).getOwnedLogicalActorPkg();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the logical architecture system root given a semantic object
	 * 
	 * @param source_p
	 *            the semantic object
	 * @return the logical component root
	 */
	public static LogicalArchitecture getLogicalArchitecture(EObject source_p) {
		ResourceSet resourceSet = source_p.eResource().getResourceSet();
		URI semanticResourceURI = source_p.eResource().getURI().trimFileExtension()
				.appendFileExtension("melodymodeller");
		Resource semanticResource = resourceSet.getResource(semanticResourceURI, false);
		if (semanticResource != null) {
			EObject root = semanticResource.getContents().get(0);
			if (root instanceof Project) {
				EList<ModelRoot> ownedModelRoots = ((Project) root).getOwnedModelRoots();
				for (ModelRoot modelRoot : ownedModelRoots) {
					if (modelRoot instanceof SystemEngineering) {
						EList<ModellingArchitecture> containedLogicalArchitecture = ((SystemEngineering) modelRoot)
								.getOwnedArchitectures();
						for (ModellingArchitecture arch : containedLogicalArchitecture) {
							if (arch instanceof LogicalArchitecture)
								return ((LogicalArchitecture) arch);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the interface package given a semantic object
	 * 
	 * @param source_p
	 *            the semantic object
	 * @return the data pkg root
	 */
	public static InterfacePkg getInterfacePkgRoot(EObject source_p) {
		ResourceSet resourceSet = source_p.eResource().getResourceSet();
		URI semanticResourceURI = source_p.eResource().getURI().trimFileExtension()
				.appendFileExtension("melodymodeller");
		Resource semanticResource = resourceSet.getResource(semanticResourceURI, false);
		if (semanticResource != null) {
			EObject root = semanticResource.getContents().get(0);
			if (root instanceof Project) {
				EList<ModelRoot> ownedModelRoots = ((Project) root).getOwnedModelRoots();
				for (ModelRoot modelRoot : ownedModelRoots) {
					if (modelRoot instanceof SystemEngineering) {
						EList<ModellingArchitecture> containedLogicalArchitecture = ((SystemEngineering) modelRoot)
								.getOwnedArchitectures();
						for (ModellingArchitecture arch : containedLogicalArchitecture) {
							if (arch instanceof LogicalArchitecture)
								return ((LogicalArchitecture) arch).getOwnedInterfacePkg();
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the data package given a semantic object
	 * 
	 * @param source_p
	 *            the semantic object
	 * @return the data pkg root
	 */
	public static DataPkg getDataPkgRoot(EObject source_p) {
		ResourceSet resourceSet = source_p.eResource().getResourceSet();
		URI semanticResourceURI = source_p.eResource().getURI().trimFileExtension()
				.appendFileExtension("melodymodeller");
		Resource semanticResource = resourceSet.getResource(semanticResourceURI, false);
		if (semanticResource != null) {
			EObject root = semanticResource.getContents().get(0);
			if (root instanceof Project) {
				EList<ModelRoot> ownedModelRoots = ((Project) root).getOwnedModelRoots();
				for (ModelRoot modelRoot : ownedModelRoots) {
					if (modelRoot instanceof SystemEngineering) {
						EList<ModellingArchitecture> containedLogicalArchitecture = ((SystemEngineering) modelRoot)
								.getOwnedArchitectures();
						for (ModellingArchitecture arch : containedLogicalArchitecture) {
							if (arch instanceof LogicalArchitecture)
								return ((LogicalArchitecture) arch).getOwnedDataPkg();
						}
					}
				}
			}
		}
		return null;
	}

}

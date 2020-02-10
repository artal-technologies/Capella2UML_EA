/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.capella.core.data.capellamodeller.Project;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;
import com.artal.capella.mapping.rules.MappingRulesManager;
import com.artal.capella.mapping.uml.UMLBridgeAlgo;

import xmi.Extension;

/**
 * @author binot
 *
 */
public class Capella2UMLAlgo extends UMLBridgeAlgo<Project> {

	public Capella2UMLAlgo(AbstractMappingAlgoMix<?, ?> mix) {
		super(mix);
	}

	private Extension _xmiExtension;
	private List<Profile> _profiles;
//	private EClass typeClass;
//	private EFactory bookFactoryInstance;
//	private EReference typeRef;

	@Override
	public void launch(Project source_p, IMappingExecution _mappingExecution) {
		MappingRulesManager.clearRules();

//		/*
//		 * Instantiate EcoreFactory
//		 */
//		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
//		/*
//		 * Create EClass instance to model BookStore class
//		 */
//		typeClass = theCoreFactory.createEClass();
//		typeClass.setName("type");
//
//		EPackage bookStoreEPackage = theCoreFactory.createEPackage();
//		bookStoreEPackage.setName("uml");
//		bookStoreEPackage.setNsPrefix("uml");
//		bookStoreEPackage.setNsURI("http://www.eclipse.org/uml2/5.0.0/UML");
//		 typeRef = theCoreFactory.createEReference();
//		typeRef.setName("type");
//		typeRef.setEType(typeClass);
//		typeRef.setContainment(true);
//
//		EReference idref = theCoreFactory.createEReference();
//		idref.setName("xmi:idref");
//		idref.setEType(EcorePackage.eINSTANCE.getEObject());
//		typeClass.getEStructuralFeatures().add(idref);
//
//		EClass property = UMLPackage.eINSTANCE.getProperty();
//		property.getEStructuralFeatures().add(typeRef);
//
//		 bookFactoryInstance = bookStoreEPackage.getEFactoryInstance();
		
		super.launch(source_p, _mappingExecution);
	}

//	public EReference getTypeRef() {
//		return typeRef;
//	}
//	
//	public EFactory getBookFactoryInstance() {
//		return bookFactoryInstance;
//	}
//	
//	public EClass getTypeClass() {
//		return typeClass;
//	}

	public void setXMIExtension(Extension xmiExtension) {
		_xmiExtension = xmiExtension;
	}

	public Extension getXMIExtension() {
		return _xmiExtension;
	}

	public List<Profile> getProfiles() {
		if (_profiles == null) {
			_profiles = new ArrayList<>();
		}
		return _profiles;
	}

	/**
	 * @return
	 */
	public boolean useUIDs() {
		return true;
	}

	/**
	 * @return
	 */
	public boolean createUIDs() {
		return true;
	}

}

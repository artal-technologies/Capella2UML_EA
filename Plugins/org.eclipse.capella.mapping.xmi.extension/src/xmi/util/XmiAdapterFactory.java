/**
 */
package xmi.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import xmi.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see xmi.XmiPackage
 * @generated
 */
public class XmiAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XmiPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmiAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XmiPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XmiSwitch<Adapter> modelSwitch =
		new XmiSwitch<Adapter>() {
			@Override
			public Adapter caseExtension(Extension object) {
				return createExtensionAdapter();
			}
			@Override
			public Adapter caseDocumentation(Documentation object) {
				return createDocumentationAdapter();
			}
			@Override
			public Adapter caseelements(elements object) {
				return createelementsAdapter();
			}
			@Override
			public Adapter caseelement(element object) {
				return createelementAdapter();
			}
			@Override
			public Adapter casexrefs(xrefs object) {
				return createxrefsAdapter();
			}
			@Override
			public Adapter caseprofiles(profiles object) {
				return createprofilesAdapter();
			}
			@Override
			public Adapter caseproperties(properties object) {
				return createpropertiesAdapter();
			}
			@Override
			public Adapter casePackagedElement(PackagedElement object) {
				return createPackagedElementAdapter();
			}
			@Override
			public Adapter caseumlProfile(umlProfile object) {
				return createumlProfileAdapter();
			}
			@Override
			public Adapter caseownedEnd(ownedEnd object) {
				return createownedEndAdapter();
			}
			@Override
			public Adapter casepackageImport(packageImport object) {
				return createpackageImportAdapter();
			}
			@Override
			public Adapter caseimportedPackage(importedPackage object) {
				return createimportedPackageAdapter();
			}
			@Override
			public Adapter caseownedAttribute(ownedAttribute object) {
				return createownedAttributeAdapter();
			}
			@Override
			public Adapter casetype(type object) {
				return createtypeAdapter();
			}
			@Override
			public Adapter caseextendedProperties(extendedProperties object) {
				return createextendedPropertiesAdapter();
			}
			@Override
			public Adapter caseattributes(attributes object) {
				return createattributesAdapter();
			}
			@Override
			public Adapter caseattribute(attribute object) {
				return createattributeAdapter();
			}
			@Override
			public Adapter casestereotype(stereotype object) {
				return createstereotypeAdapter();
			}
			@Override
			public Adapter caseconstraints(constraints object) {
				return createconstraintsAdapter();
			}
			@Override
			public Adapter caseconstraint(constraint object) {
				return createconstraintAdapter();
			}
			@Override
			public Adapter caseconnectors(connectors object) {
				return createconnectorsAdapter();
			}
			@Override
			public Adapter caseconnector(connector object) {
				return createconnectorAdapter();
			}
			@Override
			public Adapter casemodel(model object) {
				return createmodelAdapter();
			}
			@Override
			public Adapter casesource(source object) {
				return createsourceAdapter();
			}
			@Override
			public Adapter casetarget(target object) {
				return createtargetAdapter();
			}
			@Override
			public Adapter caserole(role object) {
				return createroleAdapter();
			}
			@Override
			public Adapter casetags(tags object) {
				return createtagsAdapter();
			}
			@Override
			public Adapter casetag(tag object) {
				return createtagAdapter();
			}
			@Override
			public Adapter caseoperations(operations object) {
				return createoperationsAdapter();
			}
			@Override
			public Adapter caseoperation(operation object) {
				return createoperationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link xmi.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.Extension
	 * @generated
	 */
	public Adapter createExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.Documentation
	 * @generated
	 */
	public Adapter createDocumentationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.elements <em>elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.elements
	 * @generated
	 */
	public Adapter createelementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.element <em>element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.element
	 * @generated
	 */
	public Adapter createelementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.xrefs <em>xrefs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.xrefs
	 * @generated
	 */
	public Adapter createxrefsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.profiles <em>profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.profiles
	 * @generated
	 */
	public Adapter createprofilesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.properties <em>properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.properties
	 * @generated
	 */
	public Adapter createpropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.PackagedElement <em>Packaged Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.PackagedElement
	 * @generated
	 */
	public Adapter createPackagedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.umlProfile <em>uml Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.umlProfile
	 * @generated
	 */
	public Adapter createumlProfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.ownedEnd <em>owned End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.ownedEnd
	 * @generated
	 */
	public Adapter createownedEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.packageImport <em>package Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.packageImport
	 * @generated
	 */
	public Adapter createpackageImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.importedPackage <em>imported Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.importedPackage
	 * @generated
	 */
	public Adapter createimportedPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.ownedAttribute <em>owned Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.ownedAttribute
	 * @generated
	 */
	public Adapter createownedAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.type <em>type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.type
	 * @generated
	 */
	public Adapter createtypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.extendedProperties <em>extended Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.extendedProperties
	 * @generated
	 */
	public Adapter createextendedPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.attributes <em>attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.attributes
	 * @generated
	 */
	public Adapter createattributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.attribute <em>attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.attribute
	 * @generated
	 */
	public Adapter createattributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.stereotype <em>stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.stereotype
	 * @generated
	 */
	public Adapter createstereotypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.constraints <em>constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.constraints
	 * @generated
	 */
	public Adapter createconstraintsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.constraint <em>constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.constraint
	 * @generated
	 */
	public Adapter createconstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.connectors <em>connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.connectors
	 * @generated
	 */
	public Adapter createconnectorsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.connector <em>connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.connector
	 * @generated
	 */
	public Adapter createconnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.model <em>model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.model
	 * @generated
	 */
	public Adapter createmodelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.source <em>source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.source
	 * @generated
	 */
	public Adapter createsourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.target <em>target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.target
	 * @generated
	 */
	public Adapter createtargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.role <em>role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.role
	 * @generated
	 */
	public Adapter createroleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.tags <em>tags</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.tags
	 * @generated
	 */
	public Adapter createtagsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.tag <em>tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.tag
	 * @generated
	 */
	public Adapter createtagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.operations <em>operations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.operations
	 * @generated
	 */
	public Adapter createoperationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link xmi.operation <em>operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see xmi.operation
	 * @generated
	 */
	public Adapter createoperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //XmiAdapterFactory

/**
 */
package xmi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documentation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xmi.Documentation#getExporter <em>Exporter</em>}</li>
 *   <li>{@link xmi.Documentation#getExporterVersion <em>Exporter Version</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#getDocumentation()
 * @model
 * @generated
 */
public interface Documentation extends EObject {
	/**
	 * Returns the value of the '<em><b>Exporter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exporter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exporter</em>' attribute.
	 * @see #setExporter(String)
	 * @see xmi.XmiPackage#getDocumentation_Exporter()
	 * @model
	 * @generated
	 */
	String getExporter();

	/**
	 * Sets the value of the '{@link xmi.Documentation#getExporter <em>Exporter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exporter</em>' attribute.
	 * @see #getExporter()
	 * @generated
	 */
	void setExporter(String value);

	/**
	 * Returns the value of the '<em><b>Exporter Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exporter Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exporter Version</em>' attribute.
	 * @see #setExporterVersion(String)
	 * @see xmi.XmiPackage#getDocumentation_ExporterVersion()
	 * @model
	 * @generated
	 */
	String getExporterVersion();

	/**
	 * Sets the value of the '{@link xmi.Documentation#getExporterVersion <em>Exporter Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exporter Version</em>' attribute.
	 * @see #getExporterVersion()
	 * @generated
	 */
	void setExporterVersion(String value);

} // Documentation

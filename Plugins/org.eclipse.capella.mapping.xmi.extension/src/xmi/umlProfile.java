/**
 */
package xmi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>uml Profile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xmi.umlProfile#getPackagedElement <em>Packaged Element</em>}</li>
 *   <li>{@link xmi.umlProfile#getMemberEnd <em>Member End</em>}</li>
 *   <li>{@link xmi.umlProfile#getXmiversion <em>Xmiversion</em>}</li>
 *   <li>{@link xmi.umlProfile#getXmlnsuml <em>Xmlnsuml</em>}</li>
 *   <li>{@link xmi.umlProfile#getXmlnsxmi <em>Xmlnsxmi</em>}</li>
 *   <li>{@link xmi.umlProfile#getXmiid <em>Xmiid</em>}</li>
 *   <li>{@link xmi.umlProfile#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link xmi.umlProfile#getMetamodelReference <em>Metamodel Reference</em>}</li>
 * </ul>
 *
 * @see xmi.XmiPackage#getumlProfile()
 * @model
 * @generated
 */
public interface umlProfile extends EObject {
	/**
	 * Returns the value of the '<em><b>Packaged Element</b></em>' reference list.
	 * The list contents are of type {@link xmi.PackagedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packaged Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packaged Element</em>' reference list.
	 * @see xmi.XmiPackage#getumlProfile_PackagedElement()
	 * @model
	 * @generated
	 */
	EList<PackagedElement> getPackagedElement();

	/**
	 * Returns the value of the '<em><b>Member End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member End</em>' attribute.
	 * @see #setMemberEnd(String)
	 * @see xmi.XmiPackage#getumlProfile_MemberEnd()
	 * @model
	 * @generated
	 */
	String getMemberEnd();

	/**
	 * Sets the value of the '{@link xmi.umlProfile#getMemberEnd <em>Member End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member End</em>' attribute.
	 * @see #getMemberEnd()
	 * @generated
	 */
	void setMemberEnd(String value);

	/**
	 * Returns the value of the '<em><b>Xmiversion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmiversion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmiversion</em>' attribute.
	 * @see #setXmiversion(String)
	 * @see xmi.XmiPackage#getumlProfile_Xmiversion()
	 * @model
	 * @generated
	 */
	String getXmiversion();

	/**
	 * Sets the value of the '{@link xmi.umlProfile#getXmiversion <em>Xmiversion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmiversion</em>' attribute.
	 * @see #getXmiversion()
	 * @generated
	 */
	void setXmiversion(String value);

	/**
	 * Returns the value of the '<em><b>Xmlnsuml</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmlnsuml</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmlnsuml</em>' attribute.
	 * @see #setXmlnsuml(String)
	 * @see xmi.XmiPackage#getumlProfile_Xmlnsuml()
	 * @model
	 * @generated
	 */
	String getXmlnsuml();

	/**
	 * Sets the value of the '{@link xmi.umlProfile#getXmlnsuml <em>Xmlnsuml</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmlnsuml</em>' attribute.
	 * @see #getXmlnsuml()
	 * @generated
	 */
	void setXmlnsuml(String value);

	/**
	 * Returns the value of the '<em><b>Xmlnsxmi</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmlnsxmi</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmlnsxmi</em>' attribute.
	 * @see #setXmlnsxmi(String)
	 * @see xmi.XmiPackage#getumlProfile_Xmlnsxmi()
	 * @model
	 * @generated
	 */
	String getXmlnsxmi();

	/**
	 * Sets the value of the '{@link xmi.umlProfile#getXmlnsxmi <em>Xmlnsxmi</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmlnsxmi</em>' attribute.
	 * @see #getXmlnsxmi()
	 * @generated
	 */
	void setXmlnsxmi(String value);

	/**
	 * Returns the value of the '<em><b>Xmiid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmiid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmiid</em>' attribute.
	 * @see #setXmiid(String)
	 * @see xmi.XmiPackage#getumlProfile_Xmiid()
	 * @model
	 * @generated
	 */
	String getXmiid();

	/**
	 * Sets the value of the '{@link xmi.umlProfile#getXmiid <em>Xmiid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmiid</em>' attribute.
	 * @see #getXmiid()
	 * @generated
	 */
	void setXmiid(String value);

	/**
	 * Returns the value of the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns Prefix</em>' attribute.
	 * @see #setNsPrefix(String)
	 * @see xmi.XmiPackage#getumlProfile_NsPrefix()
	 * @model
	 * @generated
	 */
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link xmi.umlProfile#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Metamodel Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Reference</em>' attribute.
	 * @see #setMetamodelReference(String)
	 * @see xmi.XmiPackage#getumlProfile_MetamodelReference()
	 * @model
	 * @generated
	 */
	String getMetamodelReference();

	/**
	 * Sets the value of the '{@link xmi.umlProfile#getMetamodelReference <em>Metamodel Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel Reference</em>' attribute.
	 * @see #getMetamodelReference()
	 * @generated
	 */
	void setMetamodelReference(String value);

} // umlProfile

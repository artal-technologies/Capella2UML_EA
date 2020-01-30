/**
 */
package xmi.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xmi.XmiPackage;
import xmi.element;
import xmi.properties;
import xmi.xrefs;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link xmi.impl.elementImpl#getName <em>Name</em>}</li>
 *   <li>{@link xmi.impl.elementImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link xmi.impl.elementImpl#getXrefs <em>Xrefs</em>}</li>
 *   <li>{@link xmi.impl.elementImpl#getXmiidref <em>Xmiidref</em>}</li>
 *   <li>{@link xmi.impl.elementImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link xmi.impl.elementImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class elementImpl extends MinimalEObjectImpl.Container implements element {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final String SCOPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected String scope = SCOPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getXrefs() <em>Xrefs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXrefs()
	 * @generated
	 * @ordered
	 */
	protected xrefs xrefs;

	/**
	 * The cached value of the '{@link #getXmiidref() <em>Xmiidref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiidref()
	 * @generated
	 * @ordered
	 */
	protected EObject xmiidref;

	/**
	 * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifier()
	 * @generated
	 * @ordered
	 */
	protected EObject classifier;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected properties properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected elementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmiPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(String newScope) {
		String oldScope = scope;
		scope = newScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ELEMENT__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public xrefs getXrefs() {
		return xrefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetXrefs(xrefs newXrefs, NotificationChain msgs) {
		xrefs oldXrefs = xrefs;
		xrefs = newXrefs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmiPackage.ELEMENT__XREFS, oldXrefs, newXrefs);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXrefs(xrefs newXrefs) {
		if (newXrefs != xrefs) {
			NotificationChain msgs = null;
			if (xrefs != null)
				msgs = ((InternalEObject)xrefs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmiPackage.ELEMENT__XREFS, null, msgs);
			if (newXrefs != null)
				msgs = ((InternalEObject)newXrefs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmiPackage.ELEMENT__XREFS, null, msgs);
			msgs = basicSetXrefs(newXrefs, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ELEMENT__XREFS, newXrefs, newXrefs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getXmiidref() {
		if (xmiidref != null && xmiidref.eIsProxy()) {
			InternalEObject oldXmiidref = (InternalEObject)xmiidref;
			xmiidref = eResolveProxy(oldXmiidref);
			if (xmiidref != oldXmiidref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmiPackage.ELEMENT__XMIIDREF, oldXmiidref, xmiidref));
			}
		}
		return xmiidref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetXmiidref() {
		return xmiidref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXmiidref(EObject newXmiidref) {
		EObject oldXmiidref = xmiidref;
		xmiidref = newXmiidref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ELEMENT__XMIIDREF, oldXmiidref, xmiidref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getClassifier() {
		if (classifier != null && classifier.eIsProxy()) {
			InternalEObject oldClassifier = (InternalEObject)classifier;
			classifier = eResolveProxy(oldClassifier);
			if (classifier != oldClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmiPackage.ELEMENT__CLASSIFIER, oldClassifier, classifier));
			}
		}
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetClassifier() {
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifier(EObject newClassifier) {
		EObject oldClassifier = classifier;
		classifier = newClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ELEMENT__CLASSIFIER, oldClassifier, classifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public properties getProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(properties newProperties, NotificationChain msgs) {
		properties oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmiPackage.ELEMENT__PROPERTIES, oldProperties, newProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperties(properties newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null)
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmiPackage.ELEMENT__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmiPackage.ELEMENT__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ELEMENT__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmiPackage.ELEMENT__XREFS:
				return basicSetXrefs(null, msgs);
			case XmiPackage.ELEMENT__PROPERTIES:
				return basicSetProperties(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmiPackage.ELEMENT__NAME:
				return getName();
			case XmiPackage.ELEMENT__SCOPE:
				return getScope();
			case XmiPackage.ELEMENT__XREFS:
				return getXrefs();
			case XmiPackage.ELEMENT__XMIIDREF:
				if (resolve) return getXmiidref();
				return basicGetXmiidref();
			case XmiPackage.ELEMENT__CLASSIFIER:
				if (resolve) return getClassifier();
				return basicGetClassifier();
			case XmiPackage.ELEMENT__PROPERTIES:
				return getProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case XmiPackage.ELEMENT__NAME:
				setName((String)newValue);
				return;
			case XmiPackage.ELEMENT__SCOPE:
				setScope((String)newValue);
				return;
			case XmiPackage.ELEMENT__XREFS:
				setXrefs((xrefs)newValue);
				return;
			case XmiPackage.ELEMENT__XMIIDREF:
				setXmiidref((EObject)newValue);
				return;
			case XmiPackage.ELEMENT__CLASSIFIER:
				setClassifier((EObject)newValue);
				return;
			case XmiPackage.ELEMENT__PROPERTIES:
				setProperties((properties)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case XmiPackage.ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case XmiPackage.ELEMENT__SCOPE:
				setScope(SCOPE_EDEFAULT);
				return;
			case XmiPackage.ELEMENT__XREFS:
				setXrefs((xrefs)null);
				return;
			case XmiPackage.ELEMENT__XMIIDREF:
				setXmiidref((EObject)null);
				return;
			case XmiPackage.ELEMENT__CLASSIFIER:
				setClassifier((EObject)null);
				return;
			case XmiPackage.ELEMENT__PROPERTIES:
				setProperties((properties)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case XmiPackage.ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case XmiPackage.ELEMENT__SCOPE:
				return SCOPE_EDEFAULT == null ? scope != null : !SCOPE_EDEFAULT.equals(scope);
			case XmiPackage.ELEMENT__XREFS:
				return xrefs != null;
			case XmiPackage.ELEMENT__XMIIDREF:
				return xmiidref != null;
			case XmiPackage.ELEMENT__CLASSIFIER:
				return classifier != null;
			case XmiPackage.ELEMENT__PROPERTIES:
				return properties != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", scope: ");
		result.append(scope);
		result.append(')');
		return result.toString();
	}

} //elementImpl

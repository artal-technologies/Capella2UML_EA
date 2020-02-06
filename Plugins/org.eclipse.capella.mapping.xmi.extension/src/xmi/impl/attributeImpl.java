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
import xmi.attribute;
import xmi.extendedProperties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link xmi.impl.attributeImpl#getExtendedProperties <em>Extended Properties</em>}</li>
 *   <li>{@link xmi.impl.attributeImpl#getTagged <em>Tagged</em>}</li>
 *   <li>{@link xmi.impl.attributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link xmi.impl.attributeImpl#getXmiidref <em>Xmiidref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class attributeImpl extends MinimalEObjectImpl.Container implements attribute {
	/**
	 * The cached value of the '{@link #getExtendedProperties() <em>Extended Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedProperties()
	 * @generated
	 * @ordered
	 */
	protected extendedProperties extendedProperties;

	/**
	 * The default value of the '{@link #getTagged() <em>Tagged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagged()
	 * @generated
	 * @ordered
	 */
	protected static final String TAGGED_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTagged() <em>Tagged</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTagged()
	 * @generated
	 * @ordered
	 */
	protected String tagged = TAGGED_EDEFAULT;

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
	 * The cached value of the '{@link #getXmiidref() <em>Xmiidref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmiidref()
	 * @generated
	 * @ordered
	 */
	protected EObject xmiidref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected attributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmiPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public extendedProperties getExtendedProperties() {
		return extendedProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtendedProperties(extendedProperties newExtendedProperties, NotificationChain msgs) {
		extendedProperties oldExtendedProperties = extendedProperties;
		extendedProperties = newExtendedProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmiPackage.ATTRIBUTE__EXTENDED_PROPERTIES, oldExtendedProperties, newExtendedProperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedProperties(extendedProperties newExtendedProperties) {
		if (newExtendedProperties != extendedProperties) {
			NotificationChain msgs = null;
			if (extendedProperties != null)
				msgs = ((InternalEObject)extendedProperties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmiPackage.ATTRIBUTE__EXTENDED_PROPERTIES, null, msgs);
			if (newExtendedProperties != null)
				msgs = ((InternalEObject)newExtendedProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmiPackage.ATTRIBUTE__EXTENDED_PROPERTIES, null, msgs);
			msgs = basicSetExtendedProperties(newExtendedProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ATTRIBUTE__EXTENDED_PROPERTIES, newExtendedProperties, newExtendedProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTagged() {
		return tagged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTagged(String newTagged) {
		String oldTagged = tagged;
		tagged = newTagged;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ATTRIBUTE__TAGGED, oldTagged, tagged));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ATTRIBUTE__NAME, oldName, name));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmiPackage.ATTRIBUTE__XMIIDREF, oldXmiidref, xmiidref));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.ATTRIBUTE__XMIIDREF, oldXmiidref, xmiidref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmiPackage.ATTRIBUTE__EXTENDED_PROPERTIES:
				return basicSetExtendedProperties(null, msgs);
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
			case XmiPackage.ATTRIBUTE__EXTENDED_PROPERTIES:
				return getExtendedProperties();
			case XmiPackage.ATTRIBUTE__TAGGED:
				return getTagged();
			case XmiPackage.ATTRIBUTE__NAME:
				return getName();
			case XmiPackage.ATTRIBUTE__XMIIDREF:
				if (resolve) return getXmiidref();
				return basicGetXmiidref();
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
			case XmiPackage.ATTRIBUTE__EXTENDED_PROPERTIES:
				setExtendedProperties((extendedProperties)newValue);
				return;
			case XmiPackage.ATTRIBUTE__TAGGED:
				setTagged((String)newValue);
				return;
			case XmiPackage.ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case XmiPackage.ATTRIBUTE__XMIIDREF:
				setXmiidref((EObject)newValue);
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
			case XmiPackage.ATTRIBUTE__EXTENDED_PROPERTIES:
				setExtendedProperties((extendedProperties)null);
				return;
			case XmiPackage.ATTRIBUTE__TAGGED:
				setTagged(TAGGED_EDEFAULT);
				return;
			case XmiPackage.ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case XmiPackage.ATTRIBUTE__XMIIDREF:
				setXmiidref((EObject)null);
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
			case XmiPackage.ATTRIBUTE__EXTENDED_PROPERTIES:
				return extendedProperties != null;
			case XmiPackage.ATTRIBUTE__TAGGED:
				return TAGGED_EDEFAULT == null ? tagged != null : !TAGGED_EDEFAULT.equals(tagged);
			case XmiPackage.ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case XmiPackage.ATTRIBUTE__XMIIDREF:
				return xmiidref != null;
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
		result.append(" (tagged: ");
		result.append(tagged);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //attributeImpl

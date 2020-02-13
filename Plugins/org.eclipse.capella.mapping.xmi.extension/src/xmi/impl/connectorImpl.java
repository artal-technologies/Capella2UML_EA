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
import xmi.connector;
import xmi.properties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link xmi.impl.connectorImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link xmi.impl.connectorImpl#getXmiidref <em>Xmiidref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class connectorImpl extends MinimalEObjectImpl.Container implements connector {
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
	protected connectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmiPackage.Literals.CONNECTOR;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmiPackage.CONNECTOR__PROPERTIES, oldProperties, newProperties);
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
				msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmiPackage.CONNECTOR__PROPERTIES, null, msgs);
			if (newProperties != null)
				msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmiPackage.CONNECTOR__PROPERTIES, null, msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.CONNECTOR__PROPERTIES, newProperties, newProperties));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmiPackage.CONNECTOR__XMIIDREF, oldXmiidref, xmiidref));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.CONNECTOR__XMIIDREF, oldXmiidref, xmiidref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmiPackage.CONNECTOR__PROPERTIES:
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
			case XmiPackage.CONNECTOR__PROPERTIES:
				return getProperties();
			case XmiPackage.CONNECTOR__XMIIDREF:
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
			case XmiPackage.CONNECTOR__PROPERTIES:
				setProperties((properties)newValue);
				return;
			case XmiPackage.CONNECTOR__XMIIDREF:
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
			case XmiPackage.CONNECTOR__PROPERTIES:
				setProperties((properties)null);
				return;
			case XmiPackage.CONNECTOR__XMIIDREF:
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
			case XmiPackage.CONNECTOR__PROPERTIES:
				return properties != null;
			case XmiPackage.CONNECTOR__XMIIDREF:
				return xmiidref != null;
		}
		return super.eIsSet(featureID);
	}

} //connectorImpl

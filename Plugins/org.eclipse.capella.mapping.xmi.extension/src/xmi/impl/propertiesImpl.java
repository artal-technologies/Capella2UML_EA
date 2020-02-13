/**
 */
package xmi.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import xmi.XmiPackage;
import xmi.properties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link xmi.impl.propertiesImpl#isIsSpecification <em>Is Specification</em>}</li>
 *   <li>{@link xmi.impl.propertiesImpl#getSType <em>SType</em>}</li>
 *   <li>{@link xmi.impl.propertiesImpl#getNType <em>NType</em>}</li>
 *   <li>{@link xmi.impl.propertiesImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link xmi.impl.propertiesImpl#isIsRoot <em>Is Root</em>}</li>
 *   <li>{@link xmi.impl.propertiesImpl#isIsLeaf <em>Is Leaf</em>}</li>
 *   <li>{@link xmi.impl.propertiesImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link xmi.impl.propertiesImpl#getEa_type <em>Ea type</em>}</li>
 *   <li>{@link xmi.impl.propertiesImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class propertiesImpl extends MinimalEObjectImpl.Container implements properties {
	/**
	 * The default value of the '{@link #isIsSpecification() <em>Is Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSpecification()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SPECIFICATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSpecification() <em>Is Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSpecification()
	 * @generated
	 * @ordered
	 */
	protected boolean isSpecification = IS_SPECIFICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSType() <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSType()
	 * @generated
	 * @ordered
	 */
	protected static final String STYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSType() <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSType()
	 * @generated
	 * @ordered
	 */
	protected String sType = STYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNType() <em>NType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNType()
	 * @generated
	 * @ordered
	 */
	protected static final int NTYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNType() <em>NType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNType()
	 * @generated
	 * @ordered
	 */
	protected int nType = NTYPE_EDEFAULT;

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
	 * The default value of the '{@link #isIsRoot() <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRoot()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ROOT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsRoot() <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsRoot()
	 * @generated
	 * @ordered
	 */
	protected boolean isRoot = IS_ROOT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsLeaf() <em>Is Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLeaf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_LEAF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsLeaf() <em>Is Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsLeaf()
	 * @generated
	 * @ordered
	 */
	protected boolean isLeaf = IS_LEAF_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getEa_type() <em>Ea type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEa_type()
	 * @generated
	 * @ordered
	 */
	protected static final String EA_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEa_type() <em>Ea type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEa_type()
	 * @generated
	 * @ordered
	 */
	protected String ea_type = EA_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final String DIRECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected String direction = DIRECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected propertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmiPackage.Literals.PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSpecification() {
		return isSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSpecification(boolean newIsSpecification) {
		boolean oldIsSpecification = isSpecification;
		isSpecification = newIsSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.PROPERTIES__IS_SPECIFICATION, oldIsSpecification, isSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSType() {
		return sType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSType(String newSType) {
		String oldSType = sType;
		sType = newSType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.PROPERTIES__STYPE, oldSType, sType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNType() {
		return nType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNType(int newNType) {
		int oldNType = nType;
		nType = newNType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.PROPERTIES__NTYPE, oldNType, nType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.PROPERTIES__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsRoot() {
		return isRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsRoot(boolean newIsRoot) {
		boolean oldIsRoot = isRoot;
		isRoot = newIsRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.PROPERTIES__IS_ROOT, oldIsRoot, isRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsLeaf() {
		return isLeaf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLeaf(boolean newIsLeaf) {
		boolean oldIsLeaf = isLeaf;
		isLeaf = newIsLeaf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.PROPERTIES__IS_LEAF, oldIsLeaf, isLeaf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.PROPERTIES__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEa_type() {
		return ea_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEa_type(String newEa_type) {
		String oldEa_type = ea_type;
		ea_type = newEa_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.PROPERTIES__EA_TYPE, oldEa_type, ea_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(String newDirection) {
		String oldDirection = direction;
		direction = newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmiPackage.PROPERTIES__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmiPackage.PROPERTIES__IS_SPECIFICATION:
				return isIsSpecification();
			case XmiPackage.PROPERTIES__STYPE:
				return getSType();
			case XmiPackage.PROPERTIES__NTYPE:
				return getNType();
			case XmiPackage.PROPERTIES__SCOPE:
				return getScope();
			case XmiPackage.PROPERTIES__IS_ROOT:
				return isIsRoot();
			case XmiPackage.PROPERTIES__IS_LEAF:
				return isIsLeaf();
			case XmiPackage.PROPERTIES__IS_ABSTRACT:
				return isIsAbstract();
			case XmiPackage.PROPERTIES__EA_TYPE:
				return getEa_type();
			case XmiPackage.PROPERTIES__DIRECTION:
				return getDirection();
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
			case XmiPackage.PROPERTIES__IS_SPECIFICATION:
				setIsSpecification((Boolean)newValue);
				return;
			case XmiPackage.PROPERTIES__STYPE:
				setSType((String)newValue);
				return;
			case XmiPackage.PROPERTIES__NTYPE:
				setNType((Integer)newValue);
				return;
			case XmiPackage.PROPERTIES__SCOPE:
				setScope((String)newValue);
				return;
			case XmiPackage.PROPERTIES__IS_ROOT:
				setIsRoot((Boolean)newValue);
				return;
			case XmiPackage.PROPERTIES__IS_LEAF:
				setIsLeaf((Boolean)newValue);
				return;
			case XmiPackage.PROPERTIES__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case XmiPackage.PROPERTIES__EA_TYPE:
				setEa_type((String)newValue);
				return;
			case XmiPackage.PROPERTIES__DIRECTION:
				setDirection((String)newValue);
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
			case XmiPackage.PROPERTIES__IS_SPECIFICATION:
				setIsSpecification(IS_SPECIFICATION_EDEFAULT);
				return;
			case XmiPackage.PROPERTIES__STYPE:
				setSType(STYPE_EDEFAULT);
				return;
			case XmiPackage.PROPERTIES__NTYPE:
				setNType(NTYPE_EDEFAULT);
				return;
			case XmiPackage.PROPERTIES__SCOPE:
				setScope(SCOPE_EDEFAULT);
				return;
			case XmiPackage.PROPERTIES__IS_ROOT:
				setIsRoot(IS_ROOT_EDEFAULT);
				return;
			case XmiPackage.PROPERTIES__IS_LEAF:
				setIsLeaf(IS_LEAF_EDEFAULT);
				return;
			case XmiPackage.PROPERTIES__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case XmiPackage.PROPERTIES__EA_TYPE:
				setEa_type(EA_TYPE_EDEFAULT);
				return;
			case XmiPackage.PROPERTIES__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
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
			case XmiPackage.PROPERTIES__IS_SPECIFICATION:
				return isSpecification != IS_SPECIFICATION_EDEFAULT;
			case XmiPackage.PROPERTIES__STYPE:
				return STYPE_EDEFAULT == null ? sType != null : !STYPE_EDEFAULT.equals(sType);
			case XmiPackage.PROPERTIES__NTYPE:
				return nType != NTYPE_EDEFAULT;
			case XmiPackage.PROPERTIES__SCOPE:
				return SCOPE_EDEFAULT == null ? scope != null : !SCOPE_EDEFAULT.equals(scope);
			case XmiPackage.PROPERTIES__IS_ROOT:
				return isRoot != IS_ROOT_EDEFAULT;
			case XmiPackage.PROPERTIES__IS_LEAF:
				return isLeaf != IS_LEAF_EDEFAULT;
			case XmiPackage.PROPERTIES__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case XmiPackage.PROPERTIES__EA_TYPE:
				return EA_TYPE_EDEFAULT == null ? ea_type != null : !EA_TYPE_EDEFAULT.equals(ea_type);
			case XmiPackage.PROPERTIES__DIRECTION:
				return DIRECTION_EDEFAULT == null ? direction != null : !DIRECTION_EDEFAULT.equals(direction);
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
		result.append(" (isSpecification: ");
		result.append(isSpecification);
		result.append(", sType: ");
		result.append(sType);
		result.append(", nType: ");
		result.append(nType);
		result.append(", scope: ");
		result.append(scope);
		result.append(", isRoot: ");
		result.append(isRoot);
		result.append(", isLeaf: ");
		result.append(isLeaf);
		result.append(", isAbstract: ");
		result.append(isAbstract);
		result.append(", ea_type: ");
		result.append(ea_type);
		result.append(", direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //propertiesImpl

/**
 */
package com.specmate.model.base.impl;

import com.specmate.model.base.BasePackage;
import com.specmate.model.base.Folder;
import com.specmate.model.base.IContentElement;
import com.specmate.model.base.IDescribed;
import com.specmate.model.base.INamed;
import com.specmate.model.base.IRecycled;
import com.specmate.model.base.ITracingElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.specmate.model.base.impl.FolderImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.specmate.model.base.impl.FolderImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.specmate.model.base.impl.FolderImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.specmate.model.base.impl.FolderImpl#isRecycled <em>Recycled</em>}</li>
 *   <li>{@link com.specmate.model.base.impl.FolderImpl#isHasRecycledChildren <em>Has Recycled Children</em>}</li>
 *   <li>{@link com.specmate.model.base.impl.FolderImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link com.specmate.model.base.impl.FolderImpl#getTracesTo <em>Traces To</em>}</li>
 *   <li>{@link com.specmate.model.base.impl.FolderImpl#getTracesFrom <em>Traces From</em>}</li>
 *   <li>{@link com.specmate.model.base.impl.FolderImpl#isLibrary <em>Library</em>}</li>
 * </ul>
 *
 * @generated
 */
 /* Use of Lazy final(non-constant final variable created with a type-specific default value) * 
 *source : https://cr.openjdk.java.net/~jrose/draft/lazy-final.html#:~:text=The%20uninitialized%20default%20value%20(null,initialized%20shortly%20it%20is%20created.&text=In%20addition%2C%20the%20language%20does,final%20to%20be%20initialized%20twice. 
 */


// SOURCE_EDEFAULT is a compile time constant hence requires nullability check to verify change.

public class FolderImpl extends CDOObjectImpl implements Folder {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isRecycled() <em>Recycled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRecycled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RECYCLED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isHasRecycledChildren() <em>Has Recycled Children</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasRecycledChildren()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_RECYCLED_CHILDREN_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isLibrary() <em>Library</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLibrary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LIBRARY_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return (String)eDynamicGet(BasePackage.FOLDER__ID, BasePackage.Literals.IID__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		eDynamicSet(BasePackage.FOLDER__ID, BasePackage.Literals.IID__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return (String)eDynamicGet(BasePackage.FOLDER__NAME, BasePackage.Literals.INAMED__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		eDynamicSet(BasePackage.FOLDER__NAME, BasePackage.Literals.INAMED__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return (String)eDynamicGet(BasePackage.FOLDER__DESCRIPTION, BasePackage.Literals.IDESCRIBED__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		eDynamicSet(BasePackage.FOLDER__DESCRIPTION, BasePackage.Literals.IDESCRIBED__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRecycled() {
		return (Boolean)eDynamicGet(BasePackage.FOLDER__RECYCLED, BasePackage.Literals.IRECYCLED__RECYCLED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRecycled(boolean newRecycled) {
		eDynamicSet(BasePackage.FOLDER__RECYCLED, BasePackage.Literals.IRECYCLED__RECYCLED, newRecycled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasRecycledChildren() {
		return (Boolean)eDynamicGet(BasePackage.FOLDER__HAS_RECYCLED_CHILDREN, BasePackage.Literals.IRECYCLED__HAS_RECYCLED_CHILDREN, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasRecycledChildren(boolean newHasRecycledChildren) {
		eDynamicSet(BasePackage.FOLDER__HAS_RECYCLED_CHILDREN, BasePackage.Literals.IRECYCLED__HAS_RECYCLED_CHILDREN, newHasRecycledChildren);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IContentElement> getContents() {
		return (EList<IContentElement>)eDynamicGet(BasePackage.FOLDER__CONTENTS, BasePackage.Literals.ICONTAINER__CONTENTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ITracingElement> getTracesTo() {
		return (EList<ITracingElement>)eDynamicGet(BasePackage.FOLDER__TRACES_TO, BasePackage.Literals.ITRACING_ELEMENT__TRACES_TO, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ITracingElement> getTracesFrom() {
		return (EList<ITracingElement>)eDynamicGet(BasePackage.FOLDER__TRACES_FROM, BasePackage.Literals.ITRACING_ELEMENT__TRACES_FROM, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLibrary() {
		return (Boolean)eDynamicGet(BasePackage.FOLDER__LIBRARY, BasePackage.Literals.FOLDER__LIBRARY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLibrary(boolean newLibrary) {
		eDynamicSet(BasePackage.FOLDER__LIBRARY, BasePackage.Literals.FOLDER__LIBRARY, newLibrary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		if (featureID == BasePackage.FOLDER__TRACES_TO){
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getTracesTo()).basicAdd(otherEnd, msgs);
		}
		else if (featureID == BasePackage.FOLDER__TRACES_FROM){
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getTracesFrom()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.FOLDER__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
			case BasePackage.FOLDER__TRACES_TO:
				return ((InternalEList<?>)getTracesTo()).basicRemove(otherEnd, msgs);
			case BasePackage.FOLDER__TRACES_FROM:
				return ((InternalEList<?>)getTracesFrom()).basicRemove(otherEnd, msgs);
			default:
				break;	
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
			case BasePackage.FOLDER__ID:
				return getId();
			case BasePackage.FOLDER__NAME:
				return getName();
			case BasePackage.FOLDER__DESCRIPTION:
				return getDescription();
			case BasePackage.FOLDER__RECYCLED:
				return isRecycled();
			case BasePackage.FOLDER__HAS_RECYCLED_CHILDREN:
				return isHasRecycledChildren();
			case BasePackage.FOLDER__CONTENTS:
				return getContents();
			case BasePackage.FOLDER__TRACES_TO:
				return getTracesTo();
			case BasePackage.FOLDER__TRACES_FROM:
				return getTracesFrom();
			case BasePackage.FOLDER__LIBRARY:
				return isLibrary();
			default:
				break;		
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BasePackage.FOLDER__ID:
				setId((String)newValue);
				return;
			case BasePackage.FOLDER__NAME:
				setName((String)newValue);
				return;
			case BasePackage.FOLDER__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case BasePackage.FOLDER__RECYCLED:
				setRecycled((Boolean)newValue);
				return;
			case BasePackage.FOLDER__HAS_RECYCLED_CHILDREN:
				setHasRecycledChildren((Boolean)newValue);
				return;
			case BasePackage.FOLDER__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends IContentElement>)newValue);
				return;
			case BasePackage.FOLDER__TRACES_TO:
				getTracesTo().clear();
				getTracesTo().addAll((Collection<? extends ITracingElement>)newValue);
				return;
			case BasePackage.FOLDER__TRACES_FROM:
				getTracesFrom().clear();
				getTracesFrom().addAll((Collection<? extends ITracingElement>)newValue);
				return;
			case BasePackage.FOLDER__LIBRARY:
				setLibrary((Boolean)newValue);
				return;
			default:
				break;		
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
			case BasePackage.FOLDER__ID:
				setId(ID_EDEFAULT);
				return;
			case BasePackage.FOLDER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case BasePackage.FOLDER__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case BasePackage.FOLDER__RECYCLED:
				setRecycled(RECYCLED_EDEFAULT);
				return;
			case BasePackage.FOLDER__HAS_RECYCLED_CHILDREN:
				setHasRecycledChildren(HAS_RECYCLED_CHILDREN_EDEFAULT);
				return;
			case BasePackage.FOLDER__CONTENTS:
				getContents().clear();
				return;
			case BasePackage.FOLDER__TRACES_TO:
				getTracesTo().clear();
				return;
			case BasePackage.FOLDER__TRACES_FROM:
				getTracesFrom().clear();
				return;
			case BasePackage.FOLDER__LIBRARY:
				setLibrary(LIBRARY_EDEFAULT);
				return;
			default:
				break;		
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
			case BasePackage.FOLDER__ID:
			// ID_EDEFAULT is a compile time constant hence requires nullability check to verify change.
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case BasePackage.FOLDER__NAME:
			// NAME_EDEFAULT is a compile time constant hence requires nullability check to verify change.
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case BasePackage.FOLDER__DESCRIPTION:
			// DESCRIPTION_EDEFAULT is a compile time constant hence requires nullability check to verify change.
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case BasePackage.FOLDER__RECYCLED:
				return isRecycled() != RECYCLED_EDEFAULT;
			case BasePackage.FOLDER__HAS_RECYCLED_CHILDREN:
				return isHasRecycledChildren() != HAS_RECYCLED_CHILDREN_EDEFAULT;
			case BasePackage.FOLDER__CONTENTS:
				return !getContents().isEmpty();
			case BasePackage.FOLDER__TRACES_TO:
				return !getTracesTo().isEmpty();
			case BasePackage.FOLDER__TRACES_FROM:
				return !getTracesFrom().isEmpty();
			case BasePackage.FOLDER__LIBRARY:
				return isLibrary() != LIBRARY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == INamed.class) {
			
			if (derivedFeatureID == BasePackage.FOLDER__NAME){
				 return BasePackage.INAMED__NAME;
			}
			else{
				return -1;
			}
		}
		if (baseClass == IDescribed.class) {
		
			if (derivedFeatureID == BasePackage.FOLDER__DESCRIPTION){
				 return BasePackage.IDESCRIBED__DESCRIPTION;
			}
			else{
				return -1;
			}
		}
		if (baseClass == IRecycled.class) {
			switch (derivedFeatureID) {
				case BasePackage.FOLDER__RECYCLED: return BasePackage.IRECYCLED__RECYCLED;
				case BasePackage.FOLDER__HAS_RECYCLED_CHILDREN: return BasePackage.IRECYCLED__HAS_RECYCLED_CHILDREN;
				default: return -1;
			}
		}
		if (baseClass == ITracingElement.class) {
			switch (derivedFeatureID) {
				case BasePackage.FOLDER__TRACES_TO: return BasePackage.ITRACING_ELEMENT__TRACES_TO;
				case BasePackage.FOLDER__TRACES_FROM: return BasePackage.ITRACING_ELEMENT__TRACES_FROM;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == INamed.class) {
			switch (baseFeatureID) {
				case BasePackage.INAMED__NAME: return BasePackage.FOLDER__NAME;
				default: return -1;
			}
		}
		if (baseClass == IDescribed.class) {
			switch (baseFeatureID) {
				case BasePackage.IDESCRIBED__DESCRIPTION: return BasePackage.FOLDER__DESCRIPTION;
				default: return -1;
			}
		}
		if (baseClass == IRecycled.class) {
			switch (baseFeatureID) {
				case BasePackage.IRECYCLED__RECYCLED: return BasePackage.FOLDER__RECYCLED;
				case BasePackage.IRECYCLED__HAS_RECYCLED_CHILDREN: return BasePackage.FOLDER__HAS_RECYCLED_CHILDREN;
				default: return -1;
			}
		}
		if (baseClass == ITracingElement.class) {
			switch (baseFeatureID) {
				case BasePackage.ITRACING_ELEMENT__TRACES_TO: return BasePackage.FOLDER__TRACES_TO;
				case BasePackage.ITRACING_ELEMENT__TRACES_FROM: return BasePackage.FOLDER__TRACES_FROM;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //FolderImpl

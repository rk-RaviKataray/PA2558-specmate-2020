/**
 */
package com.specmate.model.requirements;

import com.specmate.model.base.ISpecmateModelObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CEG Conection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.specmate.model.requirements.CEGConection#getSource <em>Source</em>}</li>
 *   <li>{@link com.specmate.model.requirements.CEGConection#getTarget <em>Target</em>}</li>
 *   <li>{@link com.specmate.model.requirements.CEGConection#isNegate <em>Negate</em>}</li>
 * </ul>
 *
 * @see com.specmate.model.requirements.RequirementsPackage#getCEGConection()
 * @model
 * @generated
 */
public interface CEGConection extends ISpecmateModelObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.specmate.model.requirements.CEGNode#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(CEGNode)
	 * @see com.specmate.model.requirements.RequirementsPackage#getCEGConection_Source()
	 * @see com.specmate.model.requirements.CEGNode#getOutgoingConnections
	 * @model opposite="outgoingConnections"
	 * @generated
	 */
	CEGNode getSource();

	/**
	 * Sets the value of the '{@link com.specmate.model.requirements.CEGConection#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(CEGNode value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.specmate.model.requirements.CEGNode#getIncomingConnection <em>Incoming Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(CEGNode)
	 * @see com.specmate.model.requirements.RequirementsPackage#getCEGConection_Target()
	 * @see com.specmate.model.requirements.CEGNode#getIncomingConnection
	 * @model opposite="incomingConnection"
	 * @generated
	 */
	CEGNode getTarget();

	/**
	 * Sets the value of the '{@link com.specmate.model.requirements.CEGConection#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(CEGNode value);

	/**
	 * Returns the value of the '<em><b>Negate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Negate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Negate</em>' attribute.
	 * @see #setNegate(boolean)
	 * @see com.specmate.model.requirements.RequirementsPackage#getCEGConection_Negate()
	 * @model
	 * @generated
	 */
	boolean isNegate();

	/**
	 * Sets the value of the '{@link com.specmate.model.requirements.CEGConection#isNegate <em>Negate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negate</em>' attribute.
	 * @see #isNegate()
	 * @generated
	 */
	void setNegate(boolean value);

} // CEGConection

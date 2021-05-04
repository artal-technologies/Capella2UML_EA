/*******************************************************************************
* Copyright (c) 2021 THALES GLOBAL SERVICES.
* All right reserved. This program and the accompanying materials are made 
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
*     Artal Technologies - initial API and implementation
*******************************************************************************/
package org.capella.bridge.core.uml;

import java.util.ArrayList;
import java.util.List;

import org.capella.bridge.core.CapellaBridgeAlgo;
import org.capella.bridge.core.mix.AbstractMappingAlgoMix;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Artal
 *
 */
abstract public class UMLBridgeAlgo<SD> extends CapellaBridgeAlgo<SD> {

	List<EObject> _stereoApplication = new ArrayList<>();

	List<EObject> _profileApplication = new ArrayList<>();

	public UMLBridgeAlgo() {
		super();
	}

	public UMLBridgeAlgo(AbstractMappingAlgoMix mix) {
		super(mix);
	}

	public List<EObject> getStereoApplications() {
		return _stereoApplication;
	}

	public List<EObject> getProfileApplication() {
		return _profileApplication;
	}

}

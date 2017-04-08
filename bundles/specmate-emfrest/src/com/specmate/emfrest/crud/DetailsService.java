package com.specmate.emfrest.crud;

import org.eclipse.emf.ecore.EObject;
import org.osgi.service.component.annotations.Component;

import com.specmate.common.AssertUtil;
import com.specmate.common.SpecmateException;
import com.specmate.emfrest.api.IRestService;
import com.specmate.emfrest.api.RestServiceBase;
import com.specmate.model.support.util.SpecmateEcoreUtil;

@Component(immediate = true, service = IRestService.class)
public class DetailsService extends RestServiceBase {

	@Override
	public String getServiceName() {
		return "details";
	}

	@Override
	public boolean canGet() {
		return true;
	}

	@Override
	public Object get(Object target) throws SpecmateException {
		return target;
	}

	@Override
	public boolean canPut() {
		return true;
	}

	@Override
	public Object put(Object target, EObject object) {
		AssertUtil.assertInstanceOf(target, EObject.class);
		EObject theTarget = (EObject) target;
		SpecmateEcoreUtil.copyAttributeValues(object, theTarget);
		SpecmateEcoreUtil.copyReferences(object, theTarget);
		return target;
	}

}

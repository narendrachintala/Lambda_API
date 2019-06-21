package com.rccl.model.validator;

import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.helper.RCCLException;

public class RequestDataValidator {
	
	public static RequestDataValidator _instance = null;

	ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();

	public static RequestDataValidator getInstance() {
		if (_instance == null) {
			_instance = new RequestDataValidator();
		}
		return _instance;
	}

	public void validateGetRequest(ParameterFiltersData requestData) throws RCCLException {
		if (requestData == null) {
			throw new RCCLException(rBundleUtility.getErrorJson(), null);
		}
		if (CustomFunctions.isNullOrEmpty(requestData.getMetaproduct())) {
			throw new RCCLException(rBundleUtility.getErrorMetaProduct(), null);
		}
	}

	public void validatePutRequest(PriceRange requestData) {
	}

}

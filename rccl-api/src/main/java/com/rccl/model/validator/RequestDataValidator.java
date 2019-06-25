package com.rccl.model.validator;

import com.rccl.model.ErrorMessage;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;
import com.rccl.utils.helper.RCCLException;

public class RequestDataValidator {

	public static RequestDataValidator _instance = null;

	ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();
	ResponseUtil respUtil = ResponseUtil.getInstance();

	ErrorMessage REQUEST_WAS_NULL_ERROR = new ErrorMessage("Request was null", RCCLConstants.SC_BAD_REQUEST);
	ErrorMessage METAPRODUCT_WAS_NOT_SET = new ErrorMessage("metaproduct was not set", RCCLConstants.SC_NOT_FOUND);

	public static RequestDataValidator getInstance() {
		if (_instance == null) {
			_instance = new RequestDataValidator();
		}
		return _instance;
	}

	public GatewayResponse<? extends Object> validateGetRequest(ParameterFiltersData requestData) throws RCCLException {
		if (requestData == null) {
			// throw new RCCLException(rBundleUtility.getValue(RCCLConstants.ERROR_JSON),
			// null);
			return new GatewayResponse<ErrorMessage>(REQUEST_WAS_NULL_ERROR, respUtil.getHeaders(),
					RCCLConstants.SC_BAD_REQUEST);
		}
		if (CustomFunctions.isNullOrEmpty(requestData.getMetaproduct())) {
			return new GatewayResponse<ErrorMessage>(METAPRODUCT_WAS_NOT_SET, respUtil.getHeaders(),
					RCCLConstants.SC_NOT_FOUND);
		}
		return null;
	}

	public void validatePutRequest(PriceRange requestData) {
	}

}

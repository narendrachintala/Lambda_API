package com.rccl.model.validator;

import com.rccl.model.ErrorMessage;
import com.rccl.model.FiltersData;
import com.rccl.model.GatewayResponse;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class RequestDataValidator.
 */
public class FilterDataValidator {

	// creating instance of class
	public static FilterDataValidator _instance = null;

	// Read error messages from property file
	ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();
	ResponseUtil respUtil = ResponseUtil.getInstance();

	// Set custom error message and status code
	ErrorMessage REQUEST_WAS_NULL_ERROR = new ErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_JSON),
			RCCLConstants.SC_BAD_REQUEST);
	ErrorMessage TABLE_WAS_NOT_SET = new ErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_TABLE_NAME),
			RCCLConstants.SC_NOT_FOUND);

	public static FilterDataValidator getInstance() {
		if (_instance == null) {
			_instance = new FilterDataValidator();
		}
		return _instance;
	}

	/**
	 * Validate Input-request.
	 * @param requestData the request data
	 * @return the gateway response<? extends object>
	 * @throws RCCLException the RCCL exception
	 */
	public GatewayResponse<? extends Object> validateGetRequest(FiltersData requestData) throws RCCLException {
		try {
			if (requestData == null) {
				return new GatewayResponse<ErrorMessage>(REQUEST_WAS_NULL_ERROR, respUtil.getHeaders(),
						RCCLConstants.SC_BAD_REQUEST);
			}
			if (CustomFunctions.isNullOrEmpty(requestData.getTable_name())) {
				return new GatewayResponse<ErrorMessage>(TABLE_WAS_NOT_SET, respUtil.getHeaders(),
						RCCLConstants.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new RCCLException("Error occured in validating request body", e);
		}
		return null;
	}
}

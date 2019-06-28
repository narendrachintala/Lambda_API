package com.rccl.model.validator;

import com.rccl.model.ErrorMessage;
import com.rccl.model.GatewayResponse;
import com.rccl.model.RollingWindow;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class RollingWindowDataValidator.
 */
public class RollingWindowDataValidator {
	
	// creating instance of class
	public static RollingWindowDataValidator _instance = null;

	// Read error messages from property file
	ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();
	ResponseUtil respUtil = ResponseUtil.getInstance();
	
	/**
	 * Gets the single instance of RollingWindowDataValidator.
	 * @return single instance of RollingWindowDataValidator
	 */
	public static RollingWindowDataValidator getInstance() {
		if (_instance == null) {
			_instance = new RollingWindowDataValidator();
		}
		return _instance;
	}
	
	// setting custom error messages
	ErrorMessage REQUEST_WAS_NULL_ERROR = new ErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_JSON),
			RCCLConstants.SC_BAD_REQUEST);
	ErrorMessage FILTERS_DATA_NOT_SET = new ErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_FILTERS_DATA),
			RCCLConstants.SC_BAD_REQUEST);
	ErrorMessage METAPRODUCT_WAS_NOT_SET = new ErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_METAPRODUCT),
			RCCLConstants.SC_NOT_FOUND);
	ErrorMessage UPDATE_COL_WAS_NOT_SET = new ErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_FIELDS),
			RCCLConstants.SC_NOT_FOUND);
	
	/**
	 * Validate put request.
	 * @param request the request
	 * @return the gateway response<? extends object>
	 */
	public GatewayResponse<? extends Object> validatePutRequest(RollingWindow request) {
		try {
			if (request == null) {
				return new GatewayResponse<ErrorMessage>(REQUEST_WAS_NULL_ERROR, respUtil.getHeaders(),
						RCCLConstants.SC_BAD_REQUEST);
			}
			if (request.getFiltersData() == null) {
				return new GatewayResponse<ErrorMessage>(FILTERS_DATA_NOT_SET, respUtil.getHeaders(),
						RCCLConstants.SC_BAD_REQUEST);
			}
			if (CustomFunctions.isNullOrEmpty(request.getFiltersData().getMetaproduct())) {
				return new GatewayResponse<ErrorMessage>(METAPRODUCT_WAS_NOT_SET, respUtil.getHeaders(),
						RCCLConstants.SC_NOT_FOUND);
			}
			if (request.getFut_demand_window() == null && request.getFut_forecast() == null
					&& request.getPrev_demand_window() == null && request.getPrev_forecast() == null
					&& request.getPrice_window() == null && request.getWts() == null) {
				return new GatewayResponse<ErrorMessage>(UPDATE_COL_WAS_NOT_SET, respUtil.getHeaders(),
						RCCLConstants.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new RCCLException("Error occured in validating request body", e);
		}
		return null;
	}
}

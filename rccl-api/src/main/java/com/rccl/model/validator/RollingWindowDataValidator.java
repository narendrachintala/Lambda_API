package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.GatewayResponse;
import com.rccl.model.RollingWindow;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class RollingWindowDataValidator.
 */
public class RollingWindowDataValidator {
	
	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(RollingWindowDataValidator.class);
	
	/** The instance. */
	// creating instance of class
	public static RollingWindowDataValidator _instance = null;

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
	
	/**
	 * Validate put request.
	 * @param request the request
	 * @return the gateway response<? extends object>
	 */
	public GatewayResponse<? extends Object> validatePutRequest(RollingWindow request) {
		try {
			if (request == null) {
				return ResponseUtil.error_json();
			}
			if (request.getFiltersData() == null) {
				return ResponseUtil.error_filters_data();
			}
			if (CustomFunctions.isNullOrEmpty(request.getFiltersData().getMetaproduct())) {
				return ResponseUtil.error_metaproduct();
			}
			if (request.getFut_demand_window() == null && request.getFut_forecast() == null
					&& request.getPrev_demand_window() == null && request.getPrev_forecast() == null
					&& request.getPrice_window() == null && request.getWts() == null) {
				return ResponseUtil.error_update_fields();
			}
		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST);
		}
		return null;
	}
}

package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class RequestDataValidator.
 */
public class RequestDataValidator {

	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(RequestDataValidator.class);

	// creating instance of class
	public static RequestDataValidator _instance = null;

	/**
	 * Gets the single instance of RequestDataValidator.
	 * @return single instance of RequestDataValidator
	 */
	public static RequestDataValidator getInstance() {
		if (_instance == null) {
			_instance = new RequestDataValidator();
		}
		return _instance;
	}

	/**
	 * Validate Input-request.
	 * @param requestData the request data
	 * @return the gateway response
	 * @throws RCCLException the RCCL exception
	 */
	public GatewayResponse validateGetRequest(ParameterFiltersData requestData) throws RCCLException {
		try {
			if (requestData == null) {
				return ResponseUtil.error_json();
			}
			if (CustomFunctions.isNullOrEmpty(requestData.getMetaproduct())) {
				return ResponseUtil.error_metaproduct();
			}
		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST,RCCLConstants.REQUEST_ID);
		}
		return null;
	}
}

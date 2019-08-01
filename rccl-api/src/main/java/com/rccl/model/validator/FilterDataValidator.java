package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.FiltersData;
import com.rccl.model.GatewayResponse;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class RequestDataValidator.
 */
public class FilterDataValidator {

	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(FilterDataValidator.class);
	
	/** The instance. */
	public static FilterDataValidator _instance = null;
	
	/**
	 * Gets the single instance of FilterDataValidator.
	 *
	 * @return single instance of FilterDataValidator
	 */
	public static FilterDataValidator getInstance() {
		if (_instance == null) {
			_instance = new FilterDataValidator();
		}
		return _instance;
	}

	/**
	 * Validate get request.
	 *
	 * @param requestData the request data
	 * @param filter the filter
	 * @return the gateway response
	 * @throws RCCLException the RCCL exception
	 */
	public GatewayResponse validateGetRequest(FiltersData requestData, String filter) throws RCCLException {
		try {
			if (requestData == null) {
				return ResponseUtil.error_json();
			}
			if (CustomFunctions.isNullOrEmpty(requestData.getTable_name())) {
				return ResponseUtil.error_table_name();
			}
			if (filter.equalsIgnoreCase(RCCLConstants.METAPRODUCT_F)) {
				logger.info("fetching metaproducts data");
			} else {
				if (CustomFunctions.isNullOrEmpty(requestData.getMetaproduct())) {
					return ResponseUtil.error_metaproduct();
				}
			}
		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST,RCCLConstants.REQUEST_ID);
		}
		return null;
	}
}

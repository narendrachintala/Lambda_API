package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.GatewayResponse;
import com.rccl.model.PriceRange;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class RollingWindowDataValidator.
 */
/**
 * @author narendra.chintala
 *
 */
public class PriceRangeDataValidator {
	
	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(PriceRangeDataValidator.class);

	/** The instance. */
	public static PriceRangeDataValidator _instance = null;

	/**
	 * Gets the single instance of PriceRangeDataValidator.
	 *
	 * @return single instance of PriceRangeDataValidator
	 */
	public static PriceRangeDataValidator getInstance() {
		if (_instance == null) {
			_instance = new PriceRangeDataValidator();
		}
		return _instance;
	}

	/**
	 * Validate put request.
	 * 
	 * @param request the request
	 * @return the gateway response<? extends object>
	 */
	public GatewayResponse<? extends Object> validatePutRequest(PriceRange request) {
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
			if (request.getL1_range_max() == null && request.getL1_range_min() == null
					&& request.getL2_range_max() == null && request.getL2_range_min() == null) {
				return ResponseUtil.error_update_fields();
			}
		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST);
		}
		return null;
	}
}

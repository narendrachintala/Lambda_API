package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.CurrentPricePara;
import com.rccl.model.GatewayResponse;
import com.rccl.repo.AccessControlRepo;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class CurrentPriceDataValidator.
 */
/**
 * @author chandrabhan.birla
 *
 */
public class CurrentPriceDataValidator {

	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(CurrentPriceDataValidator.class);

	/** The instance. */
	public static CurrentPriceDataValidator _instance = null;

	/**
	 * Gets the single instance of CurrentPriceDataValidator.
	 *
	 * @return single instance of CurrentPriceDataValidator
	 */
	public static CurrentPriceDataValidator getInstance() {
		if (_instance == null) {
			_instance = new CurrentPriceDataValidator();
		}
		return _instance;
	}

	/**
	 * Validate put request.
	 * @param request the request
	 * @param jobName the job name
	 * @return the gateway response<? extends object>
	 */
	public GatewayResponse<? extends Object> validatePutRequest(CurrentPricePara request, String jobName) {
		AccessControlRepo accessControlRepo = new AccessControlRepo();
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
			if (request.getL1_range_max() == null && request.getL1_range_min() == null) {
				return ResponseUtil.error_update_fields();
			}
			String lockStatus = accessControlRepo.getLockStatus(jobName);
			if (lockStatus.equalsIgnoreCase(RCCLConstants.LOCKED_CTRL_TBL_STS_FLAG)) {
				return ResponseUtil.error_locked();
			} else {
				System.out.println("lock is disabled");
			}
		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST);
		}
		return null;
	}
}

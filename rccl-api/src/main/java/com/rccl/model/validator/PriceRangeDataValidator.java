package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.GatewayResponse;
import com.rccl.model.PriceRange;
import com.rccl.repo.AccessControlRepo;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

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
	 * @param jobName the job name
	 * @return the gateway response
	 */
	public GatewayResponse validatePutRequest(PriceRange request, String jobName) {
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
			if (!CustomFunctions.validateSailDate(request.getFiltersData().getSail_date())) {
				return ResponseUtil.error_date_format();
			}
			if (request.getL1_range_max() == null && request.getL1_range_min() == null
					&& request.getL2_range_max() == null && request.getL2_range_min() == null) {
				return ResponseUtil.error_update_fields();
			} /*
				 * else {
				 * 
				 * if (request.getL1_range_max() != null || request.getL1_range_min() != null) {
				 * 
				 * double l1min =
				 * Double.parseDouble(configUtil.getValue(RCCLConstants.price_range_l1_min));
				 * double l1max =
				 * Double.parseDouble(configUtil.getValue(RCCLConstants.price_range_l1_max));
				 * 
				 * if (request.getL1_range_max() < request.getL1_range_min()) { return
				 * ResponseUtil.error_max_vs_min_range(); } else if (request.getL1_range_min() <
				 * l1min || request.getL1_range_max() > l1max) { return
				 * ResponseUtil.error_in_l1_range(l1min, l1max); } }
				 * 
				 * if (request.getL2_range_max() != null || request.getL2_range_min() != null) {
				 * 
				 * double l2min =
				 * Double.parseDouble(configUtil.getValue(RCCLConstants.price_range_l2_min));
				 * double l2max =
				 * Double.parseDouble(configUtil.getValue(RCCLConstants.price_range_l2_max));
				 * 
				 * if (request.getL2_range_max() < request.getL2_range_min()) { return
				 * ResponseUtil.error_max_vs_min_range(); } else if (request.getL2_range_min() <
				 * l2min || request.getL2_range_max() > l2max) { return
				 * ResponseUtil.error_in_l2_range(l2min, l2max); } }
				 * 
				 * }
				 */
			String lockStatus = accessControlRepo.getLockStatus(jobName);
			if (lockStatus.equalsIgnoreCase(RCCLConstants.LOCKED_CTRL_TBL_STS_FLAG)) {
				return ResponseUtil.error_locked();
			} else {
				logger.info("lock is disabled");
			}
		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST,RCCLConstants.REQUEST_ID);
		}
		return null;
	}
}

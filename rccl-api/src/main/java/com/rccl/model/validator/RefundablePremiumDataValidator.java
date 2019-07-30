package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.GatewayResponse;
import com.rccl.model.RefundablePremium;
import com.rccl.repo.AccessControlRepo;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class RefundablePremiumDataValidator.
 */
public class RefundablePremiumDataValidator {
	
	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(RefundablePremiumDataValidator.class);
	
	/** The instance. */
	// creating instance of class
	public static RefundablePremiumDataValidator _instance = null;
	
	/**
	 * Gets the single instance of RefundablePremiumDataValidator.
	 * @return single instance of RefundablePremiumDataValidator
	 */
	public static RefundablePremiumDataValidator getInstance() {
		if (_instance == null) {
			_instance = new RefundablePremiumDataValidator();
		}
		return _instance;
	}
	
	/**
	 * Validate put request.
	 * @param request the request
	 * @param jobName the job name
	 * @return the gateway response
	 */
	public GatewayResponse validatePutRequest(RefundablePremium request, String jobName) {
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
			if (request.getGap_type() == null && request.getCurrent_gap_pct() == null
					&& request.getStandard_gap_pct() == null) {
				return ResponseUtil.error_update_fields();
			}
			if (!request.getGap_type().equalsIgnoreCase(RCCLConstants.STANDARD)
					&& !request.getGap_type().equalsIgnoreCase(RCCLConstants.CURRENT)) {
				return ResponseUtil.error_gap_type();
			}
			request.setGap_type(request.getGap_type().toUpperCase());
			String lockStatus = accessControlRepo.getLockStatus(jobName);
			System.out.println("lockStatus:" + lockStatus);
			if (lockStatus.equalsIgnoreCase(RCCLConstants.LOCKED_CTRL_TBL_STS_FLAG)) {
				return ResponseUtil.error_locked();
			}
		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST,RCCLConstants.REQUEST_ID);
		}
		return null;
	}

}

package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.CurrencyGapPara;
import com.rccl.model.GatewayResponse;
import com.rccl.repo.AccessControlRepo;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * @author chandrabhan.birla The Class CurrencyGapDataValidator.
 */
public class CurrencyGapDataValidator {

	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(CurrencyGapDataValidator.class);

	/** The instance. */
	public static CurrencyGapDataValidator _instance = null;

	/**
	 * Gets the single instance of CurrencyGapDataValidator.
	 * 
	 * @return single instance of CurrencyGapDataValidator
	 */
	public static CurrencyGapDataValidator getInstance() {
		if (_instance == null) {
			_instance = new CurrencyGapDataValidator();
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
	public GatewayResponse validatePutRequest(CurrencyGapPara request, String jobName) {
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
			if (request.getCurrency1() == null && request.getCurrency2() == null && request.getCurrency3() == null
					&& request.getGap1() == null && request.getGap2() == null && request.getGap3() == null) {
				return ResponseUtil.error_update_fields();
			}
			String lockStatus = accessControlRepo.getLockStatus(jobName);
			if (lockStatus.equalsIgnoreCase(RCCLConstants.LOCKED_CTRL_TBL_STS_FLAG)) {
				return ResponseUtil.error_locked();
			} else {
				logger.debug("Table Locked status id false/disabled");
			}
		} catch (Exception e) {
			logger.error(e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return null;
	}
}

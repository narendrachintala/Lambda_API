package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.GatewayResponse;
import com.rccl.model.InversionGapPara;
import com.rccl.repo.AccessControlRepo;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

public class InversionGapsParaDataValidator {
	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(InversionGapsParaDataValidator.class);

	/** The instance. */
	public static InversionGapsParaDataValidator _instance = null;

	/**
	 * Gets the single instance of InversionGapsParaDataValidator.
	 *
	 * @return single instance of InversionGapsParaDataValidator
	 */
	public static InversionGapsParaDataValidator getInstance() {
		if (_instance == null) {
			_instance = new InversionGapsParaDataValidator();
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
	public GatewayResponse validatePutRequest(InversionGapPara request, String jobName) {
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
			if (request.getOrder_1() == null && request.getOrder_2() == null && request.getOrder_3() == null
					&& request.getOrder_4() == null && request.getOrder_5() == null && request.getOrder_6() == null
					&& request.getGap1() == null && request.getGap2() == null && request.getGap3() == null
					&& request.getGap4() == null && request.getGap5() == null && request.getGap6() == null) {
				return ResponseUtil.error_update_fields();

			}
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

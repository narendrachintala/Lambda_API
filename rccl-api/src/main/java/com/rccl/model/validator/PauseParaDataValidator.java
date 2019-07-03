package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.GatewayResponse;
import com.rccl.model.PausePara;
import com.rccl.repo.AccessControlRepo;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class PauseParaDataValidator.
 */
public class PauseParaDataValidator {

	static final Logger logger = LogManager.getLogger(PauseParaDataValidator.class);

	/**
	 * Validate input request.
	 * @param jobName the job name
	 * @param request the request
	 * @return the gateway response<? extends object>
	 */
	public GatewayResponse<? extends Object> validatePutRequest(PausePara request,String jobName) throws RCCLException {
		AccessControlRepo accessControlRepo = new AccessControlRepo();
		try {
			if (request == null) {
				return ResponseUtil.error_json();
			}
			if (request.getFiltersData() == null) {
				ResponseUtil.error_filters_data();
			}
			if (CustomFunctions.isNullOrEmpty(request.getFiltersData().getMetaproduct())) {
				ResponseUtil.error_metaproduct();
			}
			if (request.getL1_pause() == null) {
				ResponseUtil.error_update_fields();
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

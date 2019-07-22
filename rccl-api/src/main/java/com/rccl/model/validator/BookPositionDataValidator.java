package com.rccl.model.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.BookedPosition;
import com.rccl.model.GatewayResponse;
import com.rccl.repo.AccessControlRepo;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class BookPositionDataValidator.
 */
public class BookPositionDataValidator {
	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(BookPositionDataValidator.class);
	
	/** The instance. */
	// creating instance of class
	public static BookPositionDataValidator _instance = null;
	
	/**
	 * Gets the single instance of BookPositionDataValidator.
	 * @return single instance of BookPositionDataValidator
	 */
	public static BookPositionDataValidator getInstance() {
		if (_instance == null) {
			_instance = new BookPositionDataValidator();
		}
		return _instance;
	}
	
	/**
	 * Validate put request.
	 * @param request the request
	 * @param jobName the job name
	 * @return the gateway response<? extends object>
	 */
	public GatewayResponse<? extends Object> validatePutRequest(BookedPosition request, String jobName) {
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
			if (request.getBooked_position() == null) {
				return ResponseUtil.error_update_fields();
			}
			String lockStatus = accessControlRepo.getLockStatus(jobName);
			System.out.println("lockStatus:" + lockStatus);
			if (lockStatus.equalsIgnoreCase(RCCLConstants.LOCKED_CTRL_TBL_STS_FLAG)) {
				return ResponseUtil.error_locked();
			}
		} catch (Exception e) {
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST,RCCLConstants.REQUEST_ID);
		}
		return null;
	}

}

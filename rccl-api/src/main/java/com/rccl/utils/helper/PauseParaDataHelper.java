package com.rccl.utils.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.PausePara;
import com.rccl.utils.RCCLConstants;

/**
 * The Class PauseParaDataHelper.
 */
public class PauseParaDataHelper {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PauseParaDataHelper.class);

	// creating instance of class
	public static PauseParaDataHelper _instance = null;

	/**
	 * Gets the single instance of PauseParaDataHelper.
	 * 
	 * @return single instance of PauseParaDataHelper
	 */
	public static PauseParaDataHelper getInstance() {
		if (_instance == null) {
			_instance = new PauseParaDataHelper();
		}
		return _instance;
	}

	/**
	 * Generate setter condition.
	 * 
	 * @param request     the request
	 * @param queryBuffer the query buffer
	 * @return the final set condition
	 */
	public String generateSetterCondition(PausePara request, StringBuffer queryBuffer) {
		String EQUALS = RCCLConstants.EQUALS;
		String COMMA = RCCLConstants.COMMA;
		try {
			if (request.getL1_pause() != null) {
				queryBuffer.append(RCCLConstants.L1_PAUSE).append(EQUALS);
				queryBuffer.append(request.getL1_pause());
				queryBuffer.append(COMMA);
			}
			if (request.getresume_push_wts() != null) {
				queryBuffer.append(RCCLConstants.RESUME_PUSH_WTS).append(EQUALS);
				queryBuffer.append(request.getresume_push_wts());
				queryBuffer.append(COMMA);
			}
			if (request.getstop_push_wts() != null) {
				queryBuffer.append(RCCLConstants.STOP_PUSH_WTS).append(EQUALS);
				queryBuffer.append(request.getstop_push_wts());
				queryBuffer.append(COMMA);
			}
			if (request.getUser_id() != null) {
				queryBuffer.append(RCCLConstants.USER_ID).append(EQUALS);
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE).append(request.getUser_id()).append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			queryBuffer = UpdateColumnHelper.updateGenericColumns(queryBuffer);
			// removing last appended extra COMMA
			queryBuffer.replace(queryBuffer.lastIndexOf(COMMA), queryBuffer.length(), "");
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return queryBuffer.toString();
	}
}

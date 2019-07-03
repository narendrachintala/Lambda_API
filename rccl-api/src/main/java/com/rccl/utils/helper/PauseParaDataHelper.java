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

	/**
	 * Generate setter condition.
	 * 
	 * @param request     the request
	 * @param queryBuffer the query buffer
	 * @return the final set condition
	 */
	public String generateSetterCondition(PausePara request, StringBuffer queryBuffer) {
		String EQUALS = " = ";
		String COMMA = ",";
		String finalQuery = "";
		try {
			if (request.getL1_pause() != null) {
				queryBuffer.append(RCCLConstants.L1_PAUSE).append(EQUALS);
				queryBuffer.append(request.getL1_pause());
				queryBuffer.append(COMMA);
			}
			// removing last appended extra ,
			if (queryBuffer.toString().endsWith(",")) {
				finalQuery = queryBuffer.substring(0, queryBuffer.length() - 1);
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return finalQuery;
	}
}

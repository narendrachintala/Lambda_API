package com.rccl.utils.helper;

import com.rccl.model.PausePara;
import com.rccl.utils.RCCLConstants;

/**
 * The Class PauseParaDataHelper.
 */
public class PauseParaDataHelper {

	/**
	 * Generate setter condition.
	 * @param request     the request
	 * @param queryBuffer the query buffer
	 * @return the final set condition
	 */
	public String generateSetterCondition(PausePara request, StringBuffer queryBuffer) {
		String EQUALS = " = ";
		String COMMA = ",";
		String finalQuery = "";

		if (request.getL1_pause() != null) {
			queryBuffer.append(RCCLConstants.L1_PAUSE).append(EQUALS);
			queryBuffer.append(request.getL1_pause());
			queryBuffer.append(COMMA);
		}
		// removing last appended extra ,
		if (queryBuffer.toString().endsWith(",")) {
			finalQuery = queryBuffer.substring(0, queryBuffer.length() - 1);
		}
		return finalQuery;
	}
}

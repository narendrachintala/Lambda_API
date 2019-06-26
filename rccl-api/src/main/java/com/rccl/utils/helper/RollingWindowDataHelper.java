package com.rccl.utils.helper;

import com.rccl.model.RollingWindow;
import com.rccl.utils.RCCLConstants;

/**
 * The Class RollingWindowDataHelper.
 */
public class RollingWindowDataHelper {
	/**
	 * Generate filter condition.
	 * @param request the request
	 * @param queryBuffer the query buffer
	 * @return the string
	 */
	public String generateSetterCondition(RollingWindow request, StringBuffer queryBuffer) {
		String EQUALS = " = ";
		String COMMA = ",";
		String finalQuery = "";

		if (request.getFut_forecast() != null) {
			queryBuffer.append(RCCLConstants.PREV_FORECAST).append(EQUALS);
			queryBuffer.append(request.getFut_forecast());
			queryBuffer.append(COMMA);
		}
		if (request.getPrev_forecast() != null) {
			queryBuffer.append(RCCLConstants.FUT_FORECAST).append(EQUALS);
			queryBuffer.append(request.getPrev_forecast());
			queryBuffer.append(COMMA);
		}
		if (request.getPrice_window() != null) {
			queryBuffer.append(RCCLConstants.PRICE_WINDOW).append(EQUALS);
			queryBuffer.append(request.getPrice_window());
			queryBuffer.append(COMMA);
		}
		if (request.getWts() != null) {
			queryBuffer.append(RCCLConstants.WTS).append(EQUALS);
			queryBuffer.append(request.getWts());
			queryBuffer.append(COMMA);
		}
		if (request.getFut_demand_window() != null) {
			queryBuffer.append(RCCLConstants.FUT_DEMAND_WINDOW).append(EQUALS);
			queryBuffer.append(request.getPrev_forecast());
			queryBuffer.append(COMMA);
		}
		if (request.getPrev_demand_window() != null) {
			queryBuffer.append(RCCLConstants.PREV_DEMAND_WINDOW).append(EQUALS);
			queryBuffer.append(request.getPrice_window());
			queryBuffer.append(COMMA);
		}
		// removing last appended extra ,
		if (queryBuffer.toString().endsWith(",")) {
			finalQuery = queryBuffer.substring(0, queryBuffer.length() - 1);
		}
		return finalQuery;
	}
}

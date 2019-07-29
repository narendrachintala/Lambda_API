package com.rccl.utils.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.RollingWindow;
import com.rccl.utils.RCCLConstants;

/**
 * The Class RollingWindowDataHelper.
 */
public class RollingWindowDataHelper {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RollingWindowDataHelper.class);

	// creating instance of class
	public static RollingWindowDataHelper _instance = null;

	/**
	 * Gets the single instance of RollingWindowDataHelper.
	 * 
	 * @return single instance of RollingWindowDataHelper
	 */
	public static RollingWindowDataHelper getInstance() {
		if (_instance == null) {
			_instance = new RollingWindowDataHelper();
		}
		return _instance;
	}

	/**
	 * Generate filter condition.
	 * 
	 * @param request     the request
	 * @param queryBuffer the query buffer
	 * @return the final set condition
	 */
	public String generateSetterCondition(RollingWindow request, StringBuffer queryBuffer) {
		String EQUALS = RCCLConstants.EQUALS;
		String COMMA = RCCLConstants.COMMA;
		try {
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

			queryBuffer = UpdateColumnHelper.updateGenericColumns(queryBuffer);
			// removing last appended extra ,
			queryBuffer.replace(queryBuffer.lastIndexOf(COMMA), queryBuffer.length(), "");
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return queryBuffer.toString();
	}
}

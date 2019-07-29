package com.rccl.utils.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.CurrentPricePara;
import com.rccl.utils.RCCLConstants;

/**
 * The Class CurrentPriceDataHelper.
 * author: chandrabhan.birla
 */
public class CurrentPriceDataHelper {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(CurrentPriceDataHelper.class);

	/** The instance. */
	// creating instance of class
	public static CurrentPriceDataHelper _instance = null;

	/**
	 * Gets the single instance of CurrentPriceDataHelper.
	 * 
	 * @return single instance of CurrentPriceDataHelper
	 */
	public static CurrentPriceDataHelper getInstance() {
		if (_instance == null) {
			_instance = new CurrentPriceDataHelper();
		}
		return _instance;
	}

	/**
	 * Generate setter condition.
	 *
	 * @param currentPriceReq the current_price_para req
	 * @param queryBuffer     the query buffer
	 * @return the string
	 */
	public String generateSetterCondition(CurrentPricePara currentPriceReq, StringBuffer queryBuffer) {

		String EQUALS = RCCLConstants.EQUALS;
		String COMMA = RCCLConstants.COMMA;
		String SINGLE_QUOTE = RCCLConstants.SINGLE_QUOTE;

		try {
			if (currentPriceReq.getL1_range_max() != null) {

				queryBuffer.append(RCCLConstants.L1_RANGE_MAX).append(EQUALS);
				queryBuffer.append(SINGLE_QUOTE).append(currentPriceReq.getL1_range_max()).append(SINGLE_QUOTE);
				queryBuffer.append(COMMA);

			}
			if (currentPriceReq.getL1_range_min() != null) {

				queryBuffer.append(RCCLConstants.L1_RANGE_MIN).append(EQUALS);
				queryBuffer.append(SINGLE_QUOTE).append(currentPriceReq.getL1_range_min()).append(SINGLE_QUOTE);
				queryBuffer.append(COMMA);

			}
			if (currentPriceReq.getPrice_window() != null) {

				queryBuffer.append(RCCLConstants.PRICE_WINDOW).append(EQUALS);
				queryBuffer.append(SINGLE_QUOTE).append(currentPriceReq.getPrice_window()).append(SINGLE_QUOTE);
				queryBuffer.append(COMMA);

			}
			queryBuffer = UpdateColumnHelper.updateGenericColumns(queryBuffer);

			// removing last appended extra COMMA
			if (queryBuffer.toString().endsWith(",")) {
				queryBuffer.replace(queryBuffer.lastIndexOf(COMMA), queryBuffer.length(), "");
			}

			logger.debug("queryBuffer.toString(): " + queryBuffer.toString());
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return queryBuffer.toString();

	}

}

package com.rccl.utils.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.CurrentPricePara;
import com.rccl.utils.RCCLConstants;

/**
 * The Class CurrentPriceDataHelper. author: chandrabhan.birla
 */
public class CurrentPriceDataHelper {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(CurrentPriceDataHelper.class);

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
		List<String> insertDateColumns = new ArrayList<String>();

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
			if (queryBuffer.toString().endsWith(",")) {
				insertDateColumns.add(RCCLConstants.L1_INSERT_DATE);
				new UpdateColumnHelper();
				queryBuffer = UpdateColumnHelper.setTimeAsColumnValue(queryBuffer, insertDateColumns);
			}

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

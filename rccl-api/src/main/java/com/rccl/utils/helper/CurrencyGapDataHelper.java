package com.rccl.utils.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.CurrencyGapPara;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;

/**
 * The Class CurrencyGapDataHelper.
 * 
 * @author chandrabhan.birla
 */
public class CurrencyGapDataHelper {

	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(CurrentPriceDataHelper.class);
	
	/** The instance. */
	// creating instance of class
	public static CurrencyGapDataHelper _instance = null;

	/**
	 * Gets the single instance of CurrencyGapDataHelper.
	 * 
	 * @return single instance of CurrencyGapDataHelper
	 */
	public static CurrencyGapDataHelper getInstance() {
		if (_instance == null) {
			_instance = new CurrencyGapDataHelper();
		}
		return _instance;
	}


	/**
	 * Generate setter condition.
	 *
	 * @param currencyGapReq the currency gap req
	 * @param queryBuffer    the query buffer
	 * @return the string
	 */
	public String generateSetterCondition(CurrencyGapPara currencyGapReq, StringBuffer queryBuffer) {

		String EQUALS = RCCLConstants.EQUALS;
		String COMMA = RCCLConstants.COMMA;
		String SINGLE_QUOTE = RCCLConstants.SINGLE_QUOTE;

		try {
			if (currencyGapReq.getCurrency1() != null) {

				queryBuffer.append(RCCLConstants.CURRENCY1).append(EQUALS);
				queryBuffer.append(SINGLE_QUOTE).append(currencyGapReq.getCurrency1()).append(SINGLE_QUOTE);
				queryBuffer.append(COMMA);

			}
			if (currencyGapReq.getCurrency2() != null) {

				queryBuffer.append(RCCLConstants.CURRENCY2).append(EQUALS);
				queryBuffer.append(SINGLE_QUOTE).append(currencyGapReq.getCurrency2()).append(SINGLE_QUOTE);
				queryBuffer.append(COMMA);

			}
			if (currencyGapReq.getCurrency3() != null) {

				queryBuffer.append(RCCLConstants.CURRENCY3).append(EQUALS);
				queryBuffer.append(SINGLE_QUOTE).append(currencyGapReq.getCurrency3()).append(SINGLE_QUOTE);
				queryBuffer.append(COMMA);

			}
			if (currencyGapReq.getGap1() != null) {

				queryBuffer.append(RCCLConstants.GAP1).append(EQUALS);
				queryBuffer.append(currencyGapReq.getGap1());
				queryBuffer.append(COMMA);
			}
			if (currencyGapReq.getGap2() != null) {

				queryBuffer.append(RCCLConstants.GAP2).append(EQUALS);
				queryBuffer.append(currencyGapReq.getGap2());
				queryBuffer.append(COMMA);
			}
			if (currencyGapReq.getGap3() != null) {

				queryBuffer.append(RCCLConstants.GAP3).append(EQUALS);
				queryBuffer.append(currencyGapReq.getGap3());
				queryBuffer.append(COMMA);
			}
			if (currencyGapReq.getUser_id() != null) {
				queryBuffer.append(RCCLConstants.USER_ID).append(EQUALS);
				queryBuffer.append(currencyGapReq.getUser_id());
				queryBuffer.append(COMMA);
			}

			queryBuffer.append(RCCLConstants.INSERT_DATE).append(RCCLConstants.EQUALS);
			queryBuffer.append(RCCLConstants.SINGLE_QUOTE).append(CustomFunctions.getCurrentDate())
					.append(RCCLConstants.SINGLE_QUOTE).append(RCCLConstants.COMMA);

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

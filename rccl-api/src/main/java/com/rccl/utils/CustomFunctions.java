package com.rccl.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Class CustomFunctions.
 */
public class CustomFunctions {

	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(CustomFunctions.class);

	/**
	 * Checks if is null or empty.
	 *
	 * @param val the val
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(String val) {

		return (val == null || val.isEmpty());
	}

	public static String getNamedQuery(String constant) {
		String named_query = new StringBuffer(RCCLConstants.NAMED_QRY_PREFIX).append(constant).toString();
		return named_query;
	}

	/**
	 * Gets the current date.
	 *
	 * @return the current date
	 */
	public static String getCurrentDate() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		String formattedTimeStamp = new SimpleDateFormat(RCCLConstants.INSERT_DATE_FORMAT).format(timestamp);

		return formattedTimeStamp;
	}

	/** unused code**/
	public static boolean isOracleDateErrCodeExists(String errorMsg) {
		List<String> errorCodes = ConfigUtil.getOracleDateErrorCodes();
		for (String str : errorCodes) {
			if (errorMsg.contains(str))
				return true;
		}
		return false;
	}

	/**
	 * Format insert date.
	 *
	 * @param datetime the datetime
	 * @return the string
	 * @throws Exception
	 */
	public static String formatInsertDate(String insertDate) throws Exception {
		String formattedInsertDate = null;
		try {
			formattedInsertDate = new SimpleDateFormat(RCCLConstants.INSERT_DATE_FORMAT)
					.format(new SimpleDateFormat(RCCLConstants.DATE_FORMAT).parse(insertDate));

		} catch (Exception e) {
			logger.error("Error occured prcossing the L1_INSERT_DATE : " + e.getMessage());
			throw e;
		}
		return formattedInsertDate;
	}

	/**
	 * Format sail date.
	 *
	 * @param datetime the datetime
	 * @return the string
	 * @throws Exception
	 */
	public static String formatSailDate(String sailDate) throws Exception {
		String formattedSailDate = null;
		try {
			formattedSailDate = new SimpleDateFormat(RCCLConstants.SAIL_DATE_FORMAT)
					.format(new SimpleDateFormat(RCCLConstants.DATE_FORMAT).parse(sailDate));

		} catch (Exception e) {
			logger.error("Error occured prcossing the SAIL_DATE : " + e.getMessage());
			throw e;
		}
		return formattedSailDate;
	}

	/**
	 * Validate sail date.
	 *
	 * @param sailDate the sail date
	 * @return true, if successful
	 */
	public static boolean validateSailDate(String sailDate) {
		try {
			new SimpleDateFormat(RCCLConstants.SAIL_DATE_FORMAT).parse(sailDate);

		} catch (ParseException e) {
			logger.error("Error occured prcossing the SAIL_DATE : " + e.getMessage());
			return false;
		} catch (Exception e) {
			logger.error("Error occured prcossing the SAIL_DATE : " + e.getMessage());
			return false;
		}
		return true;
	}
}

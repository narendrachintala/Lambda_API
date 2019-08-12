package com.rccl.utils;

import java.sql.Timestamp;
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

		String formattedTimeStamp = new SimpleDateFormat("dd-MMM-yy hh:mm:ss.sss a").format(timestamp);

		return formattedTimeStamp;
	}

	public static boolean isOracleDateErrCodeExists(String errorMsg) {
		List<String> errorCodes =  ConfigUtil.getOracleDateErrorCodes();
		System.out.println(errorCodes.size());
		System.out.println("First: "+errorCodes.get(0));

		for (String str : errorCodes) {
			System.out.println(str+" -- "+errorMsg);
			System.out.println(errorMsg.contains(str));
			if (errorMsg.contains(str))
				return true;
		}
		return false;
	}

}

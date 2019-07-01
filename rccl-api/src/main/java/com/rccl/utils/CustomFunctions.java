package com.rccl.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * The Class CustomFunctions.
 */
public class CustomFunctions {

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

		String formattedTimeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:sss a").format(timestamp);

		return formattedTimeStamp;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println(getCurrentDate());
	}

}

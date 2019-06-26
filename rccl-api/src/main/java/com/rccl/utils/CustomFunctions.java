package com.rccl.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CustomFunctions {

	public static boolean isNullOrEmpty(String val) {

		return (val == null || val.isEmpty());
	}

	public static String getCurrentDate() {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		String formattedTimeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:sss a").format(timestamp);

		return formattedTimeStamp;
	}

	public static void main(String[] args) {
		System.out.println(getCurrentDate());
	}

}

package com.rccl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class ResponseUtil.
 */
public class ResponseUtil {

	/** The instance. */
	private static ResponseUtil _instance;

	/**
	 * Gets the single instance of ResponseUtil.
	 * 
	 * @return single instance of ResponseUtil
	 */
	public static ResponseUtil getInstance() {
		if (_instance == null) {
			_instance = new ResponseUtil();
		}
		return _instance;
	}

	/**
	 * Gets the headers.
	 * 
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		return headers;
	}
}

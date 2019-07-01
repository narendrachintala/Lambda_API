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
	 * @return single instance of ResponseUtil
	 */
	public static ResponseUtil getInstance() {
		if (_instance == null) {
			_instance = new ResponseUtil();
		}
		return _instance;
	}

	/*
	 * public Map<String, String> getSuccessMessage(String req_id, String
	 * status_message) { Map<String, String> map = new HashMap<String, String>();
	 * map.put(RCCLConstants.REQUEST_ID, req_id); map.put(RCCLConstants.STATUS,
	 * status_message); // map.put(RCCLConstants.STATUS_CODE,
	 * RCCLConstants.SUCCESS); // map.put(RCCLConstants.STATUS_MESSAGE,
	 * status_message); return map; }
	 */

	/**
	 * Gets the headers.
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		//headers.put("X-Custom-Header", "application/json");
		return headers;
	}
}

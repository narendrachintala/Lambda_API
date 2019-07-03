package com.rccl.utils;

import java.util.HashMap;
import java.util.Map;

import com.rccl.model.ErrorMessage;
import com.rccl.model.GatewayResponse;

/**
 * @author narendra.chintala
 *
 */

/**
 * The Class ResponseUtil.
 */
public class ResponseUtil extends CustomErrors {

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
	public static Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		return headers;
	}

	/**
	 * Gets the error message.
	 *
	 * @param e          the e
	 * @param statusCode the status code
	 * @return the error message
	 */
	public static GatewayResponse<ErrorMessage> getErrorMessage(Exception e, Integer statusCode) {
		String errorMsg = e.getCause().getLocalizedMessage();
		if (errorMsg != null) {
			errorMsg.substring(errorMsg.indexOf(RCCLConstants.NAMED_QRY_PREFIX));
		}
		ErrorMessage errorMessage = new ErrorMessage(errorMsg, statusCode);
		GatewayResponse<ErrorMessage> error = new GatewayResponse<ErrorMessage>(errorMessage, getHeaders(),
				RCCLConstants.SC_BAD_REQUEST);

		return error;
	}

	/**
	 * Gets the cust error message.
	 *
	 * @param errorMsg   the error msg
	 * @param statusCode the status code
	 * @return the cust error message
	 */
	public static GatewayResponse<ErrorMessage> getCustErrorMessage(String errorMsg, Integer statusCode) {
		ErrorMessage errorMessage = new ErrorMessage(errorMsg, statusCode);
		GatewayResponse<ErrorMessage> error = new GatewayResponse<ErrorMessage>(errorMessage, getHeaders(),
				statusCode);

		return error;
	}

}

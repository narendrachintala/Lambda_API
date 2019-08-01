package com.rccl.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(ResponseUtil.class);

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
		// headers.put("X-Powered-By", "AWS Lambda & serverless");
		return headers;
	}

	/**
	 * Gets the error message.
	 *
	 * @param e the e
	 * @param statusCode the status code
	 * @param requestID the request ID
	 * @return the error message
	 */
	public static GatewayResponse getErrorMessage(Exception e, Integer statusCode, String requestID) {
		String errorMsg = e.getCause().getLocalizedMessage();
		if (errorMsg != null) {
			errorMsg.substring(errorMsg.indexOf(RCCLConstants.NAMED_QRY_PREFIX));
		} else {
			errorMsg = e.getMessage();
		}
		GatewayResponse error = null;
		try {
			ErrorMessage errorMessage = new ErrorMessage(errorMsg, statusCode);
			error = new GatewayResponse(errorMessage, getHeaders(), RCCLConstants.SC_BAD_REQUEST,
					requestID);
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;

		}
		return error;
	}

	/**
	 * Gets the cust error message.
	 *
	 * @param errorMsg   the error msg
	 * @param statusCode the status code
	 * @return the cust error message
	 */
	public static GatewayResponse getCustErrorMessage(String errorMsg, Integer statusCode,String requestID) {
		GatewayResponse message = null;
		try {
			ErrorMessage errorMessage = new ErrorMessage(errorMsg, statusCode);
			message = new GatewayResponse(errorMessage, getHeaders(), statusCode,requestID);
		} catch (Exception e) {
			logger.error(e);
			throw e;

		}
		return message;
	}
	
}

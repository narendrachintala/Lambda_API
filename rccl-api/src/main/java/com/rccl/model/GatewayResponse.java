package com.rccl.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.gson.Gson;

/**
 * POJO containing response object for API Gateway.
 * 
 * @param <T> the generic type
 */
@JsonAutoDetect
public class GatewayResponse {

	/** The request ID. */
	/* private final String requestID; */

	/** The body. */
	private final String body;

	/** The headers. */
	private final Map<String, String> headers;

	/** The status code. */
	private final int statusCode;

	/**
	 * Instantiates a new gateway response.
	 *
	 * @param body       the body
	 * @param headers    the headers
	 * @param statusCode the status code
	 * @param requestID  the request ID
	 */
	public GatewayResponse(final Object body, final Map<String, String> headers, final int statusCode,final String requestID) {
		this.statusCode = statusCode;
		this.body = new Gson().toJson(body);
		this.headers = Collections.unmodifiableMap(new HashMap<>(headers));
		// this.requestID = requestID;
	}

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Gets the headers.
	 * 
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * Gets the status code.
	 * 
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Gets the request ID.
	 *
	 * @return the request ID
	 */
	/*
	 * public String getRequestID() { return requestID; }
	 */

}

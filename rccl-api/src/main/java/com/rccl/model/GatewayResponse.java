package com.rccl.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * POJO containing response object for API Gateway.
 * @param <T> the generic type
 */
@JsonAutoDetect
public class GatewayResponse<T> {

	/** The body. */
	private final T body;
	
	/** The headers. */
	private final Map<String, String> headers;
	
	/** The status code. */
	private final int statusCode;

	/**
	 * Creates a GatewayResponse object.
	 * @param body       body of the response
	 * @param headers    headers of the response
	 * @param statusCode status code of the response
	 */
	public GatewayResponse(final T body, final Map<String, String> headers, final int statusCode) {
		this.statusCode = statusCode;
		this.body = body;
		this.headers = Collections.unmodifiableMap(new HashMap<>(headers));
	}

	/**
	 * Gets the body.
	 * @return the body
	 */
	public T getBody() {
		return body;
	}

	/**
	 * Gets the headers.
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		return headers;
	}

	/**
	 * Gets the status code.
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}
}

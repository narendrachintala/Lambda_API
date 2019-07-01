package com.rccl.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * The Class ErrorMessage.
 */
@JsonAutoDetect
public class ErrorMessage {

	/**
	 * Instantiates a new error message.
	 * @param message the message
	 * @param statusCode the status code
	 */
	public ErrorMessage(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	/** The message. */
	private String message;
	
	/** The status code. */
	private int statusCode;

	/**
	 * Gets the message.
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the status code.
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

}

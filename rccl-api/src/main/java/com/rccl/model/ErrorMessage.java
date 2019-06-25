package com.rccl.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ErrorMessage {

	public ErrorMessage(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	private String message;
	private int statusCode;

	public String getMessage() {
		return message;
	}

	public int getStatusCode() {
		return statusCode;
	}

}

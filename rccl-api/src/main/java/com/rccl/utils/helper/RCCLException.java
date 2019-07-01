package com.rccl.utils.helper;


/**
 * The Class RCCLException.
 *
 * @author narendra.chintala
 */
public class RCCLException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Instantiates a new RCCL exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public RCCLException(String message, Throwable cause) {
		super(message, cause);
	}

}
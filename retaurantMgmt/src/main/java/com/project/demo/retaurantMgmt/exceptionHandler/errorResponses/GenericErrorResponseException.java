package com.project.demo.retaurantMgmt.exceptionHandler.errorResponses;

public class GenericErrorResponseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GenericErrorResponseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenericErrorResponseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public GenericErrorResponseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GenericErrorResponseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GenericErrorResponseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

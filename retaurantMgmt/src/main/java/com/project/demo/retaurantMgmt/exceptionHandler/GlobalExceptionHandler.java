package com.project.demo.retaurantMgmt.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.demo.retaurantMgmt.exceptionHandler.errorResponses.GenericErrorResponse;
import com.project.demo.retaurantMgmt.exceptionHandler.errorResponses.GenericErrorResponseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<GenericErrorResponse> handleException(GenericErrorResponseException ex) {

		GenericErrorResponse rsp = new GenericErrorResponse();
		rsp.setMessage(ex.getMessage());
		rsp.setStatus(HttpStatus.BAD_REQUEST.value());
		rsp.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<GenericErrorResponse>(rsp, HttpStatus.BAD_REQUEST);
	}

}

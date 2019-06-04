package com.invictus.crm.util;

import java.util.Date;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler({ Exception.class })
	public final ResponseEntity<ExceptionResponse> handleException(Exception ex, WebRequest request) {

		ex.printStackTrace();
		if (ex instanceof NotAuthorizedException) {
			return handleException(HttpStatus.UNAUTHORIZED, ex.getMessage(), request);
		} else if (ex instanceof ForbiddenException) {
			return handleException(HttpStatus.FORBIDDEN, ex.getMessage(), request);
		} else if (ex instanceof BadRequestException) {
			return handleException(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
		} else if (ex instanceof NotFoundException) {
			return handleException(HttpStatus.NOT_FOUND, ex.getMessage(), request);
		} else if (ex instanceof HttpMessageNotReadableException) {
			return handleException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), request);
		} else {
			LOG.error("P3|Error Code 500|" + ex.getMessage());
			return handleException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while processing your request",
					request);
		}
	}

	protected ResponseEntity<ExceptionResponse> handleException(HttpStatus status, String errorMessage,
			WebRequest request) {
		ExceptionResponse exception = new ExceptionResponse();
		exception.setHttpCodeMessage(status.getReasonPhrase());
		exception.setMessage(errorMessage);
		exception.setDetails(request.getDescription(false));
		exception.setTimestamp(new Date().toString());
		exception.setTraceId(request.getHeader("TraceId"));		
		return new ResponseEntity<>(exception, status);
	}
}

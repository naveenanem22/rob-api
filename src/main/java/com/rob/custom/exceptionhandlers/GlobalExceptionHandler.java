package com.rob.custom.exceptionhandlers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rob.custom.exceptions.RecordNotFoundException;
import com.rob.util.response.ApiError;
import com.rob.util.response.ApiErrorWithDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String DESERIALIZATION_FAILURE = "Invalid input data format.";
	private static final String VALIDATION_FAILURE = "Validation failed.";
	private static final String RECORD_NOT_FOUND = "Record not found.";
	private static final String FIELD_MISSING = "Field is missing.";

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ApiError apiError = new ApiError(LocalDateTime.now(), RECORD_NOT_FOUND, details);
		return new ResponseEntity<Object>(apiError, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiErrorWithDetails apiError = new ApiErrorWithDetails();
		List<ApiErrorWithDetails.Detail> details = new ArrayList<ApiErrorWithDetails.Detail>();

		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			ApiErrorWithDetails.Detail detail = apiError.new Detail(
					error.getRejectedValue() == null ? FIELD_MISSING : error.getRejectedValue().toString(),
					error.getDefaultMessage(), error.getField());
			details.add(detail);
		}
		apiError.setDetails(details);
		apiError.setMessage(VALIDATION_FAILURE);
		apiError.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ApiError error = new ApiError(LocalDateTime.now(), DESERIALIZATION_FAILURE, details);
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);

	}

}

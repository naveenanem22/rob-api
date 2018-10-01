package com.rob.custom.exceptionhandlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.rob.custom.exceptions.CandidateNotFoundException;
import com.rob.util.response.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CandidateNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(CandidateNotFoundException ex,
			WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ApiError apiError = new ApiError("Record not found.", details);
		return new ResponseEntity<Object>(apiError, HttpStatus.NOT_FOUND);

	}

}

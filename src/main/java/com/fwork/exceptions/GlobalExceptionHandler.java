package com.fwork.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fwork.model.ApiErrors;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		headers.add("desc","Http Method not supported");
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,status);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		headers.add("desc","Media is not supported");
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,status);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		headers.add("desc","Missing Path Variable");
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,status);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		headers.add("desc","Invalid data type is passed");
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,status);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}
	@ExceptionHandler(FreelancerNotFoundException.class)
    public ResponseEntity<Object> handleFreelancerNotFound(FreelancerNotFoundException ex){
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Freelancer Not Found");
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }
	@ExceptionHandler(WorkNotFoundException.class)
    public ResponseEntity<Object> handleWorkNotFound(WorkNotFoundException ex){
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Work Not Found");
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
		HttpHeaders headers=new HttpHeaders();
		headers.add("desc","Something went wrong");
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message,HttpStatus.EXPECTATION_FAILED);
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).headers(headers).body(errors);
    }



}

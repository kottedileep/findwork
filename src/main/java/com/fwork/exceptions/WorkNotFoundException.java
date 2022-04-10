package com.fwork.exceptions;

public class WorkNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public WorkNotFoundException() {
		super();
	
	}

	public WorkNotFoundException(String message) {
		super(message);
	}
	

}

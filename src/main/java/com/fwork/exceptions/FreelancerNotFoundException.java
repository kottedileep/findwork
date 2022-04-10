package com.fwork.exceptions;

public class FreelancerNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public FreelancerNotFoundException() {
		super();
	}
	public FreelancerNotFoundException(String message) {
		super(message);
	}
}

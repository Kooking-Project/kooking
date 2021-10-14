package com.kooking.exception;


public class KookingException extends Exception {
	private static final long serialVersionUID = 5227561488556420975L;
	
	public KookingException() {}
	public KookingException(String message) {
		super(message);
	}

}

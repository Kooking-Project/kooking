package com.kooking.exception;

/**
 * �α����Ҷ� ������ �����ϸ� �߻��ϴ� ��������
 * */
public class AuthenticationException extends Exception {
	private static final long serialVersionUID = 5227561488556420975L;
	
	public AuthenticationException() {}
	public AuthenticationException(String message) {
		super(message);
	}

}

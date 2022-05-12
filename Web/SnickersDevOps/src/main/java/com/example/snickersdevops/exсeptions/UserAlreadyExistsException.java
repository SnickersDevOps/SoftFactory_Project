package com.example.snickersdevops.exсeptions;

public class UserAlreadyExistsException extends QuizException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException() {
		super();
	}

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}

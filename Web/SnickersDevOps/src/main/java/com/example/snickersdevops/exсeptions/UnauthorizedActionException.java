package com.example.snickersdevops.exсeptions;

public class UnauthorizedActionException extends QuizException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedActionException() {
		super();
	}

	public UnauthorizedActionException(String message) {
		super(message);
	}
}

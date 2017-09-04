package edu.msg.ro.business.common.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -5628141671921410481L;

	private String message;

	public BusinessException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

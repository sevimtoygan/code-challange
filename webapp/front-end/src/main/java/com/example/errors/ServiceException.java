package com.example.errors;

public class ServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 7122996357854258064L;
	private static final int STATUS = 500;
	private final int status;
	public ServiceException(String message) {
		this(message, null, STATUS);
	}
	
	public ServiceException(String message, Throwable cause) {
		this(message, cause, STATUS);
	}
	
	protected ServiceException(String message, Throwable cause, int status) {
		super(message, cause);
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
}

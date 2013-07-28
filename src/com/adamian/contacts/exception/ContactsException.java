package com.adamian.contacts.exception;


/**
 * Application level exception.
 * Throw this exception whenever something bad happens in the application.
 */
public class ContactsException extends RuntimeException {

	private static final long serialVersionUID = -1651448948054192758L;

	public ContactsException(String message, Throwable cause) {
		super(message, cause);
	}

}

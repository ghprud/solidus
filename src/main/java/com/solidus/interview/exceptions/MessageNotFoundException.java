package com.solidus.interview.exceptions;

public class MessageNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8075341600618145108L;

	public MessageNotFoundException(String digest) {
		super("Could not find the message with the digest: " + digest);
	}

}

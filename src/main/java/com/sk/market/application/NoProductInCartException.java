package com.sk.market.application;

public class NoProductInCartException extends RuntimeException {
	private static final long serialVersionUID = -4282822480990164234L;
	
	public NoProductInCartException() {
		super();
	}
	
	public NoProductInCartException(String message) {
		super(message);
	}
}

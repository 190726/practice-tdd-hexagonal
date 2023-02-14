package com.sk.market.application;

public class ProdutNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ProdutNotFound(String upc) {
		super("Product not found UPC:" + upc);
	}
}

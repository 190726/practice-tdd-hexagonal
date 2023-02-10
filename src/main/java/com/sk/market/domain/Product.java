package com.sk.market.domain;

public class Product {

	private String productName;
	private int productPrice;

	public Product(String productName, int productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public String productName() {
		return this.productName;
	}

	public int productPrice() {
		return this.productPrice;
	}
}

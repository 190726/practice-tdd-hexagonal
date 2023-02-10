package com.sk.market.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cart {

	private int totalPrice = 0;
	private List<Product> products = new ArrayList<>();

	public int totalPrice() {
		return totalPrice;
	}

	public void add(Product product) {
		this.products.add(product);
		this.totalPrice += product.productPrice();
	}
	
	public Stream<Product> products(){
		return products.stream();
	}
}
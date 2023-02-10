package com.sk.market.application;

import java.math.BigDecimal;

public class CartService {
	
	private BigDecimal total = BigDecimal.ZERO;
	private ProductPricer productPricer = new ProductPricer();
	private boolean isEmpty = true;

	public BigDecimal total() {
		return total;
	}

	public void addProduct(String productName) {
		isEmpty = false;
		total = total.add(BigDecimal.valueOf(productPricer.priceFor(productName)) );
	}
	
	public void finalizeOrder() {
		total = BigDecimal.ZERO;
		isEmpty = true;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
}
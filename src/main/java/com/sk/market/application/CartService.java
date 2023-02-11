package com.sk.market.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sk.market.application.port.ProductPricer;
import com.sk.market.domain.Receipt;

public class CartService {
	
	private BigDecimal total = BigDecimal.ZERO;
	private final ProductPricer productPricer;
	private boolean isEmpty = true;
	private List<String> products = new ArrayList<>();
	
	public CartService(ProductPricer productPricer) {
		this.productPricer = productPricer;
	}

	public BigDecimal total() {
		return total;
	}

	public void addProduct(String productName) {
		isEmpty = false;
		products.add(productName);
		total = total.add(productPricer.priceFor(productName));
	}
	
	public Receipt finalizeOrder() {
		
		requireCartNotEmpty();
		
		Receipt receipt = new Receipt(total ,products);
		
		total = BigDecimal.ZERO;
		isEmpty = true;
		
		return receipt;
	}

	private void requireCartNotEmpty() {
		if(isEmpty()) throw new NoProductInCartException();
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
}
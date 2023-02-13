package com.sk.market.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sk.market.application.NoProductInCartException;

public class Cart {
	
	private BigDecimal total = BigDecimal.ZERO;
	private List<String> products = new ArrayList<>();
	
	public boolean add(Product product) {
		String upc = product.upc();
		BigDecimal price = product.price();
		
		BigDecimal actualPrice = discountedProductPrice(product);
		if(products.contains(upc)) {
			actualPrice = price.divide(BigDecimal.valueOf(2));
		}
		total = total.add(actualPrice);
		return products.add(upc);
	}

	private BigDecimal discountedProductPrice(Product product) {
		BigDecimal actualPrice = product.price();
		String upc = product.upc();
		if(upc.equals("0987")) {
			actualPrice = product.price().multiply(BigDecimal.valueOf(0.9));
		}
		return actualPrice;
	}

	public List<String> products() {
		return List.copyOf(products);
	}

	public BigDecimal total() {
		return this.total;
	}

	public boolean isEmpty() {
		return products.isEmpty();
	}

	public Receipt receipt() {
		return new Receipt(total() ,products());
	}
	
	public void requireCartNotEmpty() {
		if(isEmpty()) throw new NoProductInCartException();
	}

}
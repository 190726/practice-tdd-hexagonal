package com.sk.market.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sk.market.application.NoProductInCartException;

public class Cart {
	
	private BigDecimal total = BigDecimal.ZERO;
	private List<String> products = new ArrayList<>();
	private boolean isEmpty = true;

	public void add(String upc, BigDecimal price) {
		products.add(upc);
		total = total.add(price);
	}

	public List<String> products() {
		return List.copyOf(products);
	}

	public BigDecimal total() {
		return this.total;
	}

	public void makeEmpty() {
		total = BigDecimal.ZERO;
		isEmpty = true;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public Receipt receipt() {
		return new Receipt(total() ,products());
	}
	
	public void requireCartNotEmpty() {
		if(isEmpty()) throw new NoProductInCartException();
	}
}
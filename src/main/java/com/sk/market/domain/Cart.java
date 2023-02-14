package com.sk.market.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sk.market.application.NoProductInCartException;

public class Cart {
	
	private List<Product> products = new ArrayList<>();
	private Set<Product> eligibleProductsForHalfDiscount;
	
	public void add(Product product) {
		products.add(product);
	}

	public BigDecimal total() {
		eligibleProductsForHalfDiscount = new HashSet<>();
		return products.stream()
				.map(this::discountedIndividualProductPrice)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}
	
	public Receipt receipt() {
		return new Receipt(total(), products.stream().map(p -> p.upc()).toList());
	}

	public void requireCartNotEmpty() {
		if(isEmpty()) throw new NoProductInCartException();
	}
	
	private BigDecimal discountedIndividualProductPrice(Product product) {
		BigDecimal actualPrice = product.price();
		
		if(eligibleForHalfDiscount(product)) {
			return actualPrice.divide(BigDecimal.valueOf(2));
		}
		
		if(eligibleTenPercentDiscount(product)) {
			return actualPrice.multiply(BigDecimal.valueOf(0.9));
		}
		eligibleProductsForHalfDiscount.add(product);
		return actualPrice;
	}

	private boolean eligibleTenPercentDiscount(Product product) {
		return product.rule() == DiscountRule.TEN_PERCENT_OFF
				&&
			   onlyOneOf(product);
	}

	private boolean onlyOneOf(Product product) {
		return products.stream().filter(p -> p.equals(product)).count() == 1;
	}

	private boolean eligibleForHalfDiscount(Product product) {
		return eligibleProductsForHalfDiscount.contains(product);
	}


	private boolean isEmpty() {
		return products.isEmpty();
	}
}
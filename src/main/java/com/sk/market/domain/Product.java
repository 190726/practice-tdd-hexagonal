package com.sk.market.domain;

import java.math.BigDecimal;

public record Product(String upc, BigDecimal price, DiscountRule rule) {
	public Product(String upc, BigDecimal price) {
		this(upc, price, DiscountRule.NONE);
	}
}
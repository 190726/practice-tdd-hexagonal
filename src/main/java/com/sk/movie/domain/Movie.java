package com.sk.movie.domain;

import java.math.BigDecimal;

public class Movie {
	
	private BigDecimal price;
	
	private final DiscountPolicy discountPolicy;
	
	public Movie(BigDecimal price, DiscountPolicy discountPolicy) {
		this.price = price;
		this.discountPolicy = discountPolicy;
	}

	public BigDecimal price(Screen screen) {
		return discountPolicy.discountPrice(screen, this.price);
	}
}
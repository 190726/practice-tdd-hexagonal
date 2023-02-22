package com.sk.movie.application;

import java.math.BigDecimal;

public class Movie {
	
	private BigDecimal price;
	
	public Movie(BigDecimal price) {
		this.price = price;
	}

	private DiscountPolicy policy = new DiscountPolicy() {
		
		@Override
		public BigDecimal discountPrice(Screen screen, BigDecimal price) {
			if(screen.whenTime().getHour() < 12) return price.multiply(BigDecimal.valueOf(0.8));
			return price;
		}
	};

	public BigDecimal price(Screen screen) {
		return policy.discountPrice(screen, this.price);
	}
}
package com.sk.movie.domain.policy;

import java.math.BigDecimal;

import com.sk.movie.domain.DiscountPolicy;
import com.sk.movie.domain.Screen;

public class MorningDiscountPolicy implements DiscountPolicy {

	@Override
	public BigDecimal discountPrice(Screen screen, BigDecimal price) {
		if(screen.whenTime().getHour() < 12) return price.multiply(BigDecimal.valueOf(0.8));
		return price;
	}
}
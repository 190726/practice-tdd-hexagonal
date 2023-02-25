package com.sk.movie.domain;

import java.math.BigDecimal;

public interface DiscountPolicy {
	BigDecimal discountPrice(Screen screen, BigDecimal price);
}

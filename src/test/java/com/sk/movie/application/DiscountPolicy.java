package com.sk.movie.application;

import java.math.BigDecimal;

public interface DiscountPolicy {

	BigDecimal discount(BigDecimal price);

}

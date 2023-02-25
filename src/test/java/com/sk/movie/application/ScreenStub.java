package com.sk.movie.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sk.movie.domain.DiscountPolicy;
import com.sk.movie.domain.Movie;
import com.sk.movie.domain.Screen;
import com.sk.movie.domain.policy.MorningDiscountPolicy;

public class ScreenStub {
	
	private static final String MOVIE1_CODE = "0001";
	private static DiscountPolicy amDiscountPolicy = new MorningDiscountPolicy();
	
	public static Screen screenStub() {
		String screenId = MOVIE1_CODE;
		Movie movie = new Movie(BigDecimal.ONE, amDiscountPolicy);
		return new Screen(screenId, LocalDateTime.of(2022, 9, 10, 7, 30),movie);
	}
}
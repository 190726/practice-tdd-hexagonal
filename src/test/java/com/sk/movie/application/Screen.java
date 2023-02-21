package com.sk.movie.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Screen {

	private String screenId;
	private LocalDateTime whenTime;
	private Movie movie = new Movie();

	public Screen(String screenId) {
		this.screenId = screenId;
	}

	public Ticket reserve(int numUser, DiscountPolicy discountPolicy) {
		valided(numUser);
		return new Ticket(screenId, whenTime, discountPolicy.discount(priceBy(numUser)));
	}
	
	private BigDecimal priceBy(int numOfUser) {
		return movie.price().multiply(BigDecimal.valueOf(numOfUser));
	}

	private void valided(int numUser) {
		if(numUser < 1) throw new IllegalArgumentException("number of user must be more than zero, input value is " + numUser);
	}
}
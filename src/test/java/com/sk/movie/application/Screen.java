package com.sk.movie.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Screen {

	private String screenId;
	private LocalDateTime whenTime;
	private Movie movie;

	public Screen(String screenId) {
		this.screenId = screenId;
	}
	
	public Screen(String screenId, LocalDateTime whenTime, Movie movie) {
		this.screenId = screenId;
		this.whenTime = whenTime;
		this.movie = movie;
	}

	public Ticket reserve(int numUser) {
		valided(numUser);
		return new Ticket(screenId, whenTime, priceBy(numUser));
	}
	
	public LocalDateTime whenTime() {
		return this.whenTime;
	}
	
	private BigDecimal priceBy(int numOfUser) {
		return movie.price(this).multiply(BigDecimal.valueOf(numOfUser));
	}

	private void valided(int numUser) {
		if(numUser < 1) throw new IllegalArgumentException("number of user must be more than zero, input value is " + numUser);
	}
}
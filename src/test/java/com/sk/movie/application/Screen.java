package com.sk.movie.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Screen {

	private String screenId;
	private LocalDateTime whenTime;

	public Screen(String screenId) {
		this.screenId = screenId;
	}

	public Ticket reserve(int numUser) {
		return new Ticket(screenId, whenTime, priceBy(numUser));
	}

	private BigDecimal priceBy(int numOfUser) {
		return BigDecimal.ZERO;
	}
}
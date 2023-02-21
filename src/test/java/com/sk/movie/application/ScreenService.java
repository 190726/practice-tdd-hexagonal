package com.sk.movie.application;

import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;

public class ScreenService {
	
	private final DiscountPolicy discountPolicy;
	
	public ScreenService(DiscountPolicy discountPolicy) {
		this.discountPolicy = discountPolicy;
	}
	
	public Ticket reserve(String screenId, int numOfUser) {
		
		Screen screen = new Screen(screenId);
		
		discount(screen);
		
		return screen.reserve(numOfUser, discountPolicy);
	}

	private void discount(Screen screen) {
		
	}
}
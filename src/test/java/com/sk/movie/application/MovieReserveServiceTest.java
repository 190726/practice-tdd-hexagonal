package com.sk.movie.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class MovieReserveServiceTest {
	
	private static final String MOVIE1_CODE = "0001";
	private DiscountPolicy discountPolicy = new DiscountPolicy() {
			@Override
			public BigDecimal discount(BigDecimal price) {
				return price.divide(BigDecimal.valueOf(0.8));
			}
		};

	@Test
	void oneUserReserve() throws Exception {
		
		discountPolicy = new DiscountPolicy() {
			@Override
			public BigDecimal discount(BigDecimal price) {
				return price;
			}
		};
		
		//given
		ScreenService screenService = new ScreenService(discountPolicy);
		String screenId = MOVIE1_CODE;
		int numOfUser = 1;
		//when
		Ticket ticket = screenService.reserve(screenId , numOfUser);
		//then
		assertThat(ticket.price()).isEqualTo(BigDecimal.ONE);
	}
	
	@Test
	void twoUserReserve() throws Exception {
		//given
		ScreenService screenService = new ScreenService(discountPolicy);
		String screenId = MOVIE1_CODE;
		int numOfUser = 2;
		//when
		Ticket ticket = screenService.reserve(screenId , numOfUser);
		//then
		assertThat(ticket.price().toPlainString()).isEqualTo("2");
	}
}
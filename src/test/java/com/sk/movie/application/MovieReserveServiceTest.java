package com.sk.movie.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.sk.market.application.port.DiscountFetcher;
import com.sk.market.domain.DiscountRule;

public class MovieReserveServiceTest {
	
	private static final String MOVIE1_CODE = "0001";

	@Test
	void oneUserReserve() throws Exception {
		
		//given
		String screenId = MOVIE1_CODE;
		int numOfUser = 1;
		Movie moveiMovie = new Movie(BigDecimal.ONE);
		Screen sccreen = new Screen(screenId, LocalDateTime.of(2022, 9, 10, 7, 30),moveiMovie);
		
		//when
		ScreenService screenService = new ScreenService(sccreen);
		Ticket ticket = screenService.reserve(screenId , numOfUser);
		//then
		assertThat(ticket.price().toPlainString()).isEqualTo("0.8");
	}
	
	@Test
	void twoUserReserve() throws Exception {
		//given
		String screenId = MOVIE1_CODE;
		int numOfUser = 2;
		Movie moveiMovie = new Movie(BigDecimal.ONE);
		Screen sccreen = new Screen(screenId, LocalDateTime.of(2022, 9, 10, 7, 30),moveiMovie);
		ScreenService screenService = new ScreenService(sccreen);
		
		//when
		Ticket ticket = screenService.reserve(screenId , numOfUser);
		//then
		assertThat(ticket.price().toPlainString()).isEqualTo("1.6");
	}
}
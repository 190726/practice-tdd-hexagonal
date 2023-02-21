package com.sk.movie.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class MovieReserveServiceTest {
	
	@Test
	void oneUserReserve() throws Exception {
		//given
		ScreenService screenService = new ScreenService();
		String screenId = "0001";
		int numOfUser = 1;
		//when
		Ticket ticket = screenService.reserve(screenId , numOfUser);
		//then
		assertThat(ticket.price()).isEqualTo(BigDecimal.ZERO);
	}
}
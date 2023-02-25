package com.sk.movie.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.sk.movie.domain.DiscountPolicy;
import com.sk.movie.domain.Movie;
import com.sk.movie.domain.Screen;
import com.sk.movie.domain.Ticket;
import com.sk.movie.domain.policy.MorningDiscountPolicy;

public class ScreenUnitTest {
	
	
	@Test
	void oneUserReserve() throws Exception {
		
		//given
		int numOfUser = 1;
		Screen sccreen = ScreenStub.screenStub();
		//when
		Ticket ticket = sccreen.reserve(numOfUser);
		//then
		assertThat(ticket.price().toPlainString()).isEqualTo("0.8");
	}
	
	@Test
	void twoUserReserve() throws Exception {
		//given
		int numOfUser = 2;
		Screen sccreen = ScreenStub.screenStub();
		//when
		Ticket ticket = sccreen.reserve( numOfUser);
		//then
		assertThat(ticket.price().toPlainString()).isEqualTo("1.6");
	}
}
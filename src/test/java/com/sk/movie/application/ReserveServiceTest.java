package com.sk.movie.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sk.movie.application.model.ReserveServiceCommand;
import com.sk.movie.application.port.ScreenFetcher;
import com.sk.movie.domain.Screen;
import com.sk.movie.domain.Ticket;

public class ReserveServiceTest {
	
	private ScreenFetcher screenFetcher;
	
	@BeforeEach
	void init() {
		screenFetcher = new ScreenFetcher() {
			@Override
			public Screen screen(String screenId) {
				return ScreenStub.screenStub() ;
			}
		};
	}

	@Test
	void reserveTest() throws Exception {
		//given
		ReserveService service = new ReserveService(screenFetcher);
		
		ReserveServiceCommand serviceCommand = new ReserveServiceCommand("1111", 2);
		//when
		Ticket ticket = service.reserve(serviceCommand);
		//then
		assertThat(ticket.price().toPlainString()).isEqualTo("1.6");
	}
}
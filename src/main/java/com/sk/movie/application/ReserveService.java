package com.sk.movie.application;

import com.sk.ServiceBean;
import com.sk.movie.application.model.ReserveServiceCommand;
import com.sk.movie.application.port.ScreenFetcher;
import com.sk.movie.domain.Ticket;

@ServiceBean
public class ReserveService {

	private final ScreenFetcher screenFetcher;

	public ReserveService(ScreenFetcher screenFetcher) {
		this.screenFetcher = screenFetcher;
	}

	public Ticket reserve(ReserveServiceCommand serviceCommand) {
		return screenFetcher.screen(serviceCommand.screenId())
					 .reserve(serviceCommand.numberUsers());
	}
}
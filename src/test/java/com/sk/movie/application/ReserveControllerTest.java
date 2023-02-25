package com.sk.movie.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.sk.movie.adapter.in.web.ReserveController;
import com.sk.movie.adapter.in.web.model.ReserveRequest;
import com.sk.movie.adapter.in.web.model.ReserveResponse;
import com.sk.movie.adapter.out.fetcher.ScreenFetcherAdapter;
import com.sk.movie.application.port.ScreenFetcher;

public class ReserveControllerTest {
	
	private ReserveService reserveService;
	private ScreenFetcher screenFetcher;
	
	
	@BeforeEach
	void init() {
		screenFetcher = new ScreenFetcherAdapter();
		reserveService = new ReserveService(screenFetcher);
	}
	
	@Test
	void morningDiscountReserveController() throws Exception {
		//given
		ReserveController controller = new ReserveController(reserveService);
		String screenId = "0001";
		int numberUsers = 2;
		ReserveRequest request = new ReserveRequest(screenId, numberUsers);
		
		//when
		ResponseEntity<ReserveResponse> response = controller.reserve(request);
		//then
		assertThat(response.getBody().getTotalPrice()).isEqualTo("1.6");
	}
	
	@Test
	void morningDiscountNotReserveController() throws Exception {
		//given
		ReserveController controller = new ReserveController(reserveService);
		String screenId = "0002";
		int numberUsers = 2;
		ReserveRequest request = new ReserveRequest(screenId, numberUsers);
		//when
		ResponseEntity<ReserveResponse> response = controller.reserve(request);
		//then
		assertThat(response.getBody().getTotalPrice()).isEqualTo("2");
	}
}

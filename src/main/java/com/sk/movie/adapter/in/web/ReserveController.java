package com.sk.movie.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.movie.adapter.in.web.model.ReserveRequest;
import com.sk.movie.adapter.in.web.model.ReserveResponse;
import com.sk.movie.application.ReserveService;
import com.sk.movie.application.model.ReserveServiceCommand;
import com.sk.movie.domain.Ticket;

@RestController
@RequestMapping("/reserve")
public class ReserveController {
	
	private final ReserveService reserveService;

	public ReserveController(ReserveService reserveService) {
		this.reserveService = reserveService;
	}

	@PostMapping
	public ResponseEntity<ReserveResponse> reserve(@RequestBody ReserveRequest request) {
		Ticket ticket = reserveService.reserve(new ReserveServiceCommand(request.getScreenId(), request.getNumberUsers()));
		ReserveResponse reserveResponse = mappedBy(ticket, request.getNumberUsers());
		return ResponseEntity.ok(reserveResponse);
//		return new ResponseEntity<ReserveResponse>(reserveResponse, HttpStatus.CREATED);
	}

	private ReserveResponse mappedBy(Ticket ticket, int numberUser) {
		return new ReserveResponse(ticket.when(),numberUser, ticket.price().toPlainString());
	}
}
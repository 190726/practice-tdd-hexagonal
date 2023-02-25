package com.sk.movie.adapter.in.web.model;

import java.time.LocalDateTime;

public class ReserveResponse {
	
	private LocalDateTime whenTime;
	private int numberUsers;
	private String totalPrice;
	
	public ReserveResponse(LocalDateTime whenTime, int numberUsers, String totalPrice) {
		this.whenTime = whenTime;
		this.numberUsers = numberUsers;
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getWhenTime() {
		return whenTime;
	}

	public void setWhenTime(LocalDateTime whenTime) {
		this.whenTime = whenTime;
	}

	public int getNumberUsers() {
		return numberUsers;
	}

	public void setNumberUsers(int numberUsers) {
		this.numberUsers = numberUsers;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

}

package com.sk.movie.adapter.in.web.model;

public class ReserveRequest {

	private String screenId;
	private int numberUsers;

	public ReserveRequest(String screenId, int numberUsers) {
		this.screenId = screenId;
		this.numberUsers = numberUsers;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public int getNumberUsers() {
		return numberUsers;
	}

	public void setNumberUsers(int numberUsers) {
		this.numberUsers = numberUsers;
	}

	@Override
	public String toString() {
		return "ReserveRequest [screenId=" + screenId + ", numberUsers=" + numberUsers + "]";
	}
}
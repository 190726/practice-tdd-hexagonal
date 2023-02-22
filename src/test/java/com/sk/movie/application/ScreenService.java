package com.sk.movie.application;

public class ScreenService {
	
	private Screen screen;
	
	public ScreenService(Screen screen) {
		this.screen = screen;
	}
	
	public Ticket reserve(String screenId, int numOfUser) {
		return screen.reserve(numOfUser);
	}

}
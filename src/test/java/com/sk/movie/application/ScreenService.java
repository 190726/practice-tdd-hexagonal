package com.sk.movie.application;

public class ScreenService {


	public Ticket reserve(String screenId, int numOfUser) {
		
		Screen screen = new Screen(screenId);
		
		return screen.reserve(numOfUser);
	}
}
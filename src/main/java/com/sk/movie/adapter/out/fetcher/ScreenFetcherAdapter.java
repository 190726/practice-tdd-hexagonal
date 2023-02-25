package com.sk.movie.adapter.out.fetcher;

import com.sk.movie.application.port.ScreenFetcher;
import com.sk.movie.domain.Screen;

public class ScreenFetcherAdapter implements ScreenFetcher{

	@Override
	public Screen screen(String screenId) {
		throw new UnsupportedOperationException();
	}
}
package com.sk.movie.application.port;

import com.sk.movie.domain.Screen;

public interface ScreenFetcher {

	Screen screen(String screenId);

}

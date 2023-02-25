package com.sk.movie.adapter.out.fetcher;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sk.movie.application.port.ScreenFetcher;
import com.sk.movie.domain.Movie;
import com.sk.movie.domain.Screen;
import com.sk.movie.domain.policy.MorningDiscountPolicy;

@Component
public class ScreenFetcherAdapter implements ScreenFetcher{
	
	private static Map<String, Screen> persistence = new HashMap<>();
	
	static {
		persistence.put("0001", new Screen("0001", LocalDateTime.of(2022, 12, 11, 9, 50), new Movie(BigDecimal.ONE, new MorningDiscountPolicy())));
		persistence.put("0002", new Screen("0002", LocalDateTime.of(2022, 12, 11, 13, 50), new Movie(BigDecimal.ONE, new MorningDiscountPolicy())));
	}

	@Override
	public Screen screen(String screenId) {
		return persistence.get(screenId);
	}
}
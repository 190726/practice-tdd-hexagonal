package com.sk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sk.market.application.CartService;
import com.sk.market.application.port.DiscountFetcher;
import com.sk.market.application.port.ProductPriceFetcher;

@SpringBootApplication
public class PracticeApplication {
	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}
	
	@Bean
	public CartService cartService(ProductPriceFetcher priceFetcher, DiscountFetcher discountFetcher) {
		return new CartService(priceFetcher, discountFetcher);
	}
}
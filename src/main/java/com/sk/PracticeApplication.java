package com.sk;

import java.math.BigDecimal;
import java.security.PublicKey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.groovy.GroovyMarkupConfig;

import com.sk.market.adapter.out.fetcher.ExternalProductPriceFetcher;
import com.sk.market.application.CartService;
import com.sk.market.application.port.ProductPriceFetcher;
import com.sk.market.domain.DiscountRule;

import antlr.TokenWithIndex;

@SpringBootApplication
public class PracticeApplication {
	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}
	
	@Bean
	public CartService cartService(ProductPriceFetcher priceFetcher) {
		return new CartService(priceFetcher, upc -> DiscountRule.NONE);
	}
	
	@Bean
	public ProductPriceFetcher priceFetcher() {
		return new ExternalProductPriceFetcher();
	}
}
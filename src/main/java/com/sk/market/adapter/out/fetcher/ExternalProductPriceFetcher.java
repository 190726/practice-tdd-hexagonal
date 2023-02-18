package com.sk.market.adapter.out.fetcher;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import com.sk.market.application.port.ProductPriceFetcher;

public class ExternalProductPriceFetcher implements ProductPriceFetcher {

	private static final String EXTERNAL_SERVICE = "http://localhost:8082/price/upc/{upc}";

	@Override
	public BigDecimal priceFor(String upc) {
		RestTemplate restTemplate = new RestTemplate();
		PriceResponse priceResponse = restTemplate.getForObject(EXTERNAL_SERVICE, PriceResponse.class, upc);
		return priceResponse.price();
	}
}
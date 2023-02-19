package com.sk.market.adapter.out.fetcher;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sk.market.application.port.DiscountFetcher;
import com.sk.market.domain.DiscountRule;

@Component
public class ExternalDiscountFetcher implements DiscountFetcher {
	
	private final RestTemplate restTemplate = new RestTemplate();
	private String discountFetchUrlString = "http://localhost:8082/discount/{upc}";

	@Override
	public DiscountRule getRule(String upc) {
		
		DiscountResponse response = restTemplate.getForObject(discountFetchUrlString, DiscountResponse.class, upc);
		
		return DiscountRuleTranslator.toRule(response.ruleCode());
	}
}
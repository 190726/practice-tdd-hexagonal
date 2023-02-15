package com.sk.market.application;

import com.sk.market.domain.DiscountRule;

public interface DiscountFetcher {

	DiscountRule getRule(String upc);

}

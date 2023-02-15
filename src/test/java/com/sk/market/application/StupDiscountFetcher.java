package com.sk.market.application;

import com.sk.market.domain.DiscountRule;

public class StupDiscountFetcher implements DiscountFetcher {

	@Override
	public DiscountRule getRule(String upc) {
		if(upc.equals("0987")) return DiscountRule.TEN_PERCENT_OFF;
		return DiscountRule.NONE;
	}
}

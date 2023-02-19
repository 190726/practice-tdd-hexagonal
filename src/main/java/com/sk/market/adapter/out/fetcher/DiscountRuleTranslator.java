package com.sk.market.adapter.out.fetcher;

import com.sk.market.domain.DiscountRule;

public class DiscountRuleTranslator {

	public static DiscountRule toRule(String ruleCode) {
		return switch(ruleCode) {
			case "t" -> DiscountRule.TEN_PERCENT_OFF;
			default -> DiscountRule.NONE;
		};
	}
}
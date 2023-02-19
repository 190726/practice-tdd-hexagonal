package com.sk.market.adapter.out.fetcher;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.sk.market.application.port.DiscountFetcher;
import com.sk.market.domain.DiscountRule;

@Tag("manual")
public class ExternalDiscountFetcherTest {
	
	@Test
	void fetchReturnNoneDiscount() throws Exception {
		DiscountFetcher discountFetcher = new ExternalDiscountFetcher();
		DiscountRule rule = discountFetcher.getRule("1111");
		assertThat(rule).isEqualTo(DiscountRule.NONE);
		
	}
}
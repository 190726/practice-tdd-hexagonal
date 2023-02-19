package com.sk.market.adapter.out.fetcher;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.sk.market.adapter.out.fetcher.ExternalProductPriceFetcher;
import com.sk.market.application.port.ProductPriceFetcher;

@Tag("manual")
public class ExternalPriceFetcherTest {

	@Test
	void priceReturnTenFromExternalFetcher() throws Exception {
		ProductPriceFetcher priceFetcher = new ExternalProductPriceFetcher();
		BigDecimal price = priceFetcher.priceFor("1111");
		assertThat(price).isEqualTo(BigDecimal.TEN);
	}
}
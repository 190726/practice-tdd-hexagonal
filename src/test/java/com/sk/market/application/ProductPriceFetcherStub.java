package com.sk.market.application;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.sk.market.application.port.ProductPriceFetcher;

public class ProductPriceFetcherStub implements ProductPriceFetcher{
	
	private  final Map<String, BigDecimal> productToPriceMap = new HashMap<>();
	
	public ProductPriceFetcherStub() {
	}

	public ProductPriceFetcherStub(String upc1, BigDecimal price1, String upc2, BigDecimal price2) {
		productToPriceMap.put(upc1, price1 );
		productToPriceMap.put(upc2, price2 );
	}

	@Override
	public BigDecimal priceFor(String productName) {
		BigDecimal result = productToPriceMap.get(productName);
		if(result == null) return BigDecimal.ZERO;
		return result;
	}
}
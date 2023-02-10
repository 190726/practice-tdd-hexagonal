package com.sk.market.application;

import java.math.BigDecimal;

public interface ProductPricer {

	BigDecimal priceFor(String productName);

}

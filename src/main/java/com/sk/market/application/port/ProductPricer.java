package com.sk.market.application.port;

import java.math.BigDecimal;

public interface ProductPricer {

	BigDecimal priceFor(String productName);

}

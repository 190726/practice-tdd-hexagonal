package com.sk.market.application.port;

import java.math.BigDecimal;

public interface ProductPriceFetcher {

	BigDecimal priceFor(String productName);

}

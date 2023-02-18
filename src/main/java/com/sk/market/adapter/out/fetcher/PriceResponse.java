package com.sk.market.adapter.out.fetcher;

import java.math.BigDecimal;

public record PriceResponse(String upc, BigDecimal price) {

}

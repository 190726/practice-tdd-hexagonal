package com.sk.market.domain;

import java.math.BigDecimal;

public record Product(String upc, BigDecimal price) {
}

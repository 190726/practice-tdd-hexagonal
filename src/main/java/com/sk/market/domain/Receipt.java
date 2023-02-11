package com.sk.market.domain;

import java.math.BigDecimal;
import java.util.List;

public record Receipt(BigDecimal total, List<String> products) {
}

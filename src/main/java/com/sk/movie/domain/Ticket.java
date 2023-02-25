package com.sk.movie.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 예매번호, 예매시간, 예매가격 표시
 *
 */
public record Ticket(String screenId, LocalDateTime when, BigDecimal price) {
}
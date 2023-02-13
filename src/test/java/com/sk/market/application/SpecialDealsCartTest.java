package com.sk.market.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class SpecialDealsCartTest {
	
	private static final String TOOTH_BRUSH_UPC = "4567";
	private static final String TOOTH_PASTE_UPC = "0123";
	
	@Test
	void twoSameItemsInCartDiscountTest() throws Exception {
		CartService cartService = new CartService(new ProductPriceFetcherStub(TOOTH_PASTE_UPC, BigDecimal.ONE, TOOTH_BRUSH_UPC, BigDecimal.valueOf(3)));
		cartService.addProduct(TOOTH_PASTE_UPC);
		cartService.addProduct(TOOTH_PASTE_UPC);
		BigDecimal total = cartService.total();
		assertThat(total.toString()).isEqualTo("1.5");
	}
}

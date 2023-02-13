package com.sk.market.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class SpecialDealsCartTest {
	
	private static final String TOOTH_BRUSH_UPC = "4567";
	private static final String TOOTH_TEN_PERCENT_DISCOUNT_UPC = "0987";
	
	@Test
	void oneItemsInCartDiscountTest() throws Exception {
		CartService cartService = new CartService(new ProductPriceFetcherStub(TOOTH_TEN_PERCENT_DISCOUNT_UPC, BigDecimal.TEN, TOOTH_BRUSH_UPC, BigDecimal.valueOf(3)));
		cartService.addProduct(TOOTH_TEN_PERCENT_DISCOUNT_UPC);
		BigDecimal total = cartService.total();
		assertThat(total).isEqualTo("9.0");
	}
	
	@Test
	void specialTwoSameItemsInCartDiscountTest() throws Exception {
		CartService cartService = new CartService(new ProductPriceFetcherStub(TOOTH_TEN_PERCENT_DISCOUNT_UPC, BigDecimal.TEN, TOOTH_BRUSH_UPC, BigDecimal.valueOf(3)));
		cartService.addProduct(TOOTH_TEN_PERCENT_DISCOUNT_UPC);
		cartService.addProduct(TOOTH_TEN_PERCENT_DISCOUNT_UPC);
		BigDecimal total = cartService.total();
		assertThat(total).isEqualTo("18.0");
	}
	
	@Test
	void twoSameItemsInCartDiscountTest() throws Exception {
		CartService cartService = new CartService(new ProductPriceFetcherStub(TOOTH_TEN_PERCENT_DISCOUNT_UPC, BigDecimal.TEN, TOOTH_BRUSH_UPC, BigDecimal.valueOf(3)));
		cartService.addProduct(TOOTH_BRUSH_UPC);
		cartService.addProduct(TOOTH_BRUSH_UPC);
		BigDecimal total = cartService.total();
		assertThat(total).isEqualTo("4.5");
	}
}

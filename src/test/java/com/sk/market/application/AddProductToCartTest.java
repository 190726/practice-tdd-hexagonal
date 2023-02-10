package com.sk.market.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class AddProductToCartTest {

	private static final String TOOTH_BRUSH_UPC = "4567";
	private static final String TOOTH_PASTE_UPC = "0123";

	@Test
	void cartTotalAtZero() throws Exception {
		CartService cartService = new CartService(
				new ProductPricerStub(TOOTH_PASTE_UPC, BigDecimal.ONE, TOOTH_BRUSH_UPC, BigDecimal.valueOf(3)));
		BigDecimal total = cartService.total();
		assertThat(total.intValue()).isZero();
	}
	
	@Test
	void cartTotalOneProduct() throws Exception {
		CartService cartService = new CartService(new ProductPricerStub(TOOTH_PASTE_UPC, BigDecimal.ONE, TOOTH_BRUSH_UPC, BigDecimal.valueOf(3)));
		cartService.addProduct(TOOTH_PASTE_UPC);
		BigDecimal total = cartService.total();
		assertThat(total.toString()).isEqualTo("1");
	}
	
	@Test
	void cartTotalMultipleProduct() throws Exception {
		CartService cartService = new CartService(new ProductPricerStub(TOOTH_PASTE_UPC, BigDecimal.ONE, TOOTH_BRUSH_UPC, BigDecimal.valueOf(3)));
		cartService.addProduct(TOOTH_PASTE_UPC);
		cartService.addProduct(TOOTH_BRUSH_UPC);
		BigDecimal total = cartService.total();
		assertThat(total.toString()).isEqualTo("4");
	}
	
	@Test
	void cartWithProductPlaceOrderEmptyCart() throws Exception {
		CartService cartService = new CartService(new ProductPricerStub(TOOTH_PASTE_UPC, BigDecimal.ONE, TOOTH_BRUSH_UPC, BigDecimal.valueOf(3)));
		cartService.addProduct(TOOTH_PASTE_UPC);
		Receipt receipt = cartService.finalizeOrder();
		assertThat(receipt.total()).isEqualTo("1");
		assertThat(receipt.products()).containsExactly(TOOTH_PASTE_UPC);
	}
}
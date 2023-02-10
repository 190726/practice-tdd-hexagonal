package com.sk.market.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class AddProductToCartTest {

	@Test
	void cartTotalAtZero() throws Exception {
		CartService cartService = new CartService();
		BigDecimal total = cartService.total();
		assertThat(total.intValue()).isZero();
	}
	
	@Test
	void cartTotalOneProduct() throws Exception {
		CartService cartService = new CartService();
		cartService.addProduct("0123");
		BigDecimal total = cartService.total();
		assertThat(total.toString()).isEqualTo("1");
	}
	
	@Test
	void cartTotalMultipleProduct() throws Exception {
		CartService cartService = new CartService();
		cartService.addProduct("0123");
		cartService.addProduct("4567");
		BigDecimal total = cartService.total();
		assertThat(total.toString()).isEqualTo("4");
	}
	
	@Test
	void cartWithProductPlaceOrderEmptyCart() throws Exception {
		CartService cartService = new CartService();
		cartService.addProduct("0123");
		cartService.finalizeOrder();
		BigDecimal total = cartService.total();
		assertThat(total).isEqualTo("0");
		assertThat(cartService.isEmpty()).isTrue();
	}
}
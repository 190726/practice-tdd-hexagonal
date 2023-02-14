package com.sk.market.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.sk.market.domain.Cart;
import com.sk.market.domain.DiscountRule;
import com.sk.market.domain.Product;

public class SpecialDealsCartTest {
	
	private static final String TOOTH_BRUSH_UPC = "4567";
	private static final String TOOTH_TEN_PERCENT_DISCOUNT_UPC = "0987";
	
	@Test
	void twoItemsInCartDiscountTest() throws Exception {
		Cart cart = new Cart();
		
		cart.add(new Product("0123", BigDecimal.ONE));
		cart.add(new Product("0123", BigDecimal.ONE));

		assertThat(cart.total()).isEqualTo("1.5");
		
	}
	
	@Test
	void threeItemsInCartDiscountTest() throws Exception {
		Cart cart = new Cart();
		
		cart.add(new Product("0123", BigDecimal.ONE));
		cart.add(new Product("0123", BigDecimal.ONE));
		cart.add(new Product("0123", BigDecimal.ONE));

		assertThat(cart.total()).isEqualTo("2.0");
	}
	
	@Test
	void tenPercentDiscountItemTest() throws Exception {
		Cart cart = new Cart();
		
		cart.add(new Product("4567", BigDecimal.TEN, DiscountRule.TEN_PERCENT_OFF));

		assertThat(cart.total()).isEqualTo("9.0");
	}
	
	@Test
	void tenPercentDiscountTwoItemTest() throws Exception {
		Cart cart = new Cart();
		
		cart.add(new Product("4567", BigDecimal.TEN, DiscountRule.TEN_PERCENT_OFF));
		cart.add(new Product("4567", BigDecimal.TEN, DiscountRule.TEN_PERCENT_OFF));

		assertThat(cart.total()).isEqualTo("15");
	}
	
}

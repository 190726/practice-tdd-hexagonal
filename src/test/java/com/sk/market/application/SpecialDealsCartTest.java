package com.sk.market.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.sk.market.domain.Cart;
import com.sk.market.domain.DiscountRule;
import com.sk.market.domain.Product;

public class SpecialDealsCartTest {
	
	@Test
	void twoItemsInCartDiscountTest() throws Exception {
		Cart cart = new Cart();
		
		cart.add(new Product("0123", BigDecimal.ONE));
		cart.add(new Product("0123", BigDecimal.ONE));

		assertThat(cart.total()).isEqualByComparingTo("1.5");
		
	}
	
	@Test
	void threeItemsInCartDiscountTest() throws Exception {
		Cart cart = new Cart();
		
		cart.add(new Product("0123", BigDecimal.ONE));
		cart.add(new Product("0123", BigDecimal.ONE));
		cart.add(new Product("0123", BigDecimal.ONE));

		assertThat(cart.total()).isEqualByComparingTo("2");
	}
	
	@Test
	void tenPercentDiscountItemTest() throws Exception {
		Cart cart = new Cart();
		
		cart.add(new Product("4567", BigDecimal.TEN, DiscountRule.TEN_PERCENT_OFF));

		assertThat(cart.total()).isEqualByComparingTo("9");
	}
	
	@Test
	void tenPercentDiscountTwoItemTest() throws Exception {
		Cart cart = new Cart();
		
		cart.add(new Product("4567", BigDecimal.TEN, DiscountRule.TEN_PERCENT_OFF));
		cart.add(new Product("4567", BigDecimal.TEN, DiscountRule.TEN_PERCENT_OFF));

		assertThat(cart.total()).isEqualByComparingTo("15");
	}
	
}

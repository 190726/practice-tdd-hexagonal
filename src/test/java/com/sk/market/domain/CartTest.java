package com.sk.market.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.sk.market.domain.Cart;

public class CartTest {
	
	/**
	 * @throws Exception
	 */
	@Test
	void emptyCartHasZero() throws Exception {
		Cart cart = new Cart();
		assertThat(cart.totalPrice()).isZero();
	}
	
	@Test
	void addOneToothbrush() throws Exception {
		Cart cart = new Cart();
		String productName = "Toothbrush";
		int productPrice = 1;
		cart.add(new Product(productName, productPrice));
		assertThat(cart.totalPrice()).isEqualTo(productPrice);
	}
	
	@Test
	void addTwoToothbrush() throws Exception {
		Cart cart = new Cart();
		String productName1 = "Toothbrush1";
		int productPrice1 = 1;
		String productName2 = "Toothbrush2";
		int productPrice2 = 2;
		cart.add(new Product(productName1, productPrice1));
		cart.add(new Product(productName2, productPrice2));
		assertThat(cart.totalPrice()).isEqualTo(3);
	}
	
	
	
//	@Test
//	void cartWithMultpleItemReceipt() throws Exception {
//		Cart cart = new Cart();
//		cart.add("Toothbrush", 1);
//		cart.add("Toothpaste", 2);
//		assertThat(cart.receipt()).isEqualTo("""
//				Toothbrush $1
//				
//				Total Price: $1
//				""");
//	}

}

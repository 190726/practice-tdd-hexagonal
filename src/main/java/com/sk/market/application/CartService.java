package com.sk.market.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sk.market.application.port.ProductPriceFetcher;
import com.sk.market.domain.Cart;
import com.sk.market.domain.Product;
import com.sk.market.domain.Receipt;

public class CartService {
	
	private final ProductPriceFetcher productPricer;
	
	private final Cart cart = new Cart();
	
	public CartService(ProductPriceFetcher productPricer) {
		this.productPricer = productPricer;
	}

	public BigDecimal total() {
		return cart.total();
	}

	public void addProduct(String upc) {
		cart.add(new Product(upc, productPricer.priceFor(upc)));
	}
	
	public Receipt finalizeOrder() {
		cart.requireCartNotEmpty();
		Receipt receipt = cart.receipt();
		return receipt;
	}
}
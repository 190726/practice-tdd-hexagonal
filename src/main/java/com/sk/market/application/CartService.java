package com.sk.market.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sk.market.application.port.DiscountFetcher;
import com.sk.market.application.port.ProductPriceFetcher;
import com.sk.market.domain.Cart;
import com.sk.market.domain.DiscountRule;
import com.sk.market.domain.Product;
import com.sk.market.domain.Receipt;

public class CartService {
	
	private final ProductPriceFetcher productPricer;
	
	private final Cart cart = new Cart();

	private final DiscountFetcher discountFetcher;
	
	public CartService(ProductPriceFetcher productPricer, DiscountFetcher discountFetcher) {
		this.productPricer = productPricer;
		this.discountFetcher = discountFetcher;
	}

	public BigDecimal total() {
		return cart.total();
	}

	public void addProduct(String upc) {
		
		cart.add(new Product(
				upc, productPricer.priceFor(upc), discountFetcher.getRule(upc)));
	}
	
	public Receipt finalizeOrder() {
		cart.requireCartNotEmpty();
		Receipt receipt = cart.receipt();
		return receipt;
	}
}
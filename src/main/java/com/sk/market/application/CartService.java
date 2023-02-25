package com.sk.market.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sk.ServiceBean;
import com.sk.market.application.port.DiscountFetcher;
import com.sk.market.application.port.ProductPriceFetcher;
import com.sk.market.domain.Cart;
import com.sk.market.domain.DiscountRule;
import com.sk.market.domain.Product;
import com.sk.market.domain.Receipt;

@Service
public class CartService {
	
	private final ProductPriceFetcher productPricer;

	private final DiscountFetcher discountFetcher;
	
	private final Cart cart = new Cart();

	private final CartNotifier notifier = (upc, price) -> {};
	

	public CartService(ProductPriceFetcher productPricer, DiscountFetcher discountFetcher) {
		this.productPricer = productPricer;
		this.discountFetcher = discountFetcher;
	}

	public BigDecimal total() {
		return cart.total();
	}

	public void addProduct(String upc) {
		BigDecimal price = productPricer.priceFor(upc);
		cart.add(new Product(
				upc, price, discountFetcher.getRule(upc)));
		notifier.productAdded(upc, price);
	}
	
	public Receipt finalizeOrder() {
		cart.requireCartNotEmpty();
		Receipt receipt = cart.receipt();
		return receipt;
	}
}
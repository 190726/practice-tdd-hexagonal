package com.sk.market.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sk.market.application.NoProductInCartException;

import net.bytebuddy.asm.Advice.Return;

public class Cart {
	
	private List<Product> products = new ArrayList<>();
	private Set<Product> eligibleProducts;
	
	public boolean add(Product product) {
		return products.add(product);
	}

	private BigDecimal discountedIndividualProductPrice(Product product) {
		BigDecimal actualPrice = product.price();
		String upc = product.upc();
		if(upc.equals("0987")) {
			return actualPrice.multiply(BigDecimal.valueOf(0.9));
		}
		return discountGroupProductPrice(product);
	}

	private BigDecimal discountGroupProductPrice(Product product) {
		if(eligibleProducts.contains(product)) {
			return product.price().divide(BigDecimal.valueOf(2));
		}
		eligibleProducts.add(product);
		return product.price();
	}

	public List<Product> products() {
		return List.copyOf(products);
	}

	public BigDecimal total() {
		eligibleProducts = new HashSet<>();
		return products.stream()
				.map(this::discountedIndividualProductPrice)
				.reduce((a, b) -> a.add(b))
				.orElse(BigDecimal.ZERO);
	}

	public boolean isEmpty() {
		return products.isEmpty();
	}

	public Receipt receipt() {
		return new Receipt(total(), products.stream().map(p -> p.upc()).toList());
	}

	public void requireCartNotEmpty() {
		if(isEmpty()) throw new NoProductInCartException();
	}

}
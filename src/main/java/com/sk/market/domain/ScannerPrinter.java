package com.sk.market.domain;

import java.util.stream.Collectors;

public class ScannerPrinter {

	private Cart cart;

	public ScannerPrinter(Cart cart) {
		this.cart = cart;
	}
	
	public String receiptNonEmptyCart() {
		
		String receipt = cart.products().map(this::productToReceipt)
				.collect(Collectors.joining());
		
		return """
				%s
				Total Price: $%s
				""".formatted(receipt,cart.totalPrice());
	}
	
	private String productToReceipt(Product product) {
		return """
				%s $%s
				""".formatted(product.productName(), product.productPrice());
	}

	public String receiptForEmptyCart() {
		return """
				Total Price: $%s
				""".formatted(cart.totalPrice());
	}

	public String receipt() {
		if(cart.totalPrice()==0)
			return receiptForEmptyCart();
		return receiptNonEmptyCart();
	}

}
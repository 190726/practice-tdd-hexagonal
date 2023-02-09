package com.sk.market;

public class Cart {

	private int totalPrice = 0;
	private String productName;

	public int totalPrice() {
		return totalPrice;
	}

	public void add(String productName, int productPrice) {
		this.productName = productName;
		this.totalPrice += productPrice;
	}
	
	private boolean isEmpty(){
		return totalPrice == 0;
	}

	public String receipt() {
		
		if(isEmpty()) {
			return receiptForEmptyCart();
		}
		return receiptNonEmptyCart();
	}

	private String receiptNonEmptyCart() {
		return """
				%s $%s
				
				Total Price: $%s
				""".formatted(productName,totalPrice(),totalPrice());
	}

	private String receiptForEmptyCart() {
		return """
				Total Price: $%s
				""".formatted(totalPrice());
	}
}

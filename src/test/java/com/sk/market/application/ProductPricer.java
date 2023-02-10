package com.sk.market.application;

public class ProductPricer {
	
	private static final int ZERO = 0;
	private static final int TOOTHE_BRUSH_UCP = 1;
	private static final int TOOTH_PASTE_PRICE = 3;
	private static final String TOOTH_BRUSH_UCP = "0123";
	private static final String TOOTH_PASTE_UPC = "4567";

	public int priceFor(String productName) {
		if(productName.equals(TOOTH_BRUSH_UCP)) {
			return TOOTHE_BRUSH_UCP;
		}else if(productName.equals(TOOTH_PASTE_UPC)) {
			return TOOTH_PASTE_PRICE;
		}
		return ZERO;
	}
}
package com.sk.market.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ScannerPrinterTest {

	@Test
	void emptyCartReceipt() throws Exception {
		Cart cart = new Cart();
		ScannerPrinter scannerPrinter = new ScannerPrinter(cart);
		assertThat(scannerPrinter.receipt()).isEqualTo("""
				Total Price: $0
				""");
	}
	
	@Test
	void cartWithOneItemReceipt() throws Exception {
		Cart cart = new Cart();
		
		Product product = new Product("Toothbrush", 1);
		
		cart.add(product);
		
		ScannerPrinter scannerPrinter = new ScannerPrinter(cart);
		
		assertThat(scannerPrinter.receipt()).isEqualTo("""
				Toothbrush $1
				
				Total Price: $1
				""");
	}
	
	@Test
	void cartWithMultipleItemReceipt() throws Exception {
		Cart cart = new Cart();
		
		Product product = new Product("Toothbrush", 1);
		Product product2 = new Product("Toothpaste", 2);
		
		cart.add(product);
		cart.add(product2);
		
		ScannerPrinter scannerPrinter = new ScannerPrinter(cart);
		
		System.out.println(scannerPrinter.receipt());
		
		assertThat(scannerPrinter.receipt()).isEqualTo("""
								Toothbrush $1 
								Toothpaste $2
								
								Total Price: $3
								""");
	}
}
package com.sk.market.adpater.in.web;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import com.sk.market.adapter.in.web.ScannerController;
import com.sk.market.application.CartService;
import com.sk.market.application.port.DiscountFetcher;
import com.sk.market.application.port.ProductPriceFetcher;
import com.sk.market.domain.DiscountRule;

import ch.qos.logback.core.status.Status;
import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;


public class ProductScannerControllerTest {
	
	
	private static final String TOOTHPASTE_UPC = "9451";
	private static final ProductPriceFetcher DUMMY_PRODUCT_PRICE_FETCHER = upc->BigDecimal.ZERO;
	private static final DiscountFetcher DUMMY_DISCOUNT_FETCHER = upc -> DiscountRule.NONE;
	

	@Test
	void scannerTemplate() throws Exception {
		
		ScannerController controller = new ScannerController(createCartServiceWithDummies());
		Model model = new ConcurrentModel();
		
		String page = controller.scanProduct(model);
		
		assertThat(page).isEqualTo("scan");
		assertThat(model.containsAttribute("upc")).isTrue();
		assertThat(model.getAttribute("total")).isEqualTo("0");
	}
	
	@Test
	void postValidUpcThenProductAddedToCart() throws Exception {
		CartService cartService = createCartServiceWithDummies();
		ScannerController controller = new ScannerController(cartService);
		controller.addProduct(TOOTHPASTE_UPC);
		assertThat(cartService.finalizeOrder().products()).containsExactly(TOOTHPASTE_UPC);
	}
	
	@Test
	public void postEmptyUpcThenRedirectToErrorPage() throws Exception {
		CartService cartService = createCartServiceWithDummies();
		ScannerController controller = new ScannerController(cartService);
		assertThrowsExactly(IllegalArgumentException.class, () -> controller.addProduct("") );
	}
	
	private CartService createCartServiceWithDummies() {
		return new CartService(DUMMY_PRODUCT_PRICE_FETCHER, DUMMY_DISCOUNT_FETCHER);
	}
}

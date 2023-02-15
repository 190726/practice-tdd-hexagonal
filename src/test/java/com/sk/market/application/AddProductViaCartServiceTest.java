package com.sk.market.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class AddProductViaCartServiceTest {
	
	private static final String TOOTHBRUSH_UPC = "0123";
    private static final String TOOTHPASTE_UPC = "0987";
	
	@Test
	void twoItemsThenCartTotalPrice() throws Exception {
		ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHBRUSH_UPC, BigDecimal.valueOf(1),
                TOOTHPASTE_UPC, BigDecimal.valueOf(3));
        CartService cartService = new CartService(productPricer, new StupDiscountFetcher());

        cartService.addProduct(TOOTHBRUSH_UPC);
        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualByComparingTo(BigDecimal.valueOf(1 + 2.7)); // evident data
	}
	
	@Test
    public void addToothpasteThenCartTotalPriceIsThreeDollars() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHPASTE_UPC, BigDecimal.valueOf(3));
        CartService cartService = new CartService(productPricer, new StupDiscountFetcher());

        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualByComparingTo("2.7");
    }

    @Test
    public void whereDiscountServiceHas10PercentDiscountRuleThenRuleIsApplied() throws Exception {
        ProductPriceFetcherStub productPricer = new ProductPriceFetcherStub(
                TOOTHPASTE_UPC, BigDecimal.valueOf(8));
        
        CartService cartService = new CartService(productPricer, new StupDiscountFetcher());

        cartService.addProduct(TOOTHPASTE_UPC);

        assertThat(cartService.total())
                .isEqualByComparingTo("7.2");
    }
}
package com.sk.market.adpater.in.web;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sk.market.application.port.ProductPriceFetcher;

@Tag("intergration")
@WebMvcTest
public class ProductScannerWebMvcTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ProductPriceFetcher productPriceFetcher;
	
	@Test
	void getRootPathIs200Ok() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk());
	}
	
	@Test
	void postRootPathIsRedirect() throws Exception {
		 mockMvc.perform(post("/").param("upc", "0123"))
		 		.andExpect(status().is3xxRedirection())
		 		.andExpect(redirectedUrl("/"));
	}
	
}
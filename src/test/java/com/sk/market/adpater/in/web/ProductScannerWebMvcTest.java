package com.sk.market.adpater.in.web;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@Tag("intergration")
@WebMvcTest
public class ProductScannerWebMvcTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void getRootPathIs200Ok() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk());
	}
	
	@Test
	void postRootPathIsRedirect() throws Exception {
		 mockMvc.perform(post("/"))
		 		.andExpect(status().is3xxRedirection());
	}
	
}
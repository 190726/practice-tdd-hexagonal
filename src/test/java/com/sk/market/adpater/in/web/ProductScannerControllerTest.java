package com.sk.market.adpater.in.web;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ch.qos.logback.core.status.Status;

@Tag("intergration")
@WebMvcTest
public class ProductScannerControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void getRootPathIs200Ok() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}

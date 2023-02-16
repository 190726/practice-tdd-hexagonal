package com.sk.market.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScannerController {
	
	@GetMapping("/")
	public String scanProduct() {
		return "scan";
	}
}

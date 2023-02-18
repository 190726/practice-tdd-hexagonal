package com.sk.market.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sk.market.application.CartService;

@Controller
public class ScannerController {
	
	private final CartService cartService;

	public ScannerController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping("/")
	public String scanProduct(Model model) {
		model.addAttribute("upc", "");
		return "scan";
	}
	
	@PostMapping("/")
	public String addProduct(String upc) {
		cartService.addProduct(upc);
		return "redirect:";
	}
}
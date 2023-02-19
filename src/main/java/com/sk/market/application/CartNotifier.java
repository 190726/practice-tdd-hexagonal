package com.sk.market.application;

import java.math.BigDecimal;

public interface CartNotifier {
	
	void productAdded(String upc, BigDecimal productPrice);

}

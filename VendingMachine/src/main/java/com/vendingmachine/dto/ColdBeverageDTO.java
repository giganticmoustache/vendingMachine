package com.vendingmachine.dto;

import java.math.BigDecimal;

public class ColdBeverageDTO extends BeverageDTO {
	public ColdBeverageDTO() {
		super();
		this.setPrice(new BigDecimal(1));
	}
}

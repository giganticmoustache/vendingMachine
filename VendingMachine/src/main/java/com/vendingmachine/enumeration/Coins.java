package com.vendingmachine.enumeration;

import java.math.BigDecimal;

public enum Coins {
	FIVE(new BigDecimal(0.05)), TEN(new BigDecimal(0.1)), TWENTYFIVE(new BigDecimal(0.25)), /**/
	FIFTY(new BigDecimal(0.5)), ONE(BigDecimal.ONE);

	private BigDecimal value;

	Coins(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return this.value;
	}
}

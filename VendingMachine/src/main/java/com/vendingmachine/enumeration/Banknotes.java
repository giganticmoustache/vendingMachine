package com.vendingmachine.enumeration;

import java.math.BigDecimal;

public enum Banknotes {
	FIVE(new BigDecimal(5)), TEN(new BigDecimal(10)), TWENTY(new BigDecimal(20)), /**/
	FIFTY(new BigDecimal(50)), HUNDRED(new BigDecimal(100));

	private BigDecimal value;

	Banknotes(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return this.value;
	}
}

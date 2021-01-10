package com.vendingmachine.enumeration;

public enum PaymentTypes {
	CONTACTLESS_CREDITCARD("Contactless Credit Card"), CREDITCARD("Credit Card"), /**/
	COIN("Coin"), BANKNOTE("Banknote");

	private String name;

	PaymentTypes(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}

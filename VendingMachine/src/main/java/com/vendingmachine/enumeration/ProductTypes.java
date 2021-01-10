package com.vendingmachine.enumeration;

public enum ProductTypes {
	FOOD("Food"), HOT_BEVERAGE("Hot beverage"), COLD_BEVERAGE("Cold beverage");

	private String name;

	ProductTypes(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}

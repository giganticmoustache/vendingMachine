package com.vendingmachine.response;

import java.util.List;

import com.vendingmachine.enumeration.ProductTypes;

public class ResponseGetProductTypes {
	private List<ProductTypes> productTypes;

	public List<ProductTypes> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProductTypes> productTypes) {
		this.productTypes = productTypes;
	}
}

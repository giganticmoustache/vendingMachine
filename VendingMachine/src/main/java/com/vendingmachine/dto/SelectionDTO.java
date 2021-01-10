package com.vendingmachine.dto;

import com.vendingmachine.enumeration.ProductTypes;

public class SelectionDTO {
	private ProductTypes productType;
	private Integer numberOfSelectedItems;
	private Integer sugerCount;

	public ProductTypes getProductType() {
		return productType;
	}

	public Integer getNumberOfSelectedItems() {
		return numberOfSelectedItems;
	}

	public Integer getSugerCount() {
		return sugerCount;
	}

	public void setProductType(ProductTypes productType) {
		this.productType = productType;
	}

	public void setNumberOfSelectedItems(Integer numberOfSelectedItems) {
		this.numberOfSelectedItems = numberOfSelectedItems;
	}

	public void setSugerCount(Integer sugerCount) {
		this.sugerCount = sugerCount;
	}
}

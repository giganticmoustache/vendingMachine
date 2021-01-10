package com.vendingmachine.dto;

import java.math.BigDecimal;

import com.vendingmachine.enumeration.ProductStatus;

public class FoodDTO extends ProductDTO {

	public FoodDTO() {
		this.setStatus(ProductStatus.AVAILABLE);
		this.setPrice(new BigDecimal(5));
	}
}

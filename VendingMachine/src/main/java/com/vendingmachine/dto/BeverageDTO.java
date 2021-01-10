package com.vendingmachine.dto;

import com.vendingmachine.enumeration.ProductStatus;

public class BeverageDTO extends ProductDTO {

	public BeverageDTO() {
		this.setStatus(ProductStatus.AVAILABLE);
	}
}

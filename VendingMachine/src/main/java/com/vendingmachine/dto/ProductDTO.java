package com.vendingmachine.dto;

import java.math.BigDecimal;

import com.vendingmachine.enumeration.ProductStatus;

public abstract class ProductDTO {
	private BigDecimal price;
	private ProductStatus status;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}
}

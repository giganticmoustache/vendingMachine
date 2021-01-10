package com.vendingmachine.response;

import java.math.BigDecimal;
import java.util.List;

import com.vendingmachine.dto.ProductDTO;

public class ResponseSelectProduct {
	private List<ProductDTO> productList;
	private BigDecimal price;

	public List<ProductDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductDTO> productList) {
		this.productList = productList;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}

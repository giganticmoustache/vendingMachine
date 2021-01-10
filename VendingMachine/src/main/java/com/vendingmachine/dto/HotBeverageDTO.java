package com.vendingmachine.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class HotBeverageDTO extends BeverageDTO {
	@NotNull(message = "For hot beverages number of cube sugars must be selected!")
	@PositiveOrZero(message = "For hot beverages number of cube sugars must be zero or a positive number!")
	private Integer sugarCount;
	
	public HotBeverageDTO() {
		super();
		this.setPrice(new BigDecimal(0.50));
	}

	public Integer getSugarCount() {
		return sugarCount;
	}

	public void setSugarCount(Integer sugarCount) {
		this.sugarCount = sugarCount;
	}
}

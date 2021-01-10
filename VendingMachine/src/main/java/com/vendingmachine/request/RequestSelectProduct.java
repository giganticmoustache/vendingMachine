package com.vendingmachine.request;

import com.vendingmachine.dto.SelectionDTO;
import com.vendingmachine.validator.BeverageSelection;
import com.vendingmachine.validator.FoodSelection;
import com.vendingmachine.validator.ProductType;
import com.vendingmachine.validator.Selection;
import com.vendingmachine.validator.SugarCount;

public class RequestSelectProduct {
	@BeverageSelection
	@FoodSelection
	@ProductType
	@SugarCount
	@Selection
	private SelectionDTO selection;

	public SelectionDTO getSelection() {
		return selection;
	}

	public void setSelection(SelectionDTO selection) {
		this.selection = selection;
	}
}

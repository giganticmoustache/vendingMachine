package com.vendingmachine.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vendingmachine.dto.SelectionDTO;
import com.vendingmachine.enumeration.ProductTypes;

public class FoodSelectionValidator implements ConstraintValidator<FoodSelection, SelectionDTO> {

	@Override
	public boolean isValid(SelectionDTO value, ConstraintValidatorContext context) {
		if (ProductTypes.FOOD.equals(value.getProductType()) && value.getNumberOfSelectedItems().compareTo(20) > 0) {
			return false;
		} else {
			return true;
		}
	}
}

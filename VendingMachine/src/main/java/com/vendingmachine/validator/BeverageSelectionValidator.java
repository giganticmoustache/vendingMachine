package com.vendingmachine.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vendingmachine.dto.SelectionDTO;
import com.vendingmachine.enumeration.ProductTypes;

public class BeverageSelectionValidator implements ConstraintValidator<BeverageSelection, SelectionDTO> {

	@Override
	public boolean isValid(SelectionDTO value, ConstraintValidatorContext context) {
		if ((ProductTypes.HOT_BEVERAGE.equals(value.getProductType())
				|| ProductTypes.COLD_BEVERAGE.equals(value.getProductType()))
				&& value.getNumberOfSelectedItems().compareTo(10) > 0) {
			return false;
		} else {
			return true;
		}
	}

}

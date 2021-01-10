package com.vendingmachine.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vendingmachine.dto.SelectionDTO;
import com.vendingmachine.enumeration.ProductTypes;

public class SugarCountValidator implements ConstraintValidator<SugarCount, SelectionDTO> {

	@Override
	public boolean isValid(SelectionDTO value, ConstraintValidatorContext context) {
		if (ProductTypes.HOT_BEVERAGE.equals(value.getProductType()) && value.getSugerCount() == null) {
			return false;
		} else if (ProductTypes.HOT_BEVERAGE.equals(value.getProductType()) && value.getSugerCount() != null
				&& value.getSugerCount().compareTo(0) < 0) {
			return false;
		} else {
			return true;
		}
	}

}

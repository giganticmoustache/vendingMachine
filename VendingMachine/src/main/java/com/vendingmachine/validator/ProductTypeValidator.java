package com.vendingmachine.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vendingmachine.dto.SelectionDTO;
import com.vendingmachine.enumeration.ProductTypes;

public class ProductTypeValidator implements ConstraintValidator<ProductType, SelectionDTO> {

	@Override
	public boolean isValid(SelectionDTO value, ConstraintValidatorContext context) {
		boolean valid = false;
		for (ProductTypes productType : ProductTypes.values()) {
			if (productType.equals(value.getProductType())) {
				valid = true;
				break;
			}
		}
		return valid;
	}

}

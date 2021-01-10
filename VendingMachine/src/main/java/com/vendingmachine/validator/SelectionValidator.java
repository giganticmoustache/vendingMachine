package com.vendingmachine.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vendingmachine.dto.SelectionDTO;

public class SelectionValidator implements ConstraintValidator<Selection, SelectionDTO> {

	@Override
	public boolean isValid(SelectionDTO value, ConstraintValidatorContext context) {
		if (value.getNumberOfSelectedItems() == null || value.getNumberOfSelectedItems().compareTo(0) <= 0) {
			return false;
		} else {
			return true;
		}
	}
}

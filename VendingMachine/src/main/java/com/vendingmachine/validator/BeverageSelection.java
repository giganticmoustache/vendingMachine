package com.vendingmachine.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { BeverageSelectionValidator.class })
public @interface BeverageSelection {
	String message() default "Maximum number of beverage selection can be 10!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

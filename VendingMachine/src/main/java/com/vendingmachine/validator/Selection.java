package com.vendingmachine.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { SelectionValidator.class })
public @interface Selection {
	String message() default "Number of selected items must be greater than 0 or positive number!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

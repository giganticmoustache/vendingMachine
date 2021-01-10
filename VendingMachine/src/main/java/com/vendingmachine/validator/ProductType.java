package com.vendingmachine.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { ProductTypeValidator.class })
public @interface ProductType {
	String message() default "Unknown product type!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

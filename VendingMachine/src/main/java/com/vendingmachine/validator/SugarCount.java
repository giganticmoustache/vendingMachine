package com.vendingmachine.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { SugarCountValidator.class })
public @interface SugarCount {
	String message() default "Number of cube sugar selected can be 0 or a positive number!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

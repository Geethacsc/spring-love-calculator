package com.springmvc.lc.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = { MobileConstraint.class })
@Documented
public @interface Phone {

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String message() default "{communicationdto.mobile.invalid}";

	int number() default 10;

	int countryCode() default 2;

}

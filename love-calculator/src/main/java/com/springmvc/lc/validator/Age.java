package com.springmvc.lc.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= {AgeConstraint.class})
@Documented
public @interface Age {

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min() default 18;

	int max() default 60;

	String message() default "{spring.lc.age}";

}

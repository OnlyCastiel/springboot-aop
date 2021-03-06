package com.mfq.home.schooljob.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validator {
    boolean required() default false;

    String message() default "";

    String[] selects() default {};

    String regExp() default "";
}

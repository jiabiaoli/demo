package com.example.validation.annotation;

import com.example.validation.PhoneValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @auther jiabiaoli@boco.com.cn
 * @date 2018/12/17 20:51
 */

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidation.class )
public @interface PhoneAnnotation {
    String message() default "手机号已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

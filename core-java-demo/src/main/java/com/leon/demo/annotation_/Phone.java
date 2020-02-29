package com.leon.demo.annotation_;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2020/2/9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface Phone {
    PhoneType type() default PhoneType.CELL_PHONE;
}

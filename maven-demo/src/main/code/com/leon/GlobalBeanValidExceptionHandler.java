package com.leon;

import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

public class GlobalBeanValidExceptionHandler {
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @ExceptionHandler
    public String handle(ValidationException exception) {
        System.out.println("bad request, " + exception.getMessage());
        return "bad request, " + exception.getMessage();
    }
}
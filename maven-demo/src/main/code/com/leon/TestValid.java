package com.leon;

import bean.Person;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


@Validated
public class TestValid {
    public static void main(String[] args) {
        Person p = new Person();
        p.setSex("M");
        valid(p);
    }

    public static void valid(@Valid Person person){
        System.out.println("valid");
    }
}

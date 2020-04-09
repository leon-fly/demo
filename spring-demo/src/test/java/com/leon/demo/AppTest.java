package com.leon.demo;

import static org.junit.Assert.assertTrue;

import com.leon.demo.advice.MyAdvice;
import com.leon.demo.service.GenericService;
import com.leon.demo.service.impl.GenericServiceImpl;
import com.sun.tools.internal.jxc.gen.config.Classes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {GenericServiceImpl.class, MyAdvice.class, App.class})
@EnableAspectJAutoProxy
public class AppTest 
{
    @Autowired
    GenericService genericService;

    @Autowired
    MyAdvice myAdvice;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAdvice()
    {
        genericService.sayHello("ni hao ~");
    }
}

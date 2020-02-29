package com.leon.demo.eureka.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2019/12/29
 */
@RestController
public class EurekaProviderController extends BaseController {

    @GetMapping("hello-world")
    public String hello() throws InterruptedException {
        long hystrixTimeout = 2000;
        String time = new SimpleDateFormat("hh:mm:ss").format(new Date());
        System.out.println("EurekaProviderController is called,time:" + time + "...");

        int random = new Random().nextInt(10);
        if (random%2==0) {
            System.out.println("sleep...");
            Thread.sleep(hystrixTimeout);
        }

        return "hello, i am eureka provider!time=" + time;
    }

}

package com.leon.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/15
 */
@Component
public class LogMessageOnTimerEventRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:logMessageTimer?period=1m")
                .log("Event triggered by ${property.CamelTimerName}"
                        + " at ${header.CamelTimerFiredTime}");
    }
}

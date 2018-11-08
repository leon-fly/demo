package com.leon.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author : leonwang
 * @Descpriction
 * @Date:created 2018/8/15
 */

@Component
public class TransRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start ")
                .choice()
                    .when()
                        .simple("${body} contains 'trans'")
                        .to("")
                    .otherwise()
                        .to("")
                .end();
    }
}

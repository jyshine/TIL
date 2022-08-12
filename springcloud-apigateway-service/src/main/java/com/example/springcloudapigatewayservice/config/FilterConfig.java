package com.example.springcloudapigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {
//    @Bean
    public RouteLocator gatewayRouters(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .filters(f-> f
                                .addRequestHeader("first-request","first-request-header")
                                .addResponseHeader("first-request","first-response-header")
                        )
                        .uri("http://localhost:8001"))
                .route(r -> r.path("/second-service/**")
                        .filters(f-> f
                                .addRequestHeader("second-request","second-request-header")
                                .addResponseHeader("second-request","second-response-header")
                        )
                        .uri("http://localhost:8002"))
                .build();
    }

}

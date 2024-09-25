package com.microservice.GateWay.configrution;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GateWayConfig {

//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder){
//        return builder
//                .routes()
//                .route(predicateSpec -> predicateSpec.path("/student/**")
//                        .uri("lb://STUDENTSERVICE"))
//                .route(predicateSpec -> predicateSpec.path("/department/**")
//                        .uri("lb://DEPARTMENTSERVICE"))
//                .build();
//    }

}



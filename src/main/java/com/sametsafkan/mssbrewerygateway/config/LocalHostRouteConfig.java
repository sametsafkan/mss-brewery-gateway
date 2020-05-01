package com.sametsafkan.mssbrewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/api/v1/beer*","/api/v1/beer/*","/api/v1/beerUpc/*")
                        .uri("http://localhost:8080")
                        .id("beer-service"))
                .route(r -> r.path("/api/v1/customers/*/orders*", "/api/v1/customers/*/orders/*", "/api/v1/customers/*/customers*")
                        .uri("http://localhost:8081")
                        .id("beer-order-service"))
                .route(r -> r.path("/api/v1/beer/*/inventory", "/api/v1/inventory*", "/api/v1/inventory/*")
                        .uri("http://localhost:8082")
                        .id("beer-inventory-service"))
                .build();
    }
}

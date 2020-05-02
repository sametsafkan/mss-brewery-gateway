package com.sametsafkan.mssbrewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("google")
public class GoogleConfig {

    @Bean
    public RouteLocator googleRouteConfig(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/search2")
                        .filters(f -> f.rewritePath("/search2(?<segment>/?.*)", "/${segment}"))
                        .uri("https://google.com.tr")
                        .id("google"))
                .build();
    }
}

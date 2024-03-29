package com.example.gatewayjwt.config;

import com.example.gatewayjwt.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Autowired
    AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product", r -> r.path("/product/**")
                        .filters(f -> f.filter(filter.apply(filter.newConfig())))
                        .uri("lb://product"))

                .route("AuthService", r -> r.path("/AuthService/**")
                        .filters(f -> f.filter(filter.apply(filter.newConfig())))
                        .uri("lb://AuthService"))
                .route("Employee", r -> r.path("/employee/**")
                .filters(f -> f.filter(filter.apply(filter.newConfig())))
                .uri("lb://Employee"))
                .build();

    }
}

package com.demo.gateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Configuration
public class RoutesConfig {
    @Value("${uri.api.clientes}")
    private String clientesUri;

    @Value("${uri.api.cuentas}")
    private String cuentasUri;
    /*@Bean
    public RouteLocator rutasClientes(RouteLocatorBuilder builder){

        return builder.routes()
                .route("all clientes",r-> r.path("/promerica/todos-los-clientes")
                        .filters(f-> f.rewritePath("/promerica/todos-los-clientes","/v1/api/cliente/all")
                                .addRequestHeader("X-GATEWAY-REQUEST-HEADER","GATEWAY-SOLICITUD")
                                .addRequestHeader("X-GATEWAY-RESPONSE-HEADER", "GATEWAY_RESPONSE"))
                        .uri(clientesUri))
                .route("all cliente_id",r-> r.path("/v1/api/cliente/{id}")
                        .and().method(HttpMethod.GET)
                        .filters(f-> f.addRequestHeader("X-GATEWAY-REQUEST-HEADER","GATEWAY-SOLICITUD")
                                .addRequestHeader("X-GATEWAY-RESPONSE-HEADER", "GATEWAY_RESPONSE"))
                        .uri(clientesUri))
                .build();
    }

    @Bean
    public RouteLocator rutasCuentas(RouteLocatorBuilder builder){

        return builder.routes()
                .route("all cuentas",r-> r.path("/api/v2/pokemon/ditto")
                        .filters(f-> f.addRequestHeader("X-GATEWAY-REQUEST-HEADER","GATEWAY-SOLICITUD")
                                .addResponseHeader("X-GATEWAY-RESPONSE-HEADER", "GATEWAY_RESPONSE"))
                        .uri(cuentasUri))
                .build();
    }*/

    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress());
    }
}

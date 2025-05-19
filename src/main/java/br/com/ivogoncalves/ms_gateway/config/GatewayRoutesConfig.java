package br.com.ivogoncalves.ms_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(p -> p.path("/get").filters(f -> f.addRequestHeader("Hello", "World").addRequestParameter("Hello", "World"))
																										.uri("http://httpbin.org:80"))
			.route("ms-book", r -> r.path("/api/book-service/**").uri("lb://ms-book"))
			.route("ms-currency-exchange", r -> r.path("/api/currency-exchange/**").uri("lb://ms-currency-exchange"))
			.build();
	}
}

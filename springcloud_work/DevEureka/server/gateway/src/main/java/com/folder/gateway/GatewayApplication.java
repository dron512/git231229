package com.folder.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

/*
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder, ApiFilter apiFilter) {
		return builder.routes()
			.route("folder-api1",
				routeSpec -> routeSpec
					.path("/api1/**")
					.filters(filterSpec -> filterSpec.filter(apiFilter.apply(new ApiFilter.Config())))
					.uri("http://localhost:8081")
			)
			.route("folder-api2",
				routeSpec -> routeSpec
					.path("/api2/**")
					.uri("http://localhost:8082")
			)
			.build();
	}
*/

}

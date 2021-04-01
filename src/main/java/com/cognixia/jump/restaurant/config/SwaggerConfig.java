package com.cognixia.jump.restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build()
				.apiInfo( apiDetails());
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo apiDetails() {
		return new ApiInfo("Restaurant API",
				"JUMP Program Final Project",
				"1.0",
				"Free To Use for Education Purposes",
				"Regae Laroya",
				"API License",
				"https://popartshirt.com");
	}
}

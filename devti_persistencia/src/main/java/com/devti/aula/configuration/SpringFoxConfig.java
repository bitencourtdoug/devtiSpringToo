package com.devti.aula.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.devti.aula.resources"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API para persistencia de cidades e clientes")
				.description("Esta API é aprendizado do curso DEV-TI da Fundação Unisul - https://www.devtisul.com.br/ ")
				.version("1.0.0")
				.license("Apache Licence Version 2.0").licenseUrl("https://www.apache.org/licences/LICENCE-2.0")
				.contact(new Contact("Douglas Bitencourt", "https://www.linkedin.com/in/bitencourtdoug/", "douglasbitencourtadm@gmail.com"))
				.build();
		
	}

}

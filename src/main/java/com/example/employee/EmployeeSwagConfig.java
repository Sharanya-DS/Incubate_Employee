package com.example.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * This class is used to enable SWAGGER - the API documentation tool. This class
 * mainly centers around the Docket bean. It defines a Docket bean is defined,
 * which provides a way to control the endpoints exposed by Swagger and have the
 * documentation for your entire API available through Swagger.
 * 
 * @author Sharanya
 *
 */
@Configuration
@EnableSwagger2
public class EmployeeSwagConfig {

	/**
	 * 
	 * This method's select() method returns an instance of ApiSelectorBuilder,
	 * which provides a way to control the endpoints exposed by Swagger. It also
	 * predicates for selection of RequestHandlers can be configured with the help
	 * of RequestHandlerSelectors and PathSelectors. Using any() for both will make
	 * documentation for your entire API available through Swagger.
	 * 
	 * @return the Docket object.
	 * 
	 */

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
}

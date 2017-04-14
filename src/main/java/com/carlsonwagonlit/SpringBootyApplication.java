package com.carlsonwagonlit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootyApplication.class, args);
	}

    @Bean
    public Docket helloApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("greetings")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/greeting.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("https://github.com/joeyslalom/spring-booty")
                .contact("Joey T")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/joeyslalom/spring-booty")
                .version("2.0")
                .build();
    }
}

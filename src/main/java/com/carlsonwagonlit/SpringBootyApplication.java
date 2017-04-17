package com.carlsonwagonlit;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

@SpringBootApplication
@EnableSwagger2
public class SpringBootyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootyApplication.class, args);
	}

    @Bean
    public Docket helloApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("hello")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/greeting.*"))
                .build();
    }

    @Bean
    public Docket lineDefApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("lineDefs")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/lineDef.*"))
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

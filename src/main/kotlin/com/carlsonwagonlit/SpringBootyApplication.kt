package com.carlsonwagonlit

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Spring Boot and Swagger 2 setup.  Spring + Kotlin integration requires using open classes and functions
 */
@SpringBootApplication
@EnableSwagger2
open class SpringBootyApplication {
    @Bean
    open fun lineDefApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .groupName("lineDefs")
                .apiInfo(apiInfo())
                .select()
                //                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/lineDef.*"))
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("https://github.com/joeyslalom/spring-booty")
                .contact(Contact("Joey T", "", ""))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/joeyslalom/spring-booty")
                .version("2.0")
                .build()
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootyApplication::class.java, *args)
}


package com.example.demo.security.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).build()
                .apiInfo(new ApiInfoBuilder()
                        .version("1.0")
                        .title("MarketPlace")
                        .description("REST api with spring security")
                        .build())
                .securitySchemes(singletonList(new ApiKey("token", "Authorization", "Header")))
                .securityContexts(singletonList(SecurityContext.builder()
                        .securityReferences(singletonList(SecurityReference.builder()
                                .reference("token")
                                .scopes(new AuthorizationScope[0])
                                .build()))
                        .forPaths(PathSelectors.regex("/api/v1/products.*"))
                        .build()));
    }

}

package org.todoapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi animeApi() {
        return GroupedOpenApi.builder()
                .group("todos")
                .pathsToMatch("/todos/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Todos API")
                        .description("Todos API description")
                        .version("v0.0.1")
                        .license(new License().name("MIT Licence").url("https://opensource.org/licenses/MIT")));
    }

}
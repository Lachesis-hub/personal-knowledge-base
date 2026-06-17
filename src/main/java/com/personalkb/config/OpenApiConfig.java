package com.personalkb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// swagger 配置 http://localhost:8081/swagger-ui/index.html
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        SecurityScheme securityScheme =
                new SecurityScheme()
                        .type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.HEADER)
                        .name("token");

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Personal KB API")
                                .version("1.0")
                                .description("个人知识库接口文档")
                )
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList("token")
                )
                .schemaRequirement(
                        "token",
                        securityScheme
                );
    }
}
package com.sitanInfo.API_WS_FINANCE.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API_WEB_SCHOOL")
                        .description("Micoservice pour le module finance")
                        .version("1.0"));
    }
}

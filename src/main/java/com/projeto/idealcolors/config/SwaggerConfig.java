package com.projeto.idealcolors.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("IdealColors API")
                        .description("Uma API para o sistema Ideal Colors.")
                        .summary("Essa api server para definir a paleta de cores ideal")
                        .version("V1")
                        .contact(new Contact()
                                .name("Jakeline Santana")
                                .email("jakeline@fiap.com.br")
                        )
                        .license(new License()
                                .name("MIT Open Soucer")
                                .url("http://idealcolors.com/licenca")
                        )
                );
//                .components(new Components()
//                        .addSecuritySchemes("bearer-key",
//                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
//                                        .bearerFormat("JWT")));
    }
}


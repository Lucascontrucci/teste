package com.salesunity.appsu.application;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Sales Unity")
                        .description("API para requisição e processamento de dados da Sales Unity")
                        .contact(new Contact().name("Giovanni de Arruda Ultramari").email("giovanniultramari@gmail.com"))
                        .version("1.0.0"));
    }
}

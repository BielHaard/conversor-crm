package com.reino.srm.conversor.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Conversão de Moedas",
                version = "1.0",
                description = "Sistema de conversão de moedas de Wefin usando Tibar e Ouro Real",
                contact = @Contact(name = "Equipe Wefin", email = "contato@wefin.com")
        )
)
public class OpenApiConfig {
}


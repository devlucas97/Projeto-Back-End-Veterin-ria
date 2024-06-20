package com.projeto.veterinaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class OpenApiConfig {
	
  @Bean
  public OpenAPI myOpenAPI() {
   
    Contact contact = new Contact();
    contact.setEmail("smith@gmail.com");
    contact.setName("Smith");
    contact.setUrl("https://www.smith.com");


    Info info = new Info()
        .title("Vendas API")
        .version("1.0")
        .contact(contact)
        .description("Projeto de Vendas API.");

    return new OpenAPI().info(info);
  }
}

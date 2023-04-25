package br.com.tutorial.dockernetworking.networkingmicroserviceprovider;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SwaggerConfig {

    private static final String TITLE = "Aplicacao Teste";
    private static final String DESCRIPTION = "Uma applicacao de testes para estudo das tecnologias";
    private static final String VERSION = "1.0.0";
    private static final String CONTACT_NAME = "Vinicius Fernandes";
    private static final String CONTACT_URL = "https://minhaaplicacaoteste.com.br/contato";
    private static final String CONTACT_EMAIL = "viniciussf@hotmail.com";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(getInfo())
                .components(new Components().securitySchemes(getSecurityScheme()));
    }

    private Info getInfo() {
        return new Info()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(this.getContact());
    }

    private Contact getContact() {
        return new Contact()
                .name(CONTACT_NAME)
                .url(CONTACT_URL)
                .email(CONTACT_EMAIL);
    }

    private Map<String, SecurityScheme> getSecurityScheme() {
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .name(SecurityScheme.Type.APIKEY.toString())
                .scheme(SecurityScheme.Type.APIKEY.toString())
                .in(SecurityScheme.In.HEADER);
        Map<String, SecurityScheme> stringSecuritySchemeMap = new HashMap<>();
        stringSecuritySchemeMap.put(SecurityScheme.Type.APIKEY.toString(), securityScheme);
        return stringSecuritySchemeMap;
    }
}

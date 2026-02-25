package com.project.backend.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SemanticScholarConfig {

//    @Value("${semanticscholar.api.key}")
//    private String apiKey;

    @Value("${semanticscholar.api.base-url}")
    private String baseUrl;

    @Value("${semanticscholar.api.key}")
    private String apiKey;

    @Bean
    @Primary
    public WebClient semanticScholarClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("x-api-key",  apiKey)
                .build();
    }
}
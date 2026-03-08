package com.project.backend.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

//    @Value("${semanticscholar.api.key}")
//    private String apiKey;

    @Value("${semanticscholar.api.base-url}")
    private String semanticScholarBaseUrl;

    @Value("${theirstack.api.base-url}")
    private String theirStackBaseUrl;

    @Value("${semanticscholar.api.key}")
    private String semanticScholarApiKey;




    @Bean("semanticScholarClient")
    public WebClient semanticScholarClient() {
        return WebClient.builder()
                .baseUrl(semanticScholarBaseUrl)
                .defaultHeader("x-api-key",  semanticScholarApiKey)
                .build();
    }

    @Bean("theirStackWebClient")
    public WebClient theirStackWebClient() {
        return WebClient.builder()
                .baseUrl(theirStackBaseUrl)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }





}
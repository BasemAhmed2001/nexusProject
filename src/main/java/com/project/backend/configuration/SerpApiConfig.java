//package com.project.backend.configuration;
//
//
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@Getter
//@Configuration
//public class SerpApiConfig {
//
//    @Value("${serpapi.api-key}")
//    private String apiKey;
//
//    @Bean("serpApiWebClient")
//    public WebClient serpApiWebClient() {
//        return WebClient.builder()
//                .baseUrl("https://serpapi.com")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .build();
//    }
//
//}
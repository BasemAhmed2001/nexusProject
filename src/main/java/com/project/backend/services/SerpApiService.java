package com.project.backend.services;

import com.project.backend.configuration.SerpApiConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class SerpApiService {

    private final WebClient webClient;
    private final SerpApiConfig config;

    public SerpApiService(@Qualifier("serpApiWebClient") WebClient webClient, SerpApiConfig config) {
        this.webClient = webClient;
        this.config = config;
    }

    public Mono<String> search(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("engine", "google_scholar")
                        .queryParam("q", query)
                        .queryParam("api_key", config.getApiKey())
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}

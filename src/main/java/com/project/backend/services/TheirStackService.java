package com.project.backend.services;


import com.project.backend.DTOs.TheirStackRequestDTOs;
import com.project.backend.DTOs.TheirStackResponseDTOs;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheirStackService {


    @Value("${theirstack.api.key}")
    private String theirStackApiKey;


    private final WebClient theirStackWebClient;


    public TheirStackService(@Qualifier("theirStackWebClient") WebClient theirStackWebClient) {
        this.theirStackWebClient = theirStackWebClient;
    }


    public Mono<List<TheirStackResponseDTOs.JobFound>> getLinkedInJobsByCompanyLink(String companyLink) {

        TheirStackRequestDTOs.CompanySearchRequest request = TheirStackRequestDTOs.CompanySearchRequest.builder()
                .includeTotalResults(false)
                .orderBy(List.of(
                        TheirStackRequestDTOs.OrderBy.builder().desc(true).field("confidence").build(),
                        TheirStackRequestDTOs.OrderBy.builder().desc(true).field("jobs").build(),
                        TheirStackRequestDTOs.OrderBy.builder().desc(true).field("num_jobs").build()
                ))
                .companyLinkedinUrlOr(List.of(companyLink))
                .jobFilters(TheirStackRequestDTOs.JobFilters.builder().postedAtMaxAgeDays(7).build())
                .expandTechnologySlugs(Collections.emptyList())
                .page(0)
                .limit(10)
                .blurCompanyData(false)
                .build();



        return theirStackWebClient.post()
                .uri("/v1/companies/search")
                .bodyValue(request)
                .header("Authorization", "Bearer "+theirStackApiKey)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new RuntimeException("API error: " + clientResponse.statusCode() + " - " + errorBody)
                                ))
                )
                .bodyToMono(TheirStackResponseDTOs.JobSearchResponse.class)
                .map(response -> response.getData().stream()
                        .flatMap(company -> company.getJobsFound().stream())
                        .collect(Collectors.toList())
                );


    }





}

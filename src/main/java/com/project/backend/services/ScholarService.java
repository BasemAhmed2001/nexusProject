package com.project.backend.services;


import com.project.backend.DTOs.DTOs;
import com.project.backend.DTOs.PaperDTO;
import com.project.backend.DTOs.PaperDetailsDTOs;
import com.project.backend.DTOs.SearchResponseDTO;
//import com.project.backend.entities.Paper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
public class ScholarService {

    private final WebClient semanticScholarClient;

    public ScholarService(@Qualifier("semanticScholarClient") WebClient semanticScholarClient) {
        this.semanticScholarClient = semanticScholarClient;
    }

    public Mono<PaperDTO> getPaperDetails(String paperId) {
        return semanticScholarClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/paper/{paperId}")
                        .queryParam("fields", "title,year,authors,abstract,url")
                        .build(paperId))
                .retrieve()
                .bodyToMono(PaperDTO.class);
    }

    public Mono<SearchResponseDTO> searchPapers(String query, int limit, int offset) {
        return semanticScholarClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/paper/search")
                        .queryParam("query", query)
                        .queryParam("fields", "title,year,authors,abstract,url,authors.url,authors.name")
                        .queryParam("offset", offset)
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .bodyToMono(SearchResponseDTO.class);
                //.timeout(Duration.ofSeconds(10))
                //.retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(5)));
    }


    public Mono<DTOs.SnippetSearchResponse> snippetSearch(String query, int limit) {
        return semanticScholarClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/snippet/search")
                        .queryParam("query", query)
                        .queryParam("fields", "snippet.text,snippet.snippetKind,snippet.section,snippet.snippetOffset,snippet.annotations.refMentions,snippet.annotations.sentences")
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .bodyToMono(DTOs.SnippetSearchResponse.class);
    }


    public Mono<PaperDetailsDTOs.PaperDetailsResponse> paperSearchById(String paperId) {

        return semanticScholarClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/paper/CorpusID:"+paperId)
                        .queryParam("fields", "embedding,fieldsOfStudy,title,year,authors,abstract,url,citations.title,citations.abstract,authors.name,authors.url,authors.paperCount")//,citations.title,citations.abstract,author.url,author.paperCount
                        .build())
                .retrieve()
                .bodyToMono(PaperDetailsDTOs.PaperDetailsResponse.class);

    }






}

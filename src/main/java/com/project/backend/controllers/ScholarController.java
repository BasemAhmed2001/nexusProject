package com.project.backend.controllers;


import com.project.backend.DTOs.DTOs;
import com.project.backend.DTOs.PaperDTO;
import com.project.backend.DTOs.PaperDetailsDTOs;
import com.project.backend.DTOs.SearchResponseDTO;
import com.project.backend.services.ScholarService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/paper")
public class ScholarController {

    ScholarService scholarService;

    public ScholarController(ScholarService scholarService) {
        this.scholarService = scholarService;
    }
    @GetMapping("/search")
    public Mono<SearchResponseDTO> searchPaper(@RequestParam(required = true) String q,
                                               @RequestParam(defaultValue = "10", required = false) int limit,
                                               @RequestParam(defaultValue = "0", required = false) int offset) {
        return scholarService.searchPapers(q,  limit, offset);
    }


    @GetMapping("/snippet/search")
    public Mono<DTOs.SnippetSearchResponse> searchPaper(@RequestParam(required = true) String q,
                                                        @RequestParam(defaultValue = "10", required = false) int limit) {
        return scholarService.snippetSearch(q,  limit);
    }


    @GetMapping("/search/{id}")
    public Mono<PaperDetailsDTOs.PaperDetailsResponse> searchPaper(@PathVariable String id) {
        return scholarService.paperSearchById(id);
    }










}

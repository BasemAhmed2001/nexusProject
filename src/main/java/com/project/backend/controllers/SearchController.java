//package com.project.backend.controllers;
//
//import com.project.backend.services.SerpApiService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//
//@RestController
//@RequestMapping("/api/search")
//public class SearchController {
//
//    private final SerpApiService serpApiService;
//
//    public SearchController(SerpApiService serpApiService) {
//        this.serpApiService = serpApiService;
//    }
//
//    @GetMapping
//    public Mono<String> search(@RequestParam String q) {
//        return serpApiService.search(q);
//    }
//}
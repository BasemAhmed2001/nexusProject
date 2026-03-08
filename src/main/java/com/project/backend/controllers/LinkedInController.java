package com.project.backend.controllers;


import com.project.backend.DTOs.TheirStackResponseDTOs;
import com.project.backend.services.TheirStackService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("api/v1/linkedin")
public class LinkedInController {

    private final TheirStackService  theirStackService;

    public LinkedInController(TheirStackService theirStackService) {
        this.theirStackService = theirStackService;
    }


    @GetMapping
    public Mono<List<TheirStackResponseDTOs.JobFound>> getLatestJobs() {
        String link = "https://www.linkedin.com/company/thecodesoft/";

        return theirStackService.getLinkedInJobsByCompanyLink(link);

    }









}

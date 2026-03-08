package com.project.backend.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class TheirStackResponseDTOs {


    // JobFound.java
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class JobFound {
        private Long id;

        @JsonProperty("job_title")
        private String jobTitle;

        private String url;

        @JsonProperty("date_posted")
        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate datePosted;

        private String company;
    }
    // CompanyJobsData.java
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CompanyJobsData {

        @JsonProperty("jobs_found")
        private List<JobFound> jobsFound;
    }
    // JobSearchResponse.java
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class JobSearchResponse {
        private List<CompanyJobsData> data;
    }





}

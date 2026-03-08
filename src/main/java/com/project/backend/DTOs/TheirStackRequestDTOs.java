package com.project.backend.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public class TheirStackRequestDTOs {


    // OrderBy.java
    @Data
    @Builder
    public static class OrderBy {
        private boolean desc;
        private String field;
    }

    // JobFilters.java
    @Data
    @Builder
    public static class JobFilters {
        @JsonProperty("posted_at_max_age_days")
        private int postedAtMaxAgeDays;
    }

    // CompanySearchRequest.java
    @Data
    @Builder
    public static class CompanySearchRequest {

        @JsonProperty("include_total_results")
        private boolean includeTotalResults;

        @JsonProperty("order_by")
        private List<OrderBy> orderBy;

        @JsonProperty("company_linkedin_url_or")
        private List<String> companyLinkedinUrlOr;

        @JsonProperty("job_filters")
        private JobFilters jobFilters;

        @JsonProperty("expand_technology_slugs")
        private List<String> expandTechnologySlugs;

        private int page;
        private int limit;

        @JsonProperty("blur_company_data")
        private boolean blurCompanyData;
    }













}

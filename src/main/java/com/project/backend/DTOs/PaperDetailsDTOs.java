package com.project.backend.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

public class PaperDetailsDTOs {


    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PaperDetailsResponse {
        private String paperId;
        private String title;
        private String url;
        @JsonProperty("abstract")
        private String abstractText;
        private String venue;
        private Integer year;
        private Integer citationCount;
        private Integer referenceCount;
        private Boolean isOpenAccess;

        private List<AuthorDTO> authors;
        private OpenAccessPdfDTO openAccessPdf;
        private TldrDTO tldr;
        private List<String> fieldsOfStudy;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AuthorDTO {
            private String authorId;
            private String name;
            private String url;
        }

        @Data
        public static class OpenAccessPdfDTO {
            private String url;
            private String status;
        }

        @Data
        public static class TldrDTO {
            private String text;
        }
    }


}

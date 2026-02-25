package com.project.backend.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;


public class DTOs {



    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SnippetSearchResponse {
        private List<SnippetResult> data;
        private String retrievalVersion;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SnippetResult {
            private SnippetDetails snippet;
            private Double score;
            private PaperSnippetDTO paper;
        }

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class SnippetDetails {
            private String text;
            private String snippetKind;
            private String section;
            private Offset snippetOffset;
            private Annotations annotations;
        }

        @Data
        public static class PaperSnippetDTO {
            private String corpusId;
            private String title;
            private List<String> authors;
            private OpenAccessInfo openAccessInfo;
        }

        @Data
        public static class OpenAccessInfo {
            private String license;
            private String status;
            private String disclaimer;
        }

        @Data
        public static class Annotations {
            private List<Offset> sentences;
            private List<RefMention> refMentions;
        }

        @Data
        public static class Offset {
            private Integer start;
            private Integer end;
        }

        @Data
        public static class RefMention {
            private Integer start;
            private Integer end;
            private String matchedPaperCorpusId;
        }
    }


}
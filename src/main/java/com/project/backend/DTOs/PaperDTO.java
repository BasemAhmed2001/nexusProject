package com.project.backend.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaperDTO {
    private String paperId;
    private String url;
    private String title;
    private String venue;
    private Integer year;
    @JsonProperty("abstract")
    private String paperAbstract;
    private List<AuthorDTO> authors;
    private ExternalIdsDTO externalIds;
}
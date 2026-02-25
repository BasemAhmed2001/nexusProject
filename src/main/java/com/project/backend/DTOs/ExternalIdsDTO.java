package com.project.backend.DTOs;

import lombok.Data;

@Data
public class ExternalIdsDTO {
    private String DOI;
    private String ArXiv;
    private String CorpusId;
}
package com.project.backend.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseDTO {
    private Integer total;
    private Integer offset;
    private Integer next;
    private List<PaperDTO> data;
}
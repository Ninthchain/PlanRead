package com.professional.backend.infrastructure.data.model.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class BookCreationDto {

    private String name;
    private String description;
    
    private UUID userId;
    private List<Long> tasks;
}

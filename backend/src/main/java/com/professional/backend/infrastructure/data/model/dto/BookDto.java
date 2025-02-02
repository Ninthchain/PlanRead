package com.professional.backend.infrastructure.data.model.dto;

import java.util.UUID;

import lombok.Data;
@Data
public class BookDto {
    
    private Long id;
    private String name;
    private String description;
    
    private UUID userId;
}

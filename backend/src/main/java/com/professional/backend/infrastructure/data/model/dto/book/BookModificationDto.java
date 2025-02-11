package com.professional.backend.infrastructure.data.model.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookModificationDto {
    private Long id;
    private String name;
    private String description;
}

package com.professional.backend.infrastructure.data.model.dto.book;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCreationDto implements Serializable {

    private String name;
    private String description;

    private UUID userId;
    private List<UUID> tasks;
    private MultipartFile file;
}

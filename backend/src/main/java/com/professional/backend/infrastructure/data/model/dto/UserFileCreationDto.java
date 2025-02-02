package com.professional.backend.infrastructure.data.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserFileCreationDto {

    private String name;
    private MultipartFile content;
}

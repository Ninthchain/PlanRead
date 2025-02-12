package com.professional.bot.data.dto;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {

    private Long id;
    private String name;
    private String description;

    private UUID userId;
    
    private List<UUID> tasks;
    private Long fileId;
}

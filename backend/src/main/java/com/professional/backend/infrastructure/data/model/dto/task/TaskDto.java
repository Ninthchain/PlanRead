package com.professional.backend.infrastructure.data.model.dto.task;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class TaskDto {
    private UUID id;
    private String name;
    private Short priorityId;
    private UUID ownerId;
    private List<Long> books;
    private List<Long> tags;
}

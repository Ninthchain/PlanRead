package com.professional.backend.infrastructure.data.model.dto.task;

import java.util.List;
import java.util.UUID;

public class TaskCreationDto {
    private String name;
    private Short priorityId;
    private UUID ownerId;
    private List<Long> books;
    private List<Long> tags;
}

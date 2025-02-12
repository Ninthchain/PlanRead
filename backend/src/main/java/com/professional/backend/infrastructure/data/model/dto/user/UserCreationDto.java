package com.professional.backend.infrastructure.data.model.dto.user;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationDto {
    
    private Long telegramId;
    private List<Long> books;
    private List<UUID> tasks;
}

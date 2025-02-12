package com.professional.bot.data.dto;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long telegramId;
    private Set<Long> books;
    private Set<UUID> tasks;
}

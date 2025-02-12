package com.professional.backend.infrastructure.data.model.dto.user;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.professional.backend.infrastructure.data.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long telegramID;
    private Set<Long> books;
    private Set<UUID> tasks;

    public UserDto(User user) {
        Set<UUID> tasks = user.getTasks().stream().distinct().map(task -> task.getId()).collect(Collectors.toSet());
        Set<Long> books = user.getBooks().stream().distinct().map(book -> book.getId()).collect(Collectors.toSet());
        this.setTelegramID(user.getTelegramId());
        this.setTasks(tasks);
        this.setBooks(books);
    }
}

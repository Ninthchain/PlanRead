package com.professional.backend.infrastructure.data.model.dto.book;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.professional.backend.infrastructure.data.model.entity.book.Book;

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

    private Long ownerTelegramId;

    private List<UUID> tasks;
    private Long fileId;

    public BookDto(Book book) {

        List<UUID> tasks = book.getTasks().stream().map(task -> task.getId()).collect(Collectors.toList());
        this.setId(book.getId());
        this.setName(book.getName());
        this.setOwnerTelegramId(book.getOwner().getTelegramId());
        this.setDescription(book.getDescription());
        this.setTasks(tasks);
        this.setFileId(book.getFile().getId());
    }
}

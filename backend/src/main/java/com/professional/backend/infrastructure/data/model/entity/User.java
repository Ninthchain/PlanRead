package com.professional.backend.infrastructure.data.model.entity;

import java.util.Set;
import java.util.UUID;

import com.professional.backend.infrastructure.data.model.entity.book.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "readers")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "telegram_username", nullable = false)
    private String username;

    @OneToMany
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = true)
    private Set<Book> books;

    @OneToMany
    @JoinColumn(name = "task_id", referencedColumnName = "id", nullable = true)
    private Set<Task> tasks;

}

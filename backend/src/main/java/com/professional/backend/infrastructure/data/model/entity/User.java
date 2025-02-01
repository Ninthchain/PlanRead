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
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

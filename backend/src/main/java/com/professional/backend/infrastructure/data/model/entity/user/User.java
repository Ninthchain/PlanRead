package com.professional.backend.infrastructure.data.model.entity.user;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "telegram_username", nullable = false)
    private String username;
/*
    TODO: Finish work with connecting between "books" and "tasks" tables with single user. The user must have independently tasks and books
    @OneToMany
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = true)
    private Set<Book> books;

    @OneToMany
    @JoinColumn(name = "task_id", referencedColumnName = "id", nullable = true)
    private Set<UserTask> tasks;
*/
}

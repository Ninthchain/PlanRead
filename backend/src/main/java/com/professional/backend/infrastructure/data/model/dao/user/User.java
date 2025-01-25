package com.professional.backend.infrastructure.data.model.dao.user;

import java.util.Set;
import java.util.UUID;

import com.professional.backend.infrastructure.data.model.dao.book.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "telegram_username", nullable = false)
    private String username;

    @OneToMany
    @JoinColumn(name = "book_id", referencedColumnName = "id", nullable = true)
    private Set<Book> books;
}

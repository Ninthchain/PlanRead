package com.professional.backend.infrastructure.data.model.dao.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @Column(name = "telegram_username")
    private String username;

    
}

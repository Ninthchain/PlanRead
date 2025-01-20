package com.professional.backend.model.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserTaskTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
}

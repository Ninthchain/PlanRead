package com.professional.backend.infrastructure.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.data.model.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {
    
}

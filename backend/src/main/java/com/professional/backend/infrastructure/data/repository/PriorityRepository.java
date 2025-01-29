package com.professional.backend.infrastructure.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.data.model.entity.task.Priority;

public interface PriorityRepository extends CrudRepository<Priority, Short> {
    
}

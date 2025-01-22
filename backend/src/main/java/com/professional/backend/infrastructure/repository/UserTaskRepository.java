package com.professional.backend.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.model.dao.task.Tag;
import com.professional.backend.infrastructure.model.dao.task.UserTask;

public interface UserTaskRepository extends CrudRepository<UserTask, UUID> {
    UserTask findByName(String name);
    UserTask findByTag(Tag tag);
}

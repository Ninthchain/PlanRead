package com.professional.backend.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.professional.backend.model.dao.UserTask;
import com.professional.backend.model.dao.UserTaskTag;

public interface UserTaskRepository extends CrudRepository<UserTask, UUID> {
    UserTask findByName(String name);
    UserTask findByTag(UserTaskTag tag);
}

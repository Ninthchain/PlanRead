package com.professional.backend.infrastructure.data.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.data.model.entity.task.Priority;
import com.professional.backend.infrastructure.data.model.entity.task.Tag;
import com.professional.backend.infrastructure.data.model.entity.task.UserTask;

import java.util.List;
import java.util.Set;


public interface UserTaskRepository extends CrudRepository<UserTask, UUID> {
    UserTask findByName(String name);
    List<UserTask> findByTags(Set<Tag> tags);
    List<UserTask> findByPriority(Priority priority);
    
}

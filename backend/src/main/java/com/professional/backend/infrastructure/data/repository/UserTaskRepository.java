package com.professional.backend.infrastructure.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.data.model.entity.task.Priority;
import com.professional.backend.infrastructure.data.model.entity.task.Tag;
import com.professional.backend.infrastructure.data.model.entity.task.UserTask;

import java.util.List;
import java.util.Set;


public interface UserTaskRepository extends CrudRepository<UserTask, UUID> {
    UserTask findByName(String name);
    List<UserTask> findByTags(Set<Tag> tags);
    /**
     * Gets from db tasks with certain priority
     * @param priority 
     * @return A list of tasks with certain priority 
     */
    List<UserTask> findByPriority(Priority priority);
    
    @Query(value = "SELECT e FROM tasks e WHERE e.priority = (SELECT MAX(e2.priority) FROM tasks e2)", nativeQuery = true)
    List<UserTask> findAllWithHighestPriority();

    @Query(value = "SELECT e FROM tasks e WHERE e.priority = (SELECT MIN(e2.priority) FROM tasks e2)", nativeQuery = true)
    List<UserTask> findAllWithLowestPriority();
}

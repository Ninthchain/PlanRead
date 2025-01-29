package com.professional.backend.infrastructure.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.data.model.entity.Priority;
import com.professional.backend.infrastructure.data.model.entity.Tag;
import com.professional.backend.infrastructure.data.model.entity.Task;

import java.util.List;
import java.util.Set;

public interface UserTaskRepository extends CrudRepository<Task, UUID> {
    Task findByName(String name);

    List<Task> findByTags(Set<Tag> tags);

    /**
     * Gets from db tasks with certain priority
     * 
     * @param priority
     * @return A list of tasks with certain priority
     */
    List<Task> findByPriority(Priority priority);

    @Query(value = "SELECT e FROM tasks e WHERE e.priority = (SELECT MAX(e2.priority) FROM tasks e2)", nativeQuery = true)
    List<Task> findAllWithHighestPriority();

    @Query(value = "SELECT e FROM tasks e WHERE e.priority = (SELECT MIN(e2.priority) FROM tasks e2)", nativeQuery = true)
    List<Task> findAllWithLowestPriority();
}

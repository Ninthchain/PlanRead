package com.professional.backend.infrastructure.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.data.model.entity.task.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

}

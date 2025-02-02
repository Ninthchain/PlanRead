package com.professional.backend.infrastructure.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.data.model.entity.book.UserFile;

public interface UserFileRepository extends CrudRepository<UserFile, Long> {

}

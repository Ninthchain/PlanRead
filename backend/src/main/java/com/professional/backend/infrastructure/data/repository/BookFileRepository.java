package com.professional.backend.infrastructure.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.professional.backend.infrastructure.data.model.entity.book.BookFile;

public interface BookFileRepository extends CrudRepository<BookFile, Long> {

}

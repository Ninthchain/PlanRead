package com.professional.backend.infrastructure.data.repository;

import com.professional.backend.infrastructure.data.model.entity.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}

package com.professional.backend.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.professional.backend.infrastructure.data.repository.BookFileRepository;
import com.professional.backend.infrastructure.data.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookFileRepository bookFileRepository;

    
}

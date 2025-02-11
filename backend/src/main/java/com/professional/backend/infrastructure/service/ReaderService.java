package com.professional.backend.infrastructure.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.professional.backend.exceptions.UserNotFoundException;
import com.professional.backend.infrastructure.data.model.dto.book.BookCreationDto;
import com.professional.backend.infrastructure.data.model.dto.book.BookModificationDto;
import com.professional.backend.infrastructure.data.model.entity.User;
import com.professional.backend.infrastructure.data.model.entity.UserFile;
import com.professional.backend.infrastructure.data.model.entity.book.Book;
import com.professional.backend.utils.UserFileProcessor;

import jakarta.transaction.Transactional;

import com.professional.backend.infrastructure.data.repository.BookRepository;

@Service
public class ReaderService {

    private Logger logger = LoggerFactory.getLogger(ReaderService.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StorageService userFileService;

    @Autowired
    private UserService userService;

    @Transactional
    public void createBook(BookCreationDto dto, MultipartFile entryFile)
            throws IOException, UserNotFoundException, NoSuchAlgorithmException {

        UserFile file;
        User user;
        Book book;
        String fileChecksum;

        user = userService.getUser(dto.getUserId());
        
        book = new Book();
        book.setName(dto.getName());
        book.setDescription(dto.getDescription());
        book.setOwner(user);

        fileChecksum = UserFileProcessor.getFileChecksum(entryFile.getBytes());

        try {
            file = userFileService.getFile(fileChecksum);
        } catch (IllegalStateException e) {
            file = new UserFile();
            file.setChecksum(fileChecksum);
            file.setContent(entryFile.getBytes());
            file.setExtensionName(UserFileProcessor.getExtensionName(entryFile.getName()));
            file.setName(UserFileProcessor.getFileNameWithoutExtension(entryFile.getName()));
        }

        book.setFile(file);
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getBook(Long bookId) throws IllegalStateException {

        Optional<Book> findBookQueryResult = bookRepository.findById(bookId);

        if (!findBookQueryResult.isPresent()) {

            throw new IllegalStateException(String.format("Book not found with specified id: %d", bookId));
        }
        return findBookQueryResult.get();
    }

    @Transactional
    public void changeBookInformation(BookModificationDto bookEditDto) throws IllegalStateException {

        Book book = getBook(bookEditDto.getId());
        book.setName(bookEditDto.getName());
        book.setDescription(bookEditDto.getDescription());
        bookRepository.save(book);
    }

    @Transactional
    public void setBookFile(Long bookId, Long fileId) throws IllegalStateException {

        UserFile bookFile;
        Book book = this.getBook(bookId);

        logger.info(String.format("Changing book file:\n\tBook ID: [%d]\n\tOld file: [%d]\n\tNew file: [%d]", bookId,
                book.getFile().getId(), fileId));
        logger.debug("Checking if %d file id equals to new file id");

        if (book.getFile().getId() == fileId) {

            logger.warn("The method has been invoked with the same fileId to change. ");
            logger.debug("Returning with expected result. Nothing was changed");
            logger.info("The file wasn't changed, the id's are equal");
            return;
        }

        bookFile = userFileService.getFile(fileId);
        book.setFile(bookFile);
    }

    @Transactional
    public void deleteBook(Long bookId, boolean isDelitionWithFile) throws IllegalStateException {
        Book book = this.getBook(bookId);

        if (isDelitionWithFile == true) {
            userFileService.deleteFile(book.getFile().getId());
        }

        bookRepository.deleteById(bookId);
    }
}

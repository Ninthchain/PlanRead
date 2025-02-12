package com.professional.backend.infrastructure.controller;

import org.springframework.web.bind.annotation.RestController;
import com.professional.backend.exceptions.UserNotFoundException;
import com.professional.backend.infrastructure.data.model.dto.book.BookCreationDto;
import com.professional.backend.infrastructure.data.model.dto.book.BookDto;
import com.professional.backend.infrastructure.data.model.dto.book.BookModificationDto;
import com.professional.backend.infrastructure.data.model.entity.book.Book;
import com.professional.backend.infrastructure.service.ReaderService;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private ReaderService readerService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        ResponseEntity<List<BookDto>> response;

        List<Book> books = readerService.getAllBooks();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {

            BookDto bookDto = new BookDto(book);
            bookDtos.add(bookDto);
        }
        response = new ResponseEntity<List<BookDto>>(bookDtos, HttpStatus.OK);

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable(name = "id") Long bookId) {
        ResponseEntity<BookDto> response;
        try {
            Book book = readerService.getBook(bookId);
            BookDto bookDto = new BookDto(book);
            response = new ResponseEntity<BookDto>(bookDto, HttpStatus.OK);
            return response;
        } catch (IllegalStateException e) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> createBook(@ModelAttribute BookCreationDto bookCreationDto) {
        try {
            readerService.createBook(bookCreationDto, bookCreationDto.getFile());
        } catch (NoSuchAlgorithmException | IOException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (UserNotFoundException e) {
            System.out.println("Huy");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage() + '\n' + e.toString(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(name = "id") Long bookId) {
        try {
            readerService.deleteBook(bookId, false);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfuly deleted book", HttpStatus.OK);
    }

    @PutMapping("/edit/")
    public ResponseEntity<String> requestMethodName(@RequestBody BookModificationDto bookModificationDto) {
        try {
            readerService.changeBookInformation(bookModificationDto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfuly changd book info", HttpStatus.OK);
    }

}

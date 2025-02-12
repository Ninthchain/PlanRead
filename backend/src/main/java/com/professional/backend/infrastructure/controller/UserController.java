package com.professional.backend.infrastructure.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.professional.backend.exceptions.UserNotFoundException;
import com.professional.backend.infrastructure.data.model.dto.user.UserCreationDto;
import com.professional.backend.infrastructure.data.model.dto.user.UserDto;
import com.professional.backend.infrastructure.data.model.entity.User;
import com.professional.backend.infrastructure.data.model.entity.book.Book;
import com.professional.backend.infrastructure.service.ReaderService;
import com.professional.backend.infrastructure.service.UserService;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ReaderService readerService;

    @GetMapping("/all")
    @Transactional
    public ResponseEntity<List<UserDto>> getAllUsers() {
        ResponseEntity<List<UserDto>> response;
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(user);
            userDtos.add(userDto);
        }
        response = new ResponseEntity<List<UserDto>>(userDtos, HttpStatus.OK);
        return response;
    }
    @GetMapping("/{telegramId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long telegramId)  {
        UserDto userDto;
        try {
            userDto = new UserDto(userService.getUser(telegramId));
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
    }
    @GetMapping("/search/telegram/{telegramId}")
    @Transactional
    public ResponseEntity<UserDto> getUserByTelegramId(@PathVariable Long telegramId)  {
         
        System.out.println("Huy");
        try {
            UserDto userDto = new UserDto(userService.getUser(Long.toString(telegramId)));
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/{userID}/library/append/{bookId}")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
    
    
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserCreationDto userDto) {
        
        User user = new User();
        Set<Book> books = new HashSet<>();
        
        user.setBooks(books);
        user.setTasks(new HashSet<>());
        try {
        userService.createUser(user);
        return new ResponseEntity<String>(HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}

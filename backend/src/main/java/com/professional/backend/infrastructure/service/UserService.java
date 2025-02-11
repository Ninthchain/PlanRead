package com.professional.backend.infrastructure.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.professional.backend.exceptions.UserNotFoundException;
import com.professional.backend.infrastructure.data.model.entity.User;
import com.professional.backend.infrastructure.data.model.entity.book.Book;
import com.professional.backend.infrastructure.data.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(UUID userId) throws UserNotFoundException {
        Optional<User> findUserQueryResult = userRepository.findById(userId);
        System.err.println("Huy user service");
        if(!findUserQueryResult.isPresent()) {

            throw new UserNotFoundException(userId);
        }

        return findUserQueryResult.get();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}

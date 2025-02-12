package com.professional.backend.infrastructure.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.professional.backend.exceptions.UserNotFoundException;
import com.professional.backend.infrastructure.data.model.entity.User;
import com.professional.backend.infrastructure.data.model.entity.book.Book;
import com.professional.backend.infrastructure.data.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(Long userId) throws IllegalStateException {
        Optional<User> findUserQueryResult = userRepository.findById(userId);
        System.err.println("Huy user service");
        if (!findUserQueryResult.isPresent()) {
            // FIXME: Write error msg
            throw new IllegalStateException();
        }

        return findUserQueryResult.get();
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    // public void appendLibrary(UUID userID, Long bookId) throws
    // UserNotFoundException {
    // User user = this.getUser(userID);

    // userRepository.save(user);
    // }

    public void createUser(User user) {
       try {
           this.getUser(user.getTelegramId());
       } catch (IllegalStateException e) {
            userRepository.save(user);
       }
    }
}

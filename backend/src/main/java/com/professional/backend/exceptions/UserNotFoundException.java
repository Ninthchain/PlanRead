package com.professional.backend.exceptions;

import java.util.UUID;

import org.springframework.lang.Nullable;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(Long userId) {
        super(String.format("The user with id: %s is not found.\n\t ",
                userId.toString()));
    }
}

package com.professional.backend.Exceptions;

import java.util.UUID;

import org.springframework.lang.Nullable;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(UUID userId) {
        super(String.format("The user with id: %s is not found.\n\t Additional info: \n\t\t %s",
                userId.toString()));
    }

    public UserNotFoundException(UUID userId, String additionalExceptionInfo) {
        super(String.format("The user with id: %s is not found.\n\t Additional info: \n\t\t %s", additionalExceptionInfo);
    }
}

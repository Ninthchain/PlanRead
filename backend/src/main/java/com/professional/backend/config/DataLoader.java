package com.professional.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.professional.backend.infrastructure.data.model.entity.User;
import com.professional.backend.infrastructure.data.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("asdas");
        userRepository.save(user);
    }

}

package com.example.project.config;

import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    final private UserRepository userRepository;

    TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail", "977777777", "123456");
        userRepository.saveAll(java.util.Arrays.asList(u1, u2));
    }
}

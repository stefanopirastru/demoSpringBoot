package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepo, UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {

            Role student = roleRepo.findByName("STUDENT");
            if (student == null) {
                student = roleRepo.save(new Role(null, "STUDENT"));
            }

            Role professor = roleRepo.findByName("PROFESSOR");
            if (professor == null) {
                professor = roleRepo.save(new Role(null, "PROFESSOR"));
            }

            if (userRepo.findByUsername("prof1").isEmpty()) {
                userRepo.save(new User(
                    null,
                    "prof1",
                    encoder.encode("password"),
                    true,
                    Set.of(professor)
                ));
            }

            if (userRepo.findByUsername("stud1").isEmpty()) {
                userRepo.save(new User(
                    null,
                    "stud1",
                    encoder.encode("password"),
                    true,
                    Set.of(student)
                ));
            }
        };
    }
}
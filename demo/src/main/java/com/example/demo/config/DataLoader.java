package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonRepository personRepository;

    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    	//eseguo solo se il db è vuoto
        if (personRepository.count() == 0) {
        	personRepository.save(new Person(null, "Mario Rossi", 30,"mariorossi@gmail.com"));
        	personRepository.save(new Person(null, "Luca Bianchi", 25,"lucabianchi@gmail.com"));
        	personRepository.save(new Person(null, "Stefano Pirastru", 37,"stefanopirastru@gmail.com"));
        };
    }
}
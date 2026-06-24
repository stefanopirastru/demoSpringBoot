package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data                   // genera getter, setter, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String email;
    
    public Person( String name, int age, String email) {
    	this.name = name;
    	this.age = age;
    	this.email = email;
    }

}
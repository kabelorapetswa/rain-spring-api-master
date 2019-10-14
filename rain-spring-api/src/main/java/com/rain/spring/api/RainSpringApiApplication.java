package com.rain.spring.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rain.spring.api.model.Student;
import com.rain.spring.api.repository.StudentRepository;


@SpringBootApplication
public class RainSpringApiApplication implements CommandLineRunner{

	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RainSpringApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.save(new Student(11,"leon nortje",50d));
		studentRepository.save(new Student(12,"Kabelo Rapetswa",58d));	
		studentRepository.save(new Student(13,"Frans",70d));	
		studentRepository.save(new Student(14,"Rain",90d));	
		studentRepository.save(new Student(15,"Peter",69d));	
	}

}
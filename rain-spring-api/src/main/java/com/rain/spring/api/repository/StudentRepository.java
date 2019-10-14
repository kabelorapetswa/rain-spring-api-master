package com.rain.spring.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rain.spring.api.model.Student;
public interface StudentRepository extends JpaRepository<Student, Integer>{

}

package com.rain.spring.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rain.spring.api.model.Student;
import com.rain.spring.api.repository.StudentRepository;


@RestController
@RequestMapping("/")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/allstudents")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") Integer id) {

		
		Optional<Student> optional = studentRepository.findById(id);

		if (optional.isPresent()) {
			Student student = studentRepository.getOne(id);
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Student student) {
		try {
			studentRepository.save(student);
		}catch(Exception e) {
			return new ResponseEntity<String>("Enter valid input ", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Succesfully added", HttpStatus.OK);
	}
	
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		try {
			studentRepository.deleteById(id);
		} catch (Exception e) {
			return new ResponseEntity<String>("student not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("student is deleted", HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Optional<Student> optional = studentRepository.findById(student.getStudentId());
		if (optional.isPresent()) {
			Student st = optional.get();
			st.setStudentName(student.getStudentName());
			st.setStudentModuleName(student.getStudentModuleName());
			st.setStudentMark(student.getStudentMark());
			studentRepository.save(st);
			return new ResponseEntity<Student>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Student>(HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	@PatchMapping("/student/{id}")
	public ResponseEntity<Student> partialUpdate(@RequestBody Student student, @PathVariable("id") Integer id) {
	     
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
		     student = optional.get();
		     student.setStudentName(student.getStudentName());
		     student.setStudentModuleName(student.getStudentModuleName());
		     student.setStudentMark(student.getStudentMark());
		     studentRepository.save(student);
		     return new ResponseEntity<Student>(optional.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	
	
	
}

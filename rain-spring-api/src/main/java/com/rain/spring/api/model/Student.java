package com.rain.spring.api.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
	
	@Id
	private Integer studentId;
	private String studentName;
	private String studentModuleName;
	private Double studentMark;
	
	public Student() {
		
	}
	public Student(Integer studentId,String studentName,Double studentMark) {
		this.studentId= studentId;
		this.studentName= studentName;
		this.studentModuleName = "Spring API";
		this.studentMark= studentMark;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Double getStudentMark() {
		return studentMark;
	}
	public void setStudentMark(Double studentMark) {
		this.studentMark= studentMark;
	}
	public String getStudentModuleName() {
		return studentModuleName;
	}
	public void setStudentModuleName(String studentModuleName) {
		this.studentModuleName = studentModuleName;
	}
	
}

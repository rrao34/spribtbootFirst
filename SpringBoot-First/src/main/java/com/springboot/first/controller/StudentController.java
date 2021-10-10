package com.springboot.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.bean.StudentBean;
import com.springboot.first.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	

	@GetMapping(path = "/")
	public String getStudentTest() {
		return "Hi, I'm the new Student here,,,";
	}

	@GetMapping(path = "/students")
	public List<StudentBean> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping(path = "/students/{id}")
	public  StudentBean getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@PostMapping(value="/newstudent")
	public void addNewStudent(@Validated @RequestBody StudentBean newStudent) {
		studentService.addNewStudent(newStudent);
	}
	
	@DeleteMapping(path = "/students/{id}")
	public  void deleteStudentById(@PathVariable int id) {
		studentService.deleteStudentById(id);
	}

}

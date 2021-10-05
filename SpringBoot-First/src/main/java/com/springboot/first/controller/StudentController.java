package com.springboot.first.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.bean.StudentBean;
import com.springboot.first.exception.RecordNotFoundException;

@RestController
public class StudentController {

	static List<StudentBean> students = new ArrayList<>();

	static {
		students.add(new StudentBean(1, "John", "Milano"));
		students.add(new StudentBean(2, "Marko", "Bologna"));
		students.add(new StudentBean(3, "Tim", "Verona"));

	}

	@GetMapping(path = "/")
	public String getStudentTest() {
		return "Hi, I'm the new Student here,,,";
	}

	@GetMapping(path = "/students")
	public static List<StudentBean> getStudents() {
		return students;
	}

	@GetMapping(path = "/students/{id}")
	public static StudentBean getStudents(@PathVariable int id) throws RecordNotFoundException {
		Optional<StudentBean> student = students.stream().filter(s -> (s.getId() == id)).findFirst();
		if (student.isPresent()) {
			return student.get();
		}
		 throw new RecordNotFoundException("Student not found1");
	}

}

package com.springboot.first.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping(value = "/newstudent")
	public ResponseEntity<Object> addNewStudent(@Validated @RequestBody StudentBean newStudent) {
		studentService.addNewStudent(newStudent);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newStudent.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/students/{id}")
	public  void deleteStudentById(@PathVariable int id) {
		studentService.deleteStudentById(id);
	}
	
	//HATEOAS
	@GetMapping(path = "/studentsHATEOAS/{id}")
	public  RepresentationModel getstudentsHATEOASById(@PathVariable int id) {
		StudentBean student = studentService.getStudentById(id);
		
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getStudents()).withRel("All-Students");
		
		List<Link> links = new ArrayList<>();
		links.add(link);
		
		RepresentationModel<?> collection = CollectionModel.of(student, links);
		
		return collection;
	}

}

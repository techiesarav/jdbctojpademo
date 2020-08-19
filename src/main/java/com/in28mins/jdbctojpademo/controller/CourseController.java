package com.in28mins.jdbctojpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.jdbctojpademo.jpa.CourseRepository;
import com.in28mins.jdbctojpademo.model.Course;

@RestController
public class CourseController {

	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseRepository.findAll();
	}
	
	@PostMapping("/courses")
	public Course saveBook(@RequestBody Course course) {
		return courseRepository.save(course);
	}
}

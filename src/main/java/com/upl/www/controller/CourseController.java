package com.upl.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upl.www.model.Course;
import com.upl.www.service.CourseService;

import jakarta.persistence.PostUpdate;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course) {
		
		return courseService.addCourse(course);
	}
	
	@PutMapping("/update/{course_id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Integer course_id, @RequestBody Course course){
		
		return courseService.updateCourse(course_id, course);
	}
}

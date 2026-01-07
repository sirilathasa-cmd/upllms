package com.upl.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upl.www.model.Course;
import com.upl.www.model.CourseEditHistory;
import com.upl.www.repo.CourseEditHistoryRepo;
import com.upl.www.repo.CourseRepo;

@Service
public class CourseService {
	
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	CourseEditHistoryRepo courseEditHistoryRepo;
	
	public Course addCourse(Course course) {
		
		return courseRepo.save(course); 
		
	}
	
	public ResponseEntity<Course> updateCourse(Integer course_id, Course course) {
		
		if(courseRepo.existsById(course_id)) {
			
			Course existingCourse = courseRepo.findById(course_id).get();
			existingCourse.setTitle(course.getTitle());
			existingCourse.setDescription(course.getDescription());
			existingCourse.setInstructor_id(course.getInstructor_id());
			existingCourse.setStatus(course.getStatus());
			
			courseRepo.save(existingCourse);
			
			//updating the course edit history as course is updated
			CourseEditHistory courseEditHistory = new CourseEditHistory();
			
			courseEditHistory.setCourse_id(course_id);
			courseEditHistory.setInstructor_id(course.getInstructor_id());
			courseEditHistory.setChanges(course.getDescription());
			
			courseEditHistoryRepo.save(courseEditHistory);
			return new ResponseEntity<>(existingCourse, HttpStatus.OK);
		}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

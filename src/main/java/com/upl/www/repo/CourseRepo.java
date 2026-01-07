package com.upl.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upl.www.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

}

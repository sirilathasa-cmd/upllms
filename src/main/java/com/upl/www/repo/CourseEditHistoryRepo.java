package com.upl.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upl.www.model.CourseEditHistory;

public interface CourseEditHistoryRepo extends JpaRepository<CourseEditHistory, Integer>{

}

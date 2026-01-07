package com.upl.www.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upl.www.model.Course;
import com.upl.www.model.CourseEditHistory;
import com.upl.www.model.Tutorial;
import com.upl.www.model.TutorialEditHistory;
import com.upl.www.repo.CourseRepo;
import com.upl.www.repo.TutorialEditHistoryRepo;
import com.upl.www.repo.TutorialRepo;

@Service
public class TutorialService {
	
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	TutorialRepo tutorialRepo;
	
	@Autowired
	TutorialEditHistoryRepo tutorialEditHistoryRepo;
	
	
	public Tutorial addTutorial(Tutorial tutorial) {
		return tutorialRepo.save(tutorial);
	}
	
	public List<Tutorial> getTutorialsByCourseId(Integer course_id){
		
		List<Tutorial> listTutorials = tutorialRepo.findAll();
		return listTutorials.stream().
				filter(tutorial->tutorial.getCourse_id().equals(course_id))
				.collect(Collectors.toList());
	}
	
	public ResponseEntity<Tutorial> updateTutorial(Integer tutorial_id, Tutorial tutorial) {
		
		if(tutorialRepo.existsById(tutorial_id)) {
			
			Tutorial existingTutorial = tutorialRepo.findById(tutorial_id).get();
			existingTutorial.setTitle(tutorial.getTitle());
			existingTutorial.setContent(tutorial.getContent());
			existingTutorial.setYoutube_link(tutorial.getYoutube_link());
			
			tutorialRepo.save(existingTutorial);
			
			//updating the tutorial edit history as tutorial is updated
			TutorialEditHistory tutorialEditHistory = new TutorialEditHistory();

			//to get the existing instructor id
			Course existingCourse = courseRepo.findById(existingTutorial.getCourse_id()).get();
			
			tutorialEditHistory.setTutorial_id(tutorial_id);
			tutorialEditHistory.setInstructor_id(existingCourse.getInstructor_id());
			tutorialEditHistory.setChanges(tutorial.getContent());
			
			tutorialEditHistoryRepo.save(tutorialEditHistory);
			return new ResponseEntity<>(existingTutorial, HttpStatus.OK);
		}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}

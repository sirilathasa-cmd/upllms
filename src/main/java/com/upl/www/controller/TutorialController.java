package com.upl.www.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upl.www.model.Course;
import com.upl.www.model.Tutorial;
import com.upl.www.service.TutorialService;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {

	@Autowired
	TutorialService tutorialService;
	
	@PostMapping("/add")
	public Tutorial addTutorial(@RequestBody Tutorial  turorial) {
		
		return tutorialService.addTutorial(turorial);
	}
	
	@GetMapping("/{course_id}")
	public List<Tutorial> getTutorialsByCourseId(@PathVariable Integer course_id) {
		
		return tutorialService.getTutorialsByCourseId(course_id);
	}
	
	@PutMapping("/update/{tutorial_id}")
	public ResponseEntity<Tutorial> updateTutorial(@PathVariable Integer tutorial_id, @RequestBody Tutorial tutorial){
		
		return tutorialService.updateTutorial(tutorial_id, tutorial);
	}

}

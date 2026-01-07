package com.upl.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upl.www.model.Tutorial;

@Repository
public interface TutorialRepo extends JpaRepository<Tutorial, Integer>{

}

package com.abc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.model.Tutorial;
import com.abc.repository.TutorialRepository;

@Service
public class TutorialService {
	
	@Autowired
	private TutorialRepository tutorialRepository;

	public List<Tutorial> findAll() {
		return tutorialRepository.findAll();

	}
}

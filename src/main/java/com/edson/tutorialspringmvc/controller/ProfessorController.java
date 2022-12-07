package com.edson.tutorialspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edson.tutorialspringmvc.Professor;
import com.edson.tutorialspringmvc.ProfessorRepository;

@Controller
public class ProfessorController {
	@Autowired
	private ProfessorRepository professorRepository;

	@GetMapping("/professores")
	public ModelAndView index() {
	 
		List<Professor> professores =  this.professorRepository.findAll();
		ModelAndView mv = new ModelAndView("professores/index");
		mv.addObject("professores", professores);
		return mv;
	}
}

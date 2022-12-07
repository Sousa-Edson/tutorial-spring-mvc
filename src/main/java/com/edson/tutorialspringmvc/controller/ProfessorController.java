package com.edson.tutorialspringmvc.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edson.tutorialspringmvc.Professor;
import com.edson.tutorialspringmvc.model.StatusProfessor;

@Controller
public class ProfessorController {
	@GetMapping("/professores")
	public ModelAndView index() {
		Professor batman =  new Professor("Batman",new BigDecimal(20.500),StatusProfessor.ATIVO);
		batman.setId(1L);
		Professor coringa =  new Professor("coringa",new BigDecimal(57.500),StatusProfessor.APOSENTADO);
		coringa.setId(2L);
		Professor mulherMaravilha =  new Professor("mulherMaravilha",new BigDecimal(100.00),StatusProfessor.AFASTADO);
		mulherMaravilha.setId(3L);
		
		List <Professor> professores= Arrays.asList(batman,coringa,mulherMaravilha);
		ModelAndView mv = new ModelAndView("professores/index");
		mv.addObject("professores",professores);
		return mv;
	}
}

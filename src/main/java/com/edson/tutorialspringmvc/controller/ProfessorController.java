package com.edson.tutorialspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edson.tutorialspringmvc.dto.RequisicaoNovoProfessor;
import com.edson.tutorialspringmvc.model.Professor;
import com.edson.tutorialspringmvc.model.StatusProfessor;
import com.edson.tutorialspringmvc.repository.ProfessorRepository;

import jakarta.validation.Valid;

@Controller
public class ProfessorController {
	@Autowired
	private ProfessorRepository professorRepository;

	@GetMapping("/professores")
	public ModelAndView index() {
		List<Professor> professores = this.professorRepository.findAll();
		ModelAndView mv = new ModelAndView("professores/index");
		mv.addObject("professores", professores);
		return mv;
	}

	@GetMapping("professores/new")
	public ModelAndView nnew() {
		ModelAndView mv = new ModelAndView("professores/new");
		mv.addObject("listaStatusProfessor", StatusProfessor.values());
		return mv;
	}

	@PostMapping("/professores")
	public String create(@Valid RequisicaoNovoProfessor requisicao, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Professor professor = requisicao.toProfessor();
		System.out.println("\n************************TEM ERROS**********************\n");
			return "redirect:/professores/new";
		} else {
			Professor professor = requisicao.toProfessor();
			this.professorRepository.save(professor);
			return "redirect:/professores";
		}
	}
}

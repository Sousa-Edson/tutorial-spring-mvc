package com.edson.tutorialspringmvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView nnew(RequisicaoNovoProfessor requisicao) {
		ModelAndView mv = new ModelAndView("professores/new");
		mv.addObject("listaStatusProfessor", StatusProfessor.values());
		return mv;
	}

	@PostMapping("/professores")
	public ModelAndView create(@Valid RequisicaoNovoProfessor requisicao, BindingResult bindingResult) {
		System.out.println(requisicao);
		if (bindingResult.hasErrors()) {
			System.out.println("\n************************TEM ERROS**********************\n");
			ModelAndView mv = new ModelAndView("professores/new");

			mv.addObject("listaStatusProfessor", StatusProfessor.values());
			return mv;
		} else {
			Professor professor = requisicao.toProfessor();
			this.professorRepository.save(professor);
			return new ModelAndView("redirect:/professores/"+professor.getId());
		}
	}

	@GetMapping("/professores/{id}")
	public ModelAndView show(@PathVariable Long id) {
		System.out.println("**** ID: " + id);
		Optional<Professor> optional = this.professorRepository.findById(id);
		if (optional.isPresent()) {
			Professor professor = optional.get();
			ModelAndView mv = new ModelAndView("professores/show");
			mv.addObject(professor);
			return mv;
		} else {
			System.out.println("$$$$$$$$$$$ Não achou o professor");
			return new ModelAndView("redirect:/professores");
		}
	}
}
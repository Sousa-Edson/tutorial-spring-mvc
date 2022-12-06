package com.edson.tutorialspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/hello-servlet")
	public String hello(HttpServletRequest request) {
		request.setAttribute( "nome", "tetse de servetl");
		return "hello";
	}
	
	@GetMapping("/hello-model")
	public String hello2(Model model) {
		model.addAttribute("nome", "modelo");
		return "hello";
	}
	
	@GetMapping("/hello-final")
	public ModelAndView hello3(Model model) {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("nome", "model and view");
		return mv;
	}

}

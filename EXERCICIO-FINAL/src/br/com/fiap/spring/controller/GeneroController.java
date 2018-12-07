package br.com.fiap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.dao.GeneroDAO;
import br.com.fiap.spring.model.Genero;


@Controller
@RequestMapping("/genero")
public class GeneroController {
	
	//Colocar o Repository no DAO cap 03
	
	@Autowired
	private GeneroDAO dao;
	
	//cap 01, cap 04
	
	//cadastrar um gênero
	
	@GetMapping("cadastrar")	
	public ModelAndView cadastrar(Genero genero) {
		
		return new ModelAndView("genero/cadastro");
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(Genero genero, RedirectAttributes r) {
		dao.cadastrar(genero);
		r.addFlashAttribute("msg", "Genero Cadastrado com sucesso!");
		return new ModelAndView("redirect:/genero/cadastrar");
	}	

}

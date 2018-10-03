package br.com.fiap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.jpa.dao.CarroDAO;
import br.com.fiap.spring.model.Carro;

@Controller
@RequestMapping("carro")
public class CarroController {
	
	@Autowired
	private CarroDAO dao;
	
	
	@GetMapping("cadastrar")
	public String abrirForm() {
		return"convidado/cadastro";
	}
	
	public String processarForm(Carro carro, RedirectAttributes r) {
		dao.inserir(carro);
		r.addFlashAttribute("msg", "Carro cadastrado!");
		return "redirect:/convidado/cadastrar";
	}
	

}

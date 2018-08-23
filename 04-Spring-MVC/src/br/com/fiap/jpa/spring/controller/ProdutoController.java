package br.com.fiap.jpa.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.jpa.dao.ProdutoDAO;
import br.com.fiap.jpa.model.Produto;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	//Cadastrar um produto
	//Página com template
	

	@Autowired
	private ProdutoDAO dao;
	
	@GetMapping("cadastrar")
	public String abrirCadastro() {
		return "produto/cadastrar";
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView processarCadastro(Produto produto) {
		dao.inserir(produto);
		return new ModelAndView("produto/cadastrar").addObject("msg", "Produto cadastrado!");
	}
	
	// Listar
	
	
	@GetMapping("listar")
	public ModelAndView listar() {
		
		return new ModelAndView("produto/listar").addObject("produtos", dao.listar());
		
	}
	
	
	
	

}

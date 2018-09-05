package br.com.fiap.jpa.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.jpa.dao.ProdutoDAO;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.model.Produto;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	//Cadastrar um produto
	//P�gina com template
	

	@Autowired
	private ProdutoDAO dao;
	
	@GetMapping("cadastrar")
	public String abrirCadastro() {
		return "produto/cadastrar";
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarCadastro(Produto produto, RedirectAttributes r) {
		dao.inserir(produto);
		//Adiciona a mensagem no objeto que mant�m a infor��o ap�s o redirect
		r.addFlashAttribute("msg", "Produto cadastrado");
		//Redirect para uma URL e n�o uma pagina
		return new ModelAndView("redirect:/produto/cadastrar");
	}
	
	// Listar	
	
	@GetMapping("listar")
	public ModelAndView listar() {
		
		return new ModelAndView("produto/listar").addObject("produtos", dao.listar());
		
	}
	
	//Alterar
	
	@GetMapping("/editar/{id}")
	public ModelAndView abrirEdicao(@PathVariable("id") int id) {
		//Retorna a p�gina com os valores do produto para o formul�rio HTML
		return new ModelAndView("produto/edicao").addObject("produto", dao.pesquisar(id));
	}
	
	@PostMapping("/editar")
	@Transactional
	public ModelAndView editarProduto(Produto produto, RedirectAttributes r) {
		dao.atualizar(produto);
		r.addFlashAttribute("msg", "Produto atualizado");	
		return new ModelAndView("redirect:/produto/listar"); 
	}
	
	//N�o tem ID  no @PostMapping, pq n�o vai pela URL, vai pelo corpo da requisi��o
	@PostMapping("remover")
	@Transactional
	public String removerProduto(int codigo, RedirectAttributes r) {
		try {
			dao.remover(codigo);
			r.addFlashAttribute("msg", "Produto removido!");
		} catch (KeyNotFoundException e) {
			e.printStackTrace();
		}		
		return "redirect:/produto/listar";
	}
	
	@GetMapping("buscar")
	public ModelAndView buscarPorNome(String nomeProduto) {
		return new ModelAndView("produto/listar").addObject("produtos",dao.buscarPorNome(nomeProduto));
	}
	

}

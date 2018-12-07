package br.com.fiap.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.dao.GeneroDAO;
import br.com.fiap.spring.dao.JogoDAO;
import br.com.fiap.spring.exception.RegistroNaoEncontradoException;
import br.com.fiap.spring.model.Genero;
import br.com.fiap.spring.model.Jogo;
import br.com.fiap.spring.model.Plataforma;

@Controller
@RequestMapping("/jogo")
public class JogoController {
	
	//Colocar o Repository no DAO cap 03
	
	@Autowired
	private JogoDAO jogoDAO;
	
	@Autowired
	private GeneroDAO generoDAO;
	
	//cap 01, cap 04, cap 05	
	
	//GET retorna direto new ModelAndView("jogo/...").addObject("...", dao.método())
	
	//POST dao.[...] // r.addFlashAttribute // return new ModelAndView("redirect:/jogo/...");
	
	//cadastrar um jogo	 - retorna lista de generos e valores de plataformas
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar(Jogo jogo) {
		
		return new ModelAndView("jogo/cadastro")
				.addObject("generos", generoDAO.listar())
				.addObject("plataformas", Plataforma.values());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Jogo jogo, RedirectAttributes r,BindingResult b) {
		
		if(b.hasErrors()) {
			cadastrar(jogo);
		}		
		jogoDAO.cadastrar(jogo);
		r.addFlashAttribute("msg", "Jogo cadastrado com sucesso!");
		return new ModelAndView("redirect:/jogo/cadastrar");
	}
	
	//listar todos os jogos - retorna  lista de jogos, lista de generos - new Genero
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("jogo/lista")
				.addObject("jogos", jogoDAO.listar())
				.addObject("generos", generoDAO.listar())
				.addObject("genero", new Genero());
	}
	
	//atualizar - retorna pelo código do jogo a ser editado, lista de genero e valores de plataformas
	
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id")int codigo) {
		
		return new ModelAndView("jogo/edicao")
				.addObject("jogo", jogoDAO.buscar(codigo))
				.addObject("generos", generoDAO.listar())
				.addObject("plataformas", Plataforma.values());
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView editar(@Valid Jogo jogo, BindingResult b, RedirectAttributes r) {
		
		if(b.hasErrors()) {
			return new ModelAndView("jogo/edicao")
					.addObject("jogo", jogo)
					.addObject("generos", generoDAO.listar())
					.addObject("plataformas", Plataforma.values());
		}
		
		jogoDAO.atualizar(jogo);
		r.addFlashAttribute("msg", "Jogo atualizado com sucesso!");
		return new ModelAndView("redirect:/jogo/listar");
	}
	
	
	//remover
	
	@Transactional
	@PostMapping("remover")
	public ModelAndView remover(int codigo, RedirectAttributes r) {
		try {
			jogoDAO.excluir(codigo);
			r.addFlashAttribute("msg", "Jogo excluído com sucesso!");
		} catch (RegistroNaoEncontradoException e) {
			e.printStackTrace();
		}		
		return new ModelAndView("redirect:/jogo/listar");	
	}

	//disponível
	
	@Transactional
	@PostMapping("disponibilizar")
	public ModelAndView disponibilizar(int codigo, RedirectAttributes r) {
		jogoDAO.disponibilizar(codigo);
		r.addFlashAttribute("msg", "Jogo disponibilizado com sucesso!");
		return new ModelAndView("redirect:/jogo/listar");
	}
	//pesquisa de jogos por parte do nome do Jogo
	//retorna busca por Nome do jogo, lista de generos- new Genero
	
	@GetMapping("buscarPorNome")
	public ModelAndView buscarPorNome(String nome) {
		return new ModelAndView("jogo/lista")
				.addObject("jogos", jogoDAO.buscarPorNome(nome))
				.addObject("generos", generoDAO.listar())
				.addObject("genero", new Genero());
	}
	
	//um select para realizar a pesquisa de jogos por gênero. 
	//retorna busca por codigo, lista de genero - new Genero
	
	@GetMapping("buscarPorGenero")
	public ModelAndView buscarPorGenero(int codigo) {
		return new ModelAndView("jogo/lista")
				.addObject("jogos", jogoDAO.buscarPorGenero(codigo))
				.addObject("generos", generoDAO.listar())
				.addObject("genero", new Genero());		
				
	}
}

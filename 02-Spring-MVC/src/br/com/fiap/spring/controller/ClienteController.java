package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.spring.model.Cliente;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@GetMapping("cadastrar")
	public String abrirCadastro() {
		return "cliente/form"; //Pasta + P�gina JSP
	}
	
	@PostMapping("cadastrar")
	public ModelAndView processarCadastro(Cliente cliente) {
		System.out.println(cliente.getNome());
		System.out.println(cliente.getIdade());
		System.out.println(cliente.isCnh());
		System.out.println(cliente.getGenero());
		//Objeto de retorno (pasta + p�gina JSP)
		ModelAndView retorno = new ModelAndView("cliente/sucesso");
		//Valores que ser�o enviados para a p�gina
		retorno.addObject("cli",cliente);
		retorno.addObject("msg", "Cliente cadastrado!");
		return retorno;
	}
	
}






package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.spring.model.Pessoa;

@Controller
@RequestMapping("pessoa")
public class PessoaController {

	//Método para abrir a tela com o formulário de cadastro
	//URL: pessoa/cadastrar
	@GetMapping("cadastrar")
	public String abrirFormulario() {
		return "pessoa/form"; //Pasta e arquivo jsp
	}
	
	//Método que recebe as informações do formulário de cadastro
	@PostMapping("cadastrar")
	public String processarFormulario(Pessoa p) {
		System.out.println(p.getNome() + " " + p.getIdade() 
											+ " " + p.isAposentado());
		return "pessoa/form";
	}
	
}





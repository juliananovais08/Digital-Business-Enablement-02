package br.com.fiap.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//Método que atende a uma requisição
	@RequestMapping("/home")
	public String home() {
		//Retorna a view (pasta e arquivo)
		return "home/index";
	}
	
}

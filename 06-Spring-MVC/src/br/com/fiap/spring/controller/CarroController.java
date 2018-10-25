package br.com.fiap.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.jpa.dao.CarroDAO;
import br.com.fiap.jpa.dao.MarcaDAO;
import br.com.fiap.spring.model.Carro;
import br.com.fiap.spring.model.Combustivel;
import br.com.fiap.spring.model.Marca;

@Controller
@RequestMapping("carro")
public class CarroController {

	
	@Autowired
	private CarroDAO dao;	
	
	@Autowired
	private MarcaDAO marcaDao;    //pra lista de marca precida do DAO da Marca
	
	@GetMapping("listar")
		public ModelAndView listar() {
			return new ModelAndView("carro/lista").addObject("carro", dao.listar());
	}
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar(Carro carro) {
		List<Marca> lista = marcaDao.listar();
		return new ModelAndView("carro/form").addObject("marcas",lista).addObject("combustiveis", Combustivel.values()); //marcas - coloca assim no formulario
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Carro carro, BindingResult b, RedirectAttributes r) {
		if(b.hasErrors()) {
			return cadastrar(carro);
		}else {
			dao.inserir(carro);
			r.addFlashAttribute("msg", "Carro registrado!");
			return new ModelAndView("redirect:/carro/cadastrar"); //pra fazer a lista de marca tem que ser por model and view
		}
	
	}

}

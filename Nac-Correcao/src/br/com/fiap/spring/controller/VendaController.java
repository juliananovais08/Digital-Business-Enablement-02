package br.com.fiap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.dao.VendaDAO;
import br.com.fiap.spring.model.Venda;

@Controller
@RequestMapping("venda")
public class VendaController {
	
	@Autowired
	private VendaDAO dao;
	
	@Transactional
	@PostMapping("pagar")
	public String vender(int codigo) {
		dao.pagar(codigo);
		return "redirect:/venda/listar";
	}
	
	@GetMapping("buscar")
	public ModelAndView buscar(String nome) {
		return new ModelAndView("venda/lista")
			.addObject("vendas", dao.buscarPorCliente(nome));
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("venda/lista")
				.addObject("vendas", dao.listar());
	}

	@GetMapping("cadastrar")
	public String cadastrar(Venda venda) {
		return "venda/cadastrar";
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public String cadastrar(Venda venda, RedirectAttributes r) {
		dao.cadastrar(venda);
		r.addFlashAttribute("msg", "Venda registrada!");
		return "redirect:/venda/cadastrar";
	}
	
}

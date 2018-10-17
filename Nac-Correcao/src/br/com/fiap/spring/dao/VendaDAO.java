package br.com.fiap.spring.dao;

import java.util.List;

import br.com.fiap.spring.model.Venda;

public interface VendaDAO extends GenericDAO<Venda, Integer>{

	void pagar(int codigo);

	List<Venda> buscarPorCliente(String nome);

	
}

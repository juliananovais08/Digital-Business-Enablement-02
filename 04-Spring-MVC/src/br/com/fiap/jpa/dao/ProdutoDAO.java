package br.com.fiap.jpa.dao;

import java.util.List;

import br.com.fiap.jpa.model.Produto;

public interface ProdutoDAO extends GenericDAO<Produto, Integer>{
	
	public List<Produto> buscarPorNome(String nome);
}

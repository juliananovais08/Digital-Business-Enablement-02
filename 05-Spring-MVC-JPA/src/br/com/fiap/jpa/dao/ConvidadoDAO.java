package br.com.fiap.jpa.dao;

import java.util.List;

import br.com.fiap.spring.model.Convidado;

public interface ConvidadoDAO extends GenericDAO<Convidado, Integer>{

	void confirmar(int id);
	
	List<Convidado> pesquisarPor(String nome);
	
}
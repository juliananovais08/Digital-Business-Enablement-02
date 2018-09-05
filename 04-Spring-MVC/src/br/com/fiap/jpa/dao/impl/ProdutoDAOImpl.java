package br.com.fiap.jpa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.jpa.dao.ProdutoDAO;
import br.com.fiap.jpa.model.Produto;

@Repository
public class ProdutoDAOImpl extends GenericDAOImpl<Produto, Integer> implements ProdutoDAO{

	@Override
	public List<Produto> buscarPorNome(String nome) {
		
		return em.createQuery("from Produto p where upper(p.nome) like upper(:n)", Produto.class)
				.setParameter("n", "%"+nome+"%")
				.getResultList();
	}

	
}

package br.com.fiap.jpa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.jpa.dao.ConvidadoDAO;
import br.com.fiap.spring.model.Convidado;

@Repository
public class ConvidadoDAOImpl extends GenericDAOImpl<Convidado, Integer>
														implements ConvidadoDAO{

	@Override
	public void confirmar(int id) {
		Convidado convidado = pesquisar(id);
		convidado.setConfirmado(true);
		atualizar(convidado);
	}

	@Override
	public List<Convidado> pesquisarPor(String nome) {
		return em.createQuery("from Convidado "
				+ "where upper(nome) like upper(:n)",Convidado.class)
				.setParameter("n", "%"+nome+"%")
				.getResultList();
	}

}

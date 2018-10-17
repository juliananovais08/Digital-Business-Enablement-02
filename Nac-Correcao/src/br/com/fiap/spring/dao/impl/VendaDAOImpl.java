package br.com.fiap.spring.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import br.com.fiap.spring.dao.VendaDAO;
import br.com.fiap.spring.model.Venda;

@Repository
public class VendaDAOImpl extends GenericDAOImpl<Venda, Integer> implements VendaDAO{

	@Override
	public void pagar(int codigo) {
		Venda venda = buscar(codigo);
		venda.setPago(true);
		atualizar(venda);
	}

	@Override
	public List<Venda> buscarPorCliente(String nome) {
		return em.createQuery("from Venda where upper(cliente) like upper(:d)",Venda.class).setParameter("d", "%" + nome + "%").getResultList();
	}


}

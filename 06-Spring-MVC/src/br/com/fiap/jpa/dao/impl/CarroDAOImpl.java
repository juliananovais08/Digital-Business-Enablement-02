package br.com.fiap.jpa.dao.impl;

import org.springframework.stereotype.Repository;
import br.com.fiap.jpa.dao.CarroDAO;
import br.com.fiap.spring.model.Carro;

@Repository
public class CarroDAOImpl extends GenericDAOImpl<Carro, Integer>
														implements CarroDAO{

}

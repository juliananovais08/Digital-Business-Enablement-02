package br.com.fiap.jpa.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.jpa.dao.MarcaDAO;
import br.com.fiap.spring.model.Marca;

@Repository
public class MarcaDAOImpl extends GenericDAOImpl<Marca, Integer> implements MarcaDAO{

}

package br.com.fiap.banco;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.spring.model.Venda;

public class CarregaBanco {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = factory.createEntityManager();
		
		Venda[] vendas = { new Venda("Thiago", Calendar.getInstance(), false, "Teste", 1000),
							new Venda("Maria", Calendar.getInstance(), false, "Teste", 20),
							new Venda("Fernando", Calendar.getInstance(), false, "Teste", 300),
							new Venda("Fernanda", Calendar.getInstance(), false, "Teste", 4500),
							new Venda("Matheus", Calendar.getInstance(), false, "Teste", 90)};
		
		for (Venda venda : vendas) {
			em.persist(venda);
		}
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Prioridades cadastradas!");
		
		em.close();
		factory.close();
	}
	
}

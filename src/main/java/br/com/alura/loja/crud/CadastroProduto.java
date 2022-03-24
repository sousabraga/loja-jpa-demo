package br.com.alura.loja.crud;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;

public class CadastroProduto {
	
	private static final String PERSISTENCE_UNIT_NAME = "loja";

	public static void main(String[] args) {
		Categoria categoria = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi", "Muito legal", BigDecimal.valueOf(800), categoria);
		EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager entityManager = EntityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(categoria);
		entityManager.persist(celular);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}

}

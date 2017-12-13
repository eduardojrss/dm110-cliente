package br.inatel.pos.mobile.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.pos.mobile.dm110.entities.Cliente;

@Stateless
public class ClienteDAO {

	@PersistenceContext(unitName = "inventory")
	private EntityManager em;

	public void insert(Cliente cliente) {
		em.persist(cliente);
	}

	public List<Cliente> findAll() {
		return em.createQuery("from Cliente c", Cliente.class).getResultList();
	}

}

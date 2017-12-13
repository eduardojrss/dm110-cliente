package br.inatel.pos.mobile.dm110.ejb;

import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.pos.mobile.dm110.dao.ClienteDAO;
import br.inatel.pos.mobile.dm110.entities.Cliente;
import br.inatel.pos.mobile.dm110.interfaces.InventoryLocal;
import br.inatel.pos.mobile.dm110.interfaces.InventoryRemote;

@Stateless
@Local(InventoryLocal.class)
@Remote(InventoryRemote.class)
public class InventoryBean implements InventoryLocal, InventoryRemote {

	@EJB
	private ClienteDAO dao;

	@Override
	public void addNewCliente(String clienteName, String email) {
		Cliente cliente = new Cliente();
		cliente.setName(clienteName);
		cliente.setEmail(email);
		dao.insert(cliente);
	}

	@Override
	public String[] listClienteNames() {
		return dao.findAll()
				.stream()
				.map(Cliente::getName)
				.collect(Collectors.toList())
				.toArray(new String[0]);
	}

}

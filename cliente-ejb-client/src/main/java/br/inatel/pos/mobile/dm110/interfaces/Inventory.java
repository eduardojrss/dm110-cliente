package br.inatel.pos.mobile.dm110.interfaces;

public interface Inventory {

	void addNewCliente(String clienteName, String email);

	String[] listClienteNames();

}

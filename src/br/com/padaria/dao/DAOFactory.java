package br.com.padaria.dao;

import br.com.padaria.dao.impl.ClienteDAOImpl;

public final class DAOFactory
{

	public static final ClienteDAO createClienteDAO()
	{
		return new ClienteDAOImpl();
	}
}

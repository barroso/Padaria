package br.com.padaria.test;

import br.com.padaria.dao.ClienteDAO;
import br.com.padaria.dao.DAOFactory;
import br.com.padaria.dao.commons.HipersonicDB;
import br.com.padaria.model.Cliente;
import br.com.padaria.model.Cliente.Sexo;

public class ClienteTest
{

	public static void main(String[] args) throws Exception
	{
		HipersonicDB db = new HipersonicDB("bancohibernatedb");
		try
		{
			db.start();
			testCliente();

		} finally
		{
			db.finish();
		}
	}

	public static final void testCliente() throws Exception
	{
		ClienteDAO clienteDAO = DAOFactory.createClienteDAO();

		// lista todos os clientes
		System.out.println(clienteDAO.findAll());

		// cria clientes
		Cliente samuel = new Cliente("Samuel Santos", "111.111.111-11", Sexo.MASCULINO, "23/04/1976");
		Cliente izalmo = new Cliente("Izalmo Primo", "222.222.222-22", Sexo.MASCULINO, "10/04/1978");
		Cliente maria = new Cliente("Maria José da Silva", "333.333.333-33", Sexo.FEMININO, "10/09/1970");

		clienteDAO.addEntity(samuel);
		clienteDAO.addEntity(izalmo);
		clienteDAO.addEntity(maria);

		// lista todos os clientes
		System.out.println(clienteDAO.findAll());

		// atualiza um cliente
		Cliente cliente = clienteDAO.findById(1L);
		cliente.setNome("Samuel Silva");
		clienteDAO.updateEntity(cliente);

		// lista todos os clientes
		System.out.println(clienteDAO.findAll());

		// exclui um cliente
		cliente = clienteDAO.findById(3L);
		clienteDAO.removeEntity(cliente);

		// lista todos os clientes
		System.out.println(clienteDAO.findAll());

	}
}

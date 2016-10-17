package br.com.icamy.bo;

import java.util.Map;
import java.util.Random;

import br.com.icamy.beans.Cliente;
import br.com.icamy.dao.ClienteDAO;
import br.com.icamy.exceptions.UsuarioInvalidoException;

public class ClienteBO {
	private ClienteDAO clienteDAO;
	
	public ClienteBO() throws Exception {
		clienteDAO = new ClienteDAO();
	}
	
	public Cliente getRandom() throws Exception {
		Random rd = new Random();
		int cdCliente = rd.nextInt(10)+1;
		return clienteDAO.selectWhereCliente(cdCliente);
	}
	
	public Cliente login(Map<String, String> usuario) throws Exception {
		Cliente cliente = clienteDAO.login(usuario);

		if (cliente != null)
			return cliente;
		else
			throw new UsuarioInvalidoException();
	}

}

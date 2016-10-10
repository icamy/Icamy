package br.com.icamy.bo;

import java.util.Random;

import br.com.icamy.beans.Cliente;
import br.com.icamy.dao.ClienteDAO;

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

}

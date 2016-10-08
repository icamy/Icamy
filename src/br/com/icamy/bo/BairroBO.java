package br.com.icamy.bo;

import java.util.List;

import br.com.icamy.beans.Bairro;
import br.com.icamy.beans.Prestador;
import br.com.icamy.dao.BairroDAO;

public class BairroBO {
	private BairroDAO bairroDAO;

	public BairroBO() throws Exception {
		bairroDAO = new BairroDAO();
	}

	public List<Bairro> getByPrestador(Prestador p) throws Exception {
		return bairroDAO.selectWherePrestador(p);
	}
	
}

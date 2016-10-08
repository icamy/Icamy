package br.com.icamy.bo;

import java.util.List;

import br.com.icamy.beans.Prestador;
import br.com.icamy.dao.PrestadorDAO;
import br.com.icamy.exceptions.CodigoNuloException;

public class PrestadorBO {
	private PrestadorDAO prestadorDAO;

	public PrestadorBO() throws Exception {
		prestadorDAO = new PrestadorDAO();
	}

	public Prestador get(int codigo) throws Exception {
		if (codigo < 1)
			throw new CodigoNuloException("C�digo inv�lido");

		return prestadorDAO.get(codigo);
	}
	
	public List<Prestador> getAll() throws Exception {
		return prestadorDAO.getAll();
	}
	
	public List<Prestador> getPrestadoresDeServicosDe(int cdCategoria) throws Exception {
		if (cdCategoria < 1)
			throw new CodigoNuloException("Categoria inválida");

		return prestadorDAO.getPrestadoresDeServicosDe(cdCategoria);
	}

}

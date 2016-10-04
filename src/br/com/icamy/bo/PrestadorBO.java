package br.com.icamy.bo;

import java.util.List;

import br.com.icamy.beans.Prestador;
import br.com.icamy.dao.PrestadorDAO;
import br.com.icamy.exceptions.CodigoNuloException;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;

public class PrestadorBO {
	private PrestadorDAO prestadorDAO;

	public PrestadorBO() throws Exception {
		prestadorDAO = new PrestadorDAO();
	}

	public Prestador get(int codigo) throws Exception {
		if (codigo < 1)
			throw new CodigoNuloException("Código inválido");

		return prestadorDAO.get(codigo);
	}

}

package br.com.icamy.bo;

import java.util.List;

import br.com.icamy.beans.Oferta;
import br.com.icamy.dao.OfertaDAO;
import br.com.icamy.exceptions.CodigoNuloException;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;

public class OfertaBO {
	private OfertaDAO ofertaDAO;

	public OfertaBO() throws Exception {
		ofertaDAO = new OfertaDAO();
	}

	public Oferta get(int codigo) throws Exception {
		if (codigo < 1)
			throw new CodigoNuloException("Código inválido");

		return ofertaDAO.get(codigo);
	}

	public List<Oferta> getAll() throws Exception {
		List<Oferta> ofertas = ofertaDAO.getAll();

		if (ofertas.size() == 0)
			throw new RegistroNaoEncontradoException("Nenhum registro encontrado");

		return ofertas;
	}
}

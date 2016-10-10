package br.com.icamy.bo;

import java.util.List;

import br.com.icamy.beans.Oferta;
import br.com.icamy.beans.Prestador;
import br.com.icamy.dao.OfertaDAO;
import br.com.icamy.dao.PrestadorDAO;
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

		return ofertaDAO.selectWhereOferta(codigo);
	}

	public List<Oferta> getAll() throws Exception {
		List<Oferta> lstOfertas = ofertaDAO.selectAll();

		if (lstOfertas.size() == 0)
			throw new RegistroNaoEncontradoException("Nenhum registro encontrado");

		return lstOfertas;
	}
	
	public List<Oferta> getByPrestador(int codigo) throws Exception {
		
		Prestador p = new PrestadorDAO().selectWherePrestador(codigo);
		List<Oferta> lstOfertas = ofertaDAO.selectWherePrestador(p);

		if (lstOfertas.size() == 0)
			throw new RegistroNaoEncontradoException("Nenhum registro encontrado");

		return lstOfertas;
	}
}

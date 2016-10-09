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

	public List<Prestador> getAll() throws Exception {
		return prestadorDAO.selectAll();
	}
	
	public Prestador get(int codigo) throws Exception {
		if (codigo < 1)
			throw new CodigoNuloException("Código inválido");

		return prestadorDAO.selectWherePrestador(codigo);
	}
	
	public List<Prestador> getByCategoria(int cdCategoria) throws Exception {
		if (cdCategoria < 1)
			throw new CodigoNuloException("Categoria inválida");

		return prestadorDAO.selectWhereCategoria(cdCategoria);
	}
	
	public List<Prestador> getByServico(int cdServico) throws Exception {
		if (cdServico < 1)
			throw new CodigoNuloException("Servioç inválido");

		return prestadorDAO.selectWhereServico(cdServico);
	}
	
	public List<Prestador> getByBairro(String nmBairro) throws Exception {
		if (nmBairro == "")
			throw new CodigoNuloException("Bairro inválido");

		return prestadorDAO.selectWhereBairro(nmBairro);
	}
	
	public List<Prestador> getByServicoBairro(int cdServico, String nmBairro) throws Exception {
		if (cdServico < 1 || nmBairro.equals(""))
			throw new CodigoNuloException("Parâmetros inválidos (serviço e/ou bairro)");

		return prestadorDAO.selectWhereServicoBairro(cdServico, nmBairro);
	}

}

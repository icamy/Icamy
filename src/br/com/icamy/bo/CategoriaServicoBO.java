package br.com.icamy.bo;

import java.util.List;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.beans.Prestador;
import br.com.icamy.dao.CategoriaServicoDAO;

public class CategoriaServicoBO {
	private CategoriaServicoDAO categoriaDAO;
	
	public CategoriaServicoBO() throws Exception {
		categoriaDAO = new CategoriaServicoDAO();
	}
	
	public CategoriaServico get(int codigo) throws Exception {
		return categoriaDAO.selectWhereCategoria(codigo);
	}
	
	public List<CategoriaServico> getAll() throws Exception {
		return categoriaDAO.selectAll();
	}
	
	public List<CategoriaServico> getByPrestador(Prestador p) throws Exception {
		return categoriaDAO.selectWherePrestador(p);
	}
}
 
package br.com.icamy.bo;

import java.util.List;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.dao.CategoriaServicoDAO;

public class CategoriaServicoBO {
	private CategoriaServicoDAO dao;
	
	public CategoriaServicoBO() throws Exception {
		dao = new CategoriaServicoDAO();
	}
	
	public List<CategoriaServico> getAll() throws Exception {
		return dao.getAll();
	}
}
 
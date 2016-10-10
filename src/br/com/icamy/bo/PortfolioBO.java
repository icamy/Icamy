package br.com.icamy.bo;

import java.util.List;

import br.com.icamy.beans.Portfolio;
import br.com.icamy.beans.Prestador;
import br.com.icamy.dao.PortfolioDAO;

public class PortfolioBO {
	private PortfolioDAO portfolioDAO;
	
	public PortfolioBO() throws Exception {
    	portfolioDAO = new PortfolioDAO();
    }
	
	public List<Portfolio> getByPrestador(Prestador p) throws Exception {
		return portfolioDAO.selectWherePrestador(p);
	}

}

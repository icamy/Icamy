package br.com.icamy.bo;

import br.com.icamy.beans.Pagamento;
import br.com.icamy.dao.PagamentoDAO;

public class PagamentoBO {
	private PagamentoDAO pagamentoDAO;
	
	public PagamentoBO() throws Exception {
		pagamentoDAO = new PagamentoDAO();
	}
	
	public void put(Pagamento pagamento) throws Exception {
		pagamentoDAO.insert(pagamento);
	}

}

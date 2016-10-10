package br.com.icamy.bo;

import br.com.icamy.beans.Contratacao;
import br.com.icamy.dao.ContratacaoDAO;

public class ContratacaoBO {
	private ContratacaoDAO contratacaoDAO;
	
	public ContratacaoBO() throws Exception {
		contratacaoDAO = new ContratacaoDAO();
	}
	
	public int put(Contratacao contratacao) throws Exception {
		return contratacaoDAO.insert(contratacao);
	}
	
	public int getUltimoCodigo() throws Exception {
		return contratacaoDAO.selectMaxCodigo();
	}

}

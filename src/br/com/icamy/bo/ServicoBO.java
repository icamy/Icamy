package br.com.icamy.bo;

import br.com.icamy.beans.Servico;
import br.com.icamy.dao.ServicoDAO;
import br.com.icamy.exceptions.CodigoNuloException;

public class ServicoBO {
    private ServicoDAO servicoDAO;
    
    public ServicoBO() throws Exception {
        servicoDAO = new ServicoDAO();
    }
    
    public Servico get(int codigo) throws Exception {
        if (codigo <= 0)
            throw new CodigoNuloException();
        
        return servicoDAO.get(codigo);
    }

}

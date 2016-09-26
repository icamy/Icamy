package br.com.icamy.bo;

import java.util.List;

import br.com.icamy.beans.Servico;
import br.com.icamy.dao.ServicoDAO;
import br.com.icamy.exceptions.CodigoNuloException;
import br.com.icamy.exceptions.RegistroNaoEncontradoException;

public class ServicoBO {
    private ServicoDAO servicoDAO;
    
    public ServicoBO() throws Exception {
    	servicoDAO = new ServicoDAO();
    }
    
    public Servico get(int codigo) throws Exception {
        if (codigo <= 0)
            throw new CodigoNuloException("O código fornecido é inválido");

        return servicoDAO.get(codigo);
    }
    
    public List<Servico> getAll() throws Exception {
    	List<Servico> servicos = servicoDAO.getAll();
    	
    	if (servicos.size() == 0)
    		throw new RegistroNaoEncontradoException("Nenhum registro encontrado");
    	
    	return servicos;
    }

}

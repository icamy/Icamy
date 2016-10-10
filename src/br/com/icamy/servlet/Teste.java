package br.com.icamy.servlet;

import java.util.ArrayList;
import java.util.List;

import br.com.icamy.beans.AvaliacaoContratacao;
import br.com.icamy.beans.Cliente;
import br.com.icamy.beans.Contratacao;
import br.com.icamy.beans.Oferta;
import br.com.icamy.beans.PropostaAgendamento;
import br.com.icamy.dao.ContratacaoDAO;

public class Teste {

	public static void main(String[] args) {
		Oferta oferta = new Oferta();
		oferta.setCodigo(1);
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		List<PropostaAgendamento> lstPropostaAgendamento = new ArrayList<PropostaAgendamento>();
		List<AvaliacaoContratacao> lstAvaliacoesContratacao = new ArrayList<AvaliacaoContratacao>();
		Contratacao contratacao = new Contratacao(0, oferta, cliente, "", 999.00, '1', "", lstPropostaAgendamento, lstAvaliacoesContratacao);
		
		try {
			new ContratacaoDAO().insert(contratacao);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

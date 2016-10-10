package br.com.icamy.beans;

import java.util.List;

public class Contratacao {
	private int codigo;
	private Oferta oferta;
	private Cliente cliente;
	private String dataContratacao;
	private double valor;
	private char status;
	private String dataExecucao;
	private List<PropostaAgendamento> listaPropostasAgendamento;
	private List<AvaliacaoContratacao> listaAvaliacoesContratacao;
	
	public Contratacao(int codigo, Oferta oferta, Cliente cliente, String dataContratacao, 
			double valor, char status, String dataExecucao, 
			List<PropostaAgendamento> listaPropostaAgendamento, List<AvaliacaoContratacao> listaAvaliacoesContratacao) {
		this.codigo = codigo;
		this.oferta = oferta;
		this.cliente = cliente;
		this.dataContratacao = dataContratacao;
		this.valor = valor;
		this.status = status;
		this.dataExecucao = dataExecucao;
		this.listaPropostasAgendamento = listaPropostaAgendamento;
		this.listaAvaliacoesContratacao = listaAvaliacoesContratacao;
	}
	
	public Contratacao() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(String dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public List<PropostaAgendamento> getListaPropostasAgendamento() {
		return listaPropostasAgendamento;
	}

	public void setListaPropostasAgendamento(List<PropostaAgendamento> listaPropostasAgendamento) {
		this.listaPropostasAgendamento = listaPropostasAgendamento;
	}

	public List<AvaliacaoContratacao> getListaAvaliacoesContratacao() {
		return listaAvaliacoesContratacao;
	}

	public void setListaAvaliacoesContratacao(List<AvaliacaoContratacao> listaAvaliacoesContratacao) {
		this.listaAvaliacoesContratacao = listaAvaliacoesContratacao;
	}

}

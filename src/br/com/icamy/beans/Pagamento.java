package br.com.icamy.beans;

import java.util.List;

public class Pagamento {
	private int codigo;
	private Contratacao contratacao;
	private ModalidadePgto modalidadePgto;
	private String data;
	private double valor;
	private char status;
	private String codigoIdentificador;
	private List<RepasseComissao> listaRepasseComissoes;

	public Pagamento(int codigo, Contratacao contratacao, ModalidadePgto modalidadePgto,
			String data, double valor, char status, String codigoIdentificador, List<RepasseComissao> listaRepasseComissoes) {
		this.codigo = codigo;
		this.contratacao = contratacao;
		this.modalidadePgto = modalidadePgto;
		this.data = data;
		this.valor = valor;
		this.status = status;
		this.codigoIdentificador = codigoIdentificador;
		this.listaRepasseComissoes = listaRepasseComissoes;
	}
 	
 	public Pagamento() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Contratacao getContratacao() {
		return contratacao;
	}

	public void setContratacao(Contratacao contratacao) {
		this.contratacao = contratacao;
	}

	public ModalidadePgto getModalidadePgto() {
		return modalidadePgto;
	}

	public void setModalidadePgto(ModalidadePgto modalidadePgto) {
		this.modalidadePgto = modalidadePgto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public String getCodigoIdentificador() {
		return codigoIdentificador;
	}

	public void setCodigoIdentificador(String codigoIdentificador) {
		this.codigoIdentificador = codigoIdentificador;
	}

	public List<RepasseComissao> getListaRepasseComissoes() {
		return listaRepasseComissoes;
	}

	public void setListaRepasseComissoes(List<RepasseComissao> listaRepasseComissoes) {
		this.listaRepasseComissoes = listaRepasseComissoes;
	}
  
}

package br.com.icamy.beans;

import java.util.List;

public class Prestador extends Usuario {
	private char tipoPessoa;
	private long documento;
	private String apresentacao;
	private List<Bairro> bairro;
	private List<Portfolio> portfolio;
	
	public Prestador(int codigo, String nome, long telefone, String email, String senha, String nascimento,
			String urlFoto, char tipoPessoa, long documento, String apresentacao, List<Bairro> bairro, List<Portfolio> portfolio) {
		super(codigo, nome, telefone, email, senha, nascimento, urlFoto);
		this.tipoPessoa = tipoPessoa;
		this.documento = documento;
		this.apresentacao = apresentacao;
		this.bairro = bairro;
		this.portfolio = portfolio;
	}

	public Prestador() {
		super();
	}

	public char getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}
	
	public List<Bairro> getBairro() {
		return bairro;
	}

	public void setBairro(List<Bairro> bairro) {
		this.bairro = bairro;
	}

	public List<Portfolio> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(List<Portfolio> portfolio) {
		this.portfolio = portfolio;
	}

}

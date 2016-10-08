package br.com.icamy.beans;

public class Bairro {
	private int codigo;
	private String nome;
	private String regiao;

	public Bairro(int codigo, String nome, String regiao) {
		this.codigo = codigo;
		this.nome = nome;
		this.regiao = regiao;
	}
	
	public Bairro() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
}

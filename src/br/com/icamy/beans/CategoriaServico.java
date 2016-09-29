package br.com.icamy.beans;

public class CategoriaServico {
	private int codigo;
	private String nome;
	
	public CategoriaServico(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public CategoriaServico() {}
	
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

}

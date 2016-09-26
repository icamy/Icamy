package br.com.icamy.beans;

public class Categoria {
	private int codigo;
	private String nome;

	public Categoria(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

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

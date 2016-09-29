package br.com.icamy.beans;

public class ModalidadePgto {
	private int codigo;
	private String nome;
	
	public ModalidadePgto(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public ModalidadePgto() {}

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

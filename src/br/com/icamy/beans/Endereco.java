package br.com.icamy.beans;

public class Endereco {
	private int codigo;
	private Cep cep;
	private int numero;
	private String complemento;
	
	public Endereco(int codigo, Cep cep, int numero, String complemento) {
		this.codigo = codigo;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
	}
	
	public Endereco() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	

}

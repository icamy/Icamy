package br.com.icamy.beans;

public class Cep {
	private int codigo;
	private String logradouro;
	private Bairro bairro;
	
	public Cep(int codigo, String logradouro, Bairro bairro) {
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.bairro = bairro;
	}
	
	public Cep() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	
}

package br.com.icamy.beans;

import java.util.List;

public class Cliente extends Usuario {
	private long cpf;
	private char sexo;
	private List<Endereco> listaEnderecos;
	
	public Cliente(int codigo, String nome, long telefone, String email, String senha, String nascimento, long cpf,
			char sexo, List<Endereco> listaEnderecos) {
		super(codigo, nome, telefone, email, senha, nascimento);
		this.cpf = cpf;
		this.sexo = sexo;
		this.listaEnderecos = listaEnderecos;
	}

	public Cliente() {
		super();
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public List<Endereco> getListaEnderecos() {
		return listaEnderecos;
	}

	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}

}

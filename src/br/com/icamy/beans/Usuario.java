package br.com.icamy.beans;

public class Usuario {
	private int codigo;
	private String nome;
	private long telefone;
	private String email;
	private String senha;
	private String nascimento;
	
	public Usuario(int codigo, String nome, long telefone, String email, String senha, String nascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.nascimento = nascimento;
	}
	
	public Usuario() {}

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

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
}

package br.com.icamy.beans;

public class Prestador {
	private int codigo;
	private String nome;
	private char tipoPessoa;
	private long documento;
	private long telefone;
	private String email;
	private String senha;
	private String apresentacao;
	private String dataDeNascimento;

	public Prestador(int codigo, String nome, char tipoPessoa, long documento, long telefone, String email,
			String senha, String apresentacao, String dataDeNascimento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.documento = documento;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.apresentacao = apresentacao;
		this.dataDeNascimento = dataDeNascimento;
	}

	public Prestador() {
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

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}

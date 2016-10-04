package br.com.icamy.beans;

public class Prestador extends Usuario {
	private char tipoPessoa;
	private long documento;
	private String apresentacao;
	
	public Prestador(int codigo, String nome, long telefone, String email, String senha, String nascimento,
			char tipoPessoa, long documento, String apresentacao) {
		super(codigo, nome, telefone, email, senha, nascimento);
		this.tipoPessoa = tipoPessoa;
		this.documento = documento;
		this.apresentacao = apresentacao;
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
	
	
}

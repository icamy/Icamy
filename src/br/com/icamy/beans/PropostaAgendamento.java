package br.com.icamy.beans;

public class PropostaAgendamento {
	private int codigo;
	private char proponente;
	private String dataPostagem;
	private String dataSugerida;
	private String mensagem;
	private char status;
	
	public PropostaAgendamento(int codigo, char proponente, String dataPostaqem, String dataSugerida, String mensagem, char status) {
		this.codigo = codigo;
		this.proponente = proponente;
		this.dataPostagem = dataPostagem;
		this.dataSugerida = dataSugerida;
		this.mensagem = mensagem;
		this.status = status;
	}
	
	public PropostaAgendamento() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public char getProponente() {
		return proponente;
	}

	public void setProponente(char proponente) {
		this.proponente = proponente;
	}

	public String getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(String dataPostagem) {
		this.dataPostagem = dataPostagem;
	}

	public String getDataSugerida() {
		return dataSugerida;
	}

	public void setDataSugerida(String dataSugerida) {
		this.dataSugerida = dataSugerida;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

}

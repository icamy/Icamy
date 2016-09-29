package br.com.icamy.beans;

public class AvaliacaoContratacao {
	private int codigo;
	private String data;
	private int nota;
	private String comentario;
	
	public AvaliacaoContratacao(int codigo, String data, int nota, String comentario) {
		this.codigo = codigo;
		this.data = data;
		this.nota = nota;
		this.comentario = comentario;
	}
	
	public AvaliacaoContratacao() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}

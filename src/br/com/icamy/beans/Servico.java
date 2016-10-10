package br.com.icamy.beans;

import java.util.List;

public class Servico {
    private int codigo;
    private String nome;
    private char status;
    private List<Oferta> oferta;
	
    public Servico(int codigo, String nome, char status, List<Oferta> oferta) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.status = status;
		this.oferta = oferta;
	}

	public Servico() {
		super();
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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public List<Oferta> getOferta() {
		return oferta;
	}

	public void setOferta(List<Oferta> oferta) {
		this.oferta = oferta;
	}
	
}

package br.com.icamy.beans;

import java.util.List;

public class CategoriaServico {
	private int codigo;
	private String nome;
	private List<Servico> servico;
	
	public CategoriaServico(int codigo, String nome, List<Servico> servico) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.servico = servico;
	}

	public CategoriaServico() {
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

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}
	
}

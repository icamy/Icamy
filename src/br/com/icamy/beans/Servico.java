package br.com.icamy.beans;

public class Servico {
    private int codigo;
    private CategoriaServico categoriaServico;
    private String nome;
    private char status;
    private String descricao;
    
    public Servico(int codigo, CategoriaServico categoriaServico, String nome, char status, String descricao) {
    	this.codigo = codigo;
    	this.categoriaServico = categoriaServico;
    	this.nome = nome;
    	this.status = status;
    	this.descricao = descricao;
    }
    
    public Servico() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public CategoriaServico getCategoriaServico() {
		return categoriaServico;
	}

	public void setCategoriaServico(CategoriaServico categoriaServico) {
		this.categoriaServico = categoriaServico;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
  
}

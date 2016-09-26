package br.com.icamy.beans;

public class Servico {
    private int codigo;
    private Categoria categoria;
    private String nome;
    private boolean status;
    private String descricao;

    public Servico(int codigo, Categoria categoria, String nome, boolean status, String descricao) {
        super();
        this.codigo = codigo;
        this.categoria = categoria;
        this.nome = nome;
        this.status = status;
        this.descricao = descricao;
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
    
    public Categoria getCategoria() {
    	return categoria;
    }
    
    public void setCategoria(Categoria categoria) {
    	this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

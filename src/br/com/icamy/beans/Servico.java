package br.com.icamy.beans;

public class Servico {
  private int codigo;
  private String nome;
  private char status;
  private String descricao;

  public Servico(int codigo, String nome, char status, String descricao) {
    super();
    this.codigo = codigo;
    this.nome = nome;
    this.status = status;
    this.descricao = descricao;
  }

  public Servico() {
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

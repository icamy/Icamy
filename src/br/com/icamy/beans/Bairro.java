package br.com.icamy.beans;

public class Bairro {
  private int codigo;
  private Cidade cidade;
  private String nome;
  private String regiao;

  public Bairro(int codigo, Cidade cidade, String nome, String regiao) {
    super();
    this.codigo = codigo;
    this.cidade = cidade;
    this.nome = nome;
    this.regiao = regiao;
  }

  public Bairro() {
    super();
    // TODO Auto-generated constructor stub
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getRegiao() {
    return regiao;
  }

  public void setRegiao(String regiao) {
    this.regiao = regiao;
  }
}

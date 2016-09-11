package br.com.icamy.beans;

public class Portfolio {
  private int codigo;
  private String url;
  private String nome;

  public Portfolio(int codigo, String url, String nome) {
    super();
    this.codigo = codigo;
    this.url = url;
    this.nome = nome;
  }

  public Portfolio() {
    super();
    // TODO Auto-generated constructor stub
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}

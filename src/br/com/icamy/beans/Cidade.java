package br.com.icamy.beans;

public class Cidade {
  private int codigo;
  private String Cidade;

  public Cidade(int codigo, String cidade) {
    super();
    this.codigo = codigo;
    Cidade = cidade;
  }

  public Cidade() {
    super();
    // TODO Auto-generated constructor stub
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getCidade() {
    return Cidade;
  }

  public void setCidade(String cidade) {
    Cidade = cidade;
  }

}

package br.com.icamy.beans;

public class Oferta {
  private Prestador prestador;
  private Servico servico;
  private double valor;
  private String descricao;

  public Oferta(Prestador prestador, Servico servico, double valor, String descricao) {
    super();
    this.prestador = prestador;
    this.servico = servico;
    this.valor = valor;
    this.descricao = descricao;
  }

  public Oferta() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Prestador getPrestador() {
    return prestador;
  }

  public void setPrestador(Prestador prestador) {
    this.prestador = prestador;
  }

  public Servico getServico() {
    return servico;
  }

  public void setServico(Servico servico) {
    this.servico = servico;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}

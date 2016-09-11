package br.com.icamy.beans;

public class ItemPedido {
  private Cliente cliente;
  private Prestador prestador;
  private Servico servico;
  private Pedido pedido;
  private double valor;

  public ItemPedido(Cliente cliente, Prestador prestador, Servico servico, Pedido pedido, double valor) {
    super();
    this.cliente = cliente;
    this.prestador = prestador;
    this.servico = servico;
    this.pedido = pedido;
    this.valor = valor;
  }

  public ItemPedido() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
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

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }
}

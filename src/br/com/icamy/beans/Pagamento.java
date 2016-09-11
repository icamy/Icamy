package br.com.icamy.beans;

public class Pagamento {
  private int codigo;
  private Pedido pedido;
  private String dataPagamento;
  private String horaPagamento;
  private String metodo;
  private char status;
  private Comissao comissao;

  public Pagamento(int codigo, Pedido pedido, String dataPagamento, String horaPagamento, String metodo, char status,
      Comissao comissao) {
    super();
    this.codigo = codigo;
    this.pedido = pedido;
    this.dataPagamento = dataPagamento;
    this.horaPagamento = horaPagamento;
    this.metodo = metodo;
    this.status = status;
    this.comissao = comissao;
  }

  public Pagamento() {
    super();
    // TODO Auto-generated constructor stub
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public String getDataPagamento() {
    return dataPagamento;
  }

  public void setDataPagamento(String dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public String getHoraPagamento() {
    return horaPagamento;
  }

  public void setHoraPagamento(String horaPagamento) {
    this.horaPagamento = horaPagamento;
  }

  public String getMetodo() {
    return metodo;
  }

  public void setMetodo(String metodo) {
    this.metodo = metodo;
  }

  public char getStatus() {
    return status;
  }

  public void setStatus(char status) {
    this.status = status;
  }

  public Comissao getComissao() {
    return comissao;
  }

  public void setComissao(Comissao comissao) {
    this.comissao = comissao;
  }
}

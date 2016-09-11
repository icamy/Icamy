package br.com.icamy.beans;

public class Comissao {
  private Pagamento pagamento;
  private String dataOperacao;
  private double valorOperacao;

  public Comissao(Pagamento pagamento, String dataOperacao, double valorOperacao) {
    super();
    this.pagamento = pagamento;
    this.dataOperacao = dataOperacao;
    this.valorOperacao = valorOperacao;
  }

  public Comissao() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Pagamento getPagamento() {
    return pagamento;
  }

  public void setPagamento(Pagamento pagamento) {
    this.pagamento = pagamento;
  }

  public String getDataOperacao() {
    return dataOperacao;
  }

  public void setDataOperacao(String dataOperacao) {
    this.dataOperacao = dataOperacao;
  }

  public double getValorOperacao() {
    return valorOperacao;
  }

  public void setValorOperacao(double valorOperacao) {
    this.valorOperacao = valorOperacao;
  }
}

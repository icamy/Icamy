package br.com.icamy.beans;

public class Repasse {
  private Pagamento pagamento;
  private String dataOperacao;
  private double valorOperacao;
  private char status;

  public Repasse(Pagamento pagamento, String dataOperacao, double valorOperacao, char status) {
    super();
    this.pagamento = pagamento;
    this.dataOperacao = dataOperacao;
    this.valorOperacao = valorOperacao;
    this.status = status;
  }

  public Repasse() {
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

  public char getStatus() {
    return status;
  }

  public void setStatus(char status) {
    this.status = status;
  }
}

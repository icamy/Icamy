package br.com.icamy.beans;

import java.util.List;

public class Pedido {
  private int codigo;
  private String data;
  private double valor;
  private char status;
  private String dataExecucaoAgendada;
  private String dataExecucaoRealizada;
  private List<ItemPedido> itensPedido;

  public Pedido(int codigo, String data, double valor, char status, String dataExecucaoAgendada,
      String dataExecucaoRealizada, List<ItemPedido> itensPedido) {
    super();
    this.codigo = codigo;
    this.data = data;
    this.valor = valor;
    this.status = status;
    this.dataExecucaoAgendada = dataExecucaoAgendada;
    this.dataExecucaoRealizada = dataExecucaoRealizada;
    this.itensPedido = itensPedido;
  }

  public Pedido() {
    super();
    // TODO Auto-generated constructor stub
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public char getStatus() {
    return status;
  }

  public void setStatus(char status) {
    this.status = status;
  }

  public String getDataExecucaoAgendada() {
    return dataExecucaoAgendada;
  }

  public void setDataExecucaoAgendada(String dataExecucaoAgendada) {
    this.dataExecucaoAgendada = dataExecucaoAgendada;
  }

  public String getDataExecucaoRealizada() {
    return dataExecucaoRealizada;
  }

  public void setDataExecucaoRealizada(String dataExecucaoRealizada) {
    this.dataExecucaoRealizada = dataExecucaoRealizada;
  }

  public List<ItemPedido> getItensPedido() {
    return itensPedido;
  }

  public void setItensPedido(List<ItemPedido> itensPedido) {
    this.itensPedido = itensPedido;
  }
}

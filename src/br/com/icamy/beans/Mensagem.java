package br.com.icamy.beans;

public class Mensagem {
  private int codigo;
  private int remetente;
  private int destinatario;
  private String data;
  private String texto;

  public Mensagem(int codigo, int remetente, int destinatario, String data, String texto) {
    super();
    this.codigo = codigo;
    this.remetente = remetente;
    this.destinatario = destinatario;
    this.data = data;
    this.texto = texto;
  }

  public Mensagem() {
    super();
    // TODO Auto-generated constructor stub
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public int getRemetente() {
    return remetente;
  }

  public void setRemetente(int remetente) {
    this.remetente = remetente;
  }

  public int getDestinatario() {
    return destinatario;
  }

  public void setDestinatario(int destinatario) {
    this.destinatario = destinatario;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }
}

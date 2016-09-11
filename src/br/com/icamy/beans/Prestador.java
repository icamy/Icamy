package br.com.icamy.beans;

import java.util.List;

public class Prestador {
  private int codigo;
  private String nome;
  private int cpf;
  private String dataDeNascimento;
  private List<String> emails;
  private List<Integer> telefones;
  private List<Bairro> bairrosAtendidos;
  private List<Oferta> ofertas;

  public Prestador(int codigo, String nome, int cpf, String dataDeNascimento, List<String> emails,
      List<Integer> telefones, List<Bairro> bairrosAtendidos, List<Oferta> ofertas) {
    super();
    this.codigo = codigo;
    this.nome = nome;
    this.cpf = cpf;
    this.dataDeNascimento = dataDeNascimento;
    this.emails = emails;
    this.telefones = telefones;
    this.bairrosAtendidos = bairrosAtendidos;
    this.ofertas = ofertas;
  }

  public Prestador() {
    super();
    // TODO Auto-generated constructor stub
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getCpf() {
    return cpf;
  }

  public void setCpf(int cpf) {
    this.cpf = cpf;
  }

  public String getDataDeNascimento() {
    return dataDeNascimento;
  }

  public void setDataDeNascimento(String dataDeNascimento) {
    this.dataDeNascimento = dataDeNascimento;
  }

  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }

  public List<Integer> getTelefones() {
    return telefones;
  }

  public void setTelefones(List<Integer> telefones) {
    this.telefones = telefones;
  }

  public List<Bairro> getBairrosAtendidos() {
    return bairrosAtendidos;
  }

  public void setBairrosAtendidos(List<Bairro> bairrosAtendidos) {
    this.bairrosAtendidos = bairrosAtendidos;
  }

  public List<Oferta> getOfertas() {
    return ofertas;
  }

  public void setOfertas(List<Oferta> ofertas) {
    this.ofertas = ofertas;
  }
}

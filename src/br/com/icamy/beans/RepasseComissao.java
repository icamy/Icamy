package br.com.icamy.beans;

public class RepasseComissao {
	private int codigo;
	private String data;
	private double valor;
	private char status;
	
	public RepasseComissao(int codigo, String data, double valor, char status) {
		this.codigo = codigo;
		this.data = data;
		this.valor = valor;
		this.status = status;
	}
	
	public RepasseComissao() {}

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
	

}

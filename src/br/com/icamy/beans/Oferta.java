package br.com.icamy.beans;

public class Oferta {
	private int codigo;
	private String descricao;
	private double valor;
	private int execucaoEmMinutos;
	private int validadeEmDias;
	
	public Oferta(int codigo, String descricao, double valor, int execucaoEmMinutos, int validadeEmDias) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.execucaoEmMinutos = execucaoEmMinutos;
		this.validadeEmDias = validadeEmDias;
	}

	public Oferta() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getExecucaoEmMinutos() {
		return execucaoEmMinutos;
	}

	public void setExecucaoEmMinutos(int execucaoEmMinutos) {
		this.execucaoEmMinutos = execucaoEmMinutos;
	}

	public int getValidadeEmDias() {
		return validadeEmDias;
	}

	public void setValidadeEmDias(int validadeEmDias) {
		this.validadeEmDias = validadeEmDias;
	}
	
}

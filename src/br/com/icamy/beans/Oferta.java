package br.com.icamy.beans;

public class Oferta {
	private int codigo;
	private Prestador prestador;
	private Servico servico;
	private String titulo;
	private String descricao;
	private double valor;
	private int execucaoEmMinutos;
	private int validadeEmDias;

	public Oferta(int codigo, Prestador prestador, Servico servico, String titulo, String descricao,
			double valor, int execucaoEmMinutos, int validadeEmDias) {
		this.codigo = codigo;
		this.prestador = prestador;
		this.servico = servico;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.execucaoEmMinutos = execucaoEmMinutos;
		this.validadeEmDias = validadeEmDias;
	}
	
	public Oferta() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

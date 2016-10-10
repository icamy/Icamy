package br.com.icamy.beans;

public class Oferta {
	private int codigo;
	private String titulo;
	private String descricao;
	private double valor;
	private int execucaoEmMinutos;
	private int validadeEmDias;
	private String icone;
	
	public Oferta(int codigo, String titulo, String descricao, double valor, int execucaoEmMinutos, int validadeEmDias, String icone) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.execucaoEmMinutos = execucaoEmMinutos;
		this.validadeEmDias = validadeEmDias;
		this.icone = icone;
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

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}
}

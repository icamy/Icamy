package br.com.icamy.beans;

public class Oferta {
	private int codigo;
	private Prestador prestador;
	private Servico servico;
	private double valor;
	private String titulo;
	private String prazo;
	private String texto;

	public Oferta(int codigo, Prestador prestador, Servico servico, double valor, String titulo, String prazo,
			String texto) {
		super();
		this.codigo = codigo;
		this.prestador = prestador;
		this.servico = servico;
		this.valor = valor;
		this.titulo = titulo;
		this.prazo = prazo;
		this.texto = texto;
	}

	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}

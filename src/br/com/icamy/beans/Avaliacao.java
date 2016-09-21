package br.com.icamy.beans;

public class Avaliacao {
    private Cliente cliente;
    private Prestador prestador;
    private Servico servico;
    private Pedido pedido;
    private double nota;
    private String comentario;

    public Avaliacao(Cliente cliente, Prestador prestador, Servico servico, Pedido pedido, double nota,
            String comentario) {
        super();
        this.cliente = cliente;
        this.prestador = prestador;
        this.servico = servico;
        this.pedido = pedido;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Avaliacao() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

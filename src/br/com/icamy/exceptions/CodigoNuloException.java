package br.com.icamy.exceptions;

public class CodigoNuloException extends Exception {
    public CodigoNuloException(String message) {
        super(message);
    }
    
    public CodigoNuloException() {
        super("C�digo fornecido inv�lido");
    }
}

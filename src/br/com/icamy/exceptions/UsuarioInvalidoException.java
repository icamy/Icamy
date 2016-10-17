package br.com.icamy.exceptions;

public class UsuarioInvalidoException extends Exception {
	public UsuarioInvalidoException() {
		super("Usuário inválido ou não encontrado");
	}
	
	public UsuarioInvalidoException(String message) {
		super(message);
	}
}

package br.com.icamy.exceptions;

public class RegistroNaoEncontradoException extends Exception {
  public RegistroNaoEncontradoException(String s) {
    super(s);
  }
  
  public RegistroNaoEncontradoException() {
    super();
  }
}

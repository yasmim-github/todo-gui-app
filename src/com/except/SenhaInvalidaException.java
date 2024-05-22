package com.except;

public class SenhaInvalidaException extends Exception {
	public SenhaInvalidaException(String mensagem) {
		super(mensagem);
	}
}

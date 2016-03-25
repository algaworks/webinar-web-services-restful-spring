package com.algaworks.webinario.restful.service.exception;

public class ProdutoExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public ProdutoExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public ProdutoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}

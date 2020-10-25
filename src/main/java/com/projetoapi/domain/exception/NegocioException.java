package com.projetoapi.domain.exception;

public class NegocioException extends RuntimeException{

	/**
	 * RuntimeException - classe utilizada para erro da lógica de negócio.
	 * Atenção1: Esta classe está associada com a classe ApiExceptionHandler
	 * do pacote 'com.projetoapi.exceptionhandler'
	 * 
	 * Atenção2: por meio da associação da classe ApiExceptionHandler. Esta 
	 * classe pode lançar um retorno com status de erro. Para mais informação
	 * veja a classe ApiExceptionHandler método handleNegocio() .
	 */
	private static final long serialVersionUID = 1L;

	public NegocioException(String message) {
		super(message);
	}

	}
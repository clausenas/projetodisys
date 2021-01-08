package br.com.projeto.service.exception;

public class RecursoInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoInexistenteException(String motivo) {
		super(motivo);
	}
}

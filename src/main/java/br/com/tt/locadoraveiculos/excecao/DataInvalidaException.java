package br.com.tt.locadoraveiculos.excecao;

public class DataInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataInvalidaException(String mensagem) {
		super(mensagem);
	}
}

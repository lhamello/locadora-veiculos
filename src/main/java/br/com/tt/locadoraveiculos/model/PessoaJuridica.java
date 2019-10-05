package br.com.tt.locadoraveiculos.model;

public class PessoaJuridica extends Cliente {

	private String cnpj;

	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return String.format("Cliente#PessoaJuridica[nome=%s,cnpj=%s]", nome, cnpj);
	}
}

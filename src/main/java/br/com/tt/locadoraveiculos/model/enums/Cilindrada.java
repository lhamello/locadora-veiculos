package br.com.tt.locadoraveiculos.model.enums;

public enum Cilindrada {

	CC125(1.25), CC250(1.50), CC500(1.75), CC1000(1.99);

	private Double valorKmRodado;

	private Cilindrada(Double valorKmRodado) {
		this.valorKmRodado = valorKmRodado;
	}

	public Double getValorKmRodado() {
		return valorKmRodado;
	}
}

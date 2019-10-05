package br.com.tt.locadoraveiculos.model.enums;

public enum TipoCarro {

	HATCH(2.19), SEDAN(2.37), SUV(2.54), PICKUP(2.71);

	private Double valorKmRodado;

	private TipoCarro(Double valorKmRodado) {
		this.valorKmRodado = valorKmRodado;
	}

	public Double getValorKmRodado() {
		return valorKmRodado;
	}
}

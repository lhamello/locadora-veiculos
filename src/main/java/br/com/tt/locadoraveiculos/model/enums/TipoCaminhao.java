package br.com.tt.locadoraveiculos.model.enums;

public enum TipoCaminhao {

	URBANO_CARGA(3.10), TRES_QUARTOS(3.20), SEMIPESADO(3.40), 
	PESADO(3.50), CARRETA(3.70), COMBINADO(3.90);

	private Double valorKmRodado;

	private TipoCaminhao(Double valorKmRodado) {
		this.valorKmRodado = valorKmRodado;
	}

	public Double getValorKmRodado() {
		return valorKmRodado;
	}
}

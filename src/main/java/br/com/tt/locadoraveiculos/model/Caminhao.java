package br.com.tt.locadoraveiculos.model;

import br.com.tt.locadoraveiculos.model.enums.Cambio;
import br.com.tt.locadoraveiculos.model.enums.TipoCaminhao;
import br.com.tt.locadoraveiculos.model.enums.TipoCombustivel;

public class Caminhao extends Veiculo {

	private TipoCaminhao tipo;
	private Cambio cambio;

	public Caminhao(String placa, String marca, String modelo, float quilometragem, TipoCombustivel tipoCombustivel,
			TipoCaminhao tipo, Cambio cambio) {
		// chamada para o construtor da classe pai
		super(placa, marca, modelo, quilometragem, tipoCombustivel);
		// atribuições da própria classe
		this.tipo = tipo;
		this.cambio = cambio;
	}

	@Override
	public Double getValorKmRodado() {
		return tipo.getValorKmRodado();
	}

	@Override
	public String toString() {
		return String.format(
				"Veiculo#Caminhao[placa=%s,marca=%s,modelo=%s,"
						+ "quilometragem=%.1f,tipoCombustivel=%s,tipo=%s,cambio=%s]",
				placa, marca, modelo, quilometragem, tipoCombustivel, tipo, cambio);
	}
}

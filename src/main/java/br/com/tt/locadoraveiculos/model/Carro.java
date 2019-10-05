package br.com.tt.locadoraveiculos.model;

import br.com.tt.locadoraveiculos.model.enums.Cambio;
import br.com.tt.locadoraveiculos.model.enums.NumeroPortas;
import br.com.tt.locadoraveiculos.model.enums.TipoCarro;
import br.com.tt.locadoraveiculos.model.enums.TipoCombustivel;

public class Carro extends Veiculo {

	private TipoCarro tipo;
	private Cambio cambio;
	private NumeroPortas numeroPortas;

	public Carro(String placa, String marca, String modelo, float quilometragem, TipoCombustivel tipoCombustivel,
			TipoCarro tipo, Cambio cambio, NumeroPortas numeroPortas) {
		// chamada para o construtor da classe pai
		super(placa, marca, modelo, quilometragem, tipoCombustivel);
		// atribuições da própria classe
		this.tipo = tipo;
		this.cambio = cambio;
		this.numeroPortas = numeroPortas;
	}

	@Override
	public Double getValorKmRodado() {
		return tipo.getValorKmRodado();
	}

	@Override
	public String toString() {
		return String.format(
				"Veiculo#Carro[placa=%s,marca=%s,modelo=%s,"
						+ "quilometragem=%.1f,tipoCombustivel=%s,tipo=%s,cambio=%s," + "numeroPortas=%s]",
				placa, marca, modelo, quilometragem, tipoCombustivel, tipo, cambio, numeroPortas);
	}
}

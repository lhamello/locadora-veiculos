package br.com.tt.locadoraveiculos.model;

import br.com.tt.locadoraveiculos.model.enums.Cilindrada;
import br.com.tt.locadoraveiculos.model.enums.TipoCombustivel;

public class Moto extends Veiculo {

	private Cilindrada cilindrada;

	public Moto(String placa, String marca, String modelo, float quilometragem, TipoCombustivel tipoCombustivel,
			Cilindrada cilindrada) {
		// chamada para o construtor da classe pai
		super(placa, marca, modelo, quilometragem, tipoCombustivel);
		// atribuições da própria classe
		this.cilindrada = cilindrada;
	}

	@Override
	public Double getValorKmRodado() {
		return cilindrada.getValorKmRodado();
	}

	@Override
	public String toString() {
		return String.format(
				"Veiculo#Moto[placa=%s,marca=%s,modelo=%s,quilometragem=%.1f," + "tipoCombustivel=%s,cilindrada=%s]",
				placa, marca, modelo, quilometragem, tipoCombustivel, cilindrada);
	}
}

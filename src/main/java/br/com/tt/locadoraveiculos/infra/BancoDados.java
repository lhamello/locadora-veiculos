package br.com.tt.locadoraveiculos.infra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import br.com.tt.locadoraveiculos.model.Caminhao;
import br.com.tt.locadoraveiculos.model.Carro;
import br.com.tt.locadoraveiculos.model.Moto;
import br.com.tt.locadoraveiculos.model.Veiculo;
import br.com.tt.locadoraveiculos.model.enums.Cambio;
import br.com.tt.locadoraveiculos.model.enums.Cilindrada;
import br.com.tt.locadoraveiculos.model.enums.NumeroPortas;
import br.com.tt.locadoraveiculos.model.enums.TipoCaminhao;
import br.com.tt.locadoraveiculos.model.enums.TipoCarro;
import br.com.tt.locadoraveiculos.model.enums.TipoCombustivel;

// Classe Singleton, que tem somente uma �nica inst�ncia.
// Representa o banco de dados em mem�ria de nossa aplica��o
public class BancoDados {

	// Singleton item 1
	// inst�ncia da pr�pria classe
	private static BancoDados unicaInstancia;
	private List<Veiculo> veiculos;

	// Singleton item 2
	// construtor privado, ningu�m deve instanci�-lo de
	// fora da pr�pria classe
	private BancoDados() {
		this.veiculos = new LinkedList<>(Arrays.asList(
		        new Carro("AAA1234", "PEUGEOT", "203", 0f, 
		        		TipoCombustivel.FLEX, TipoCarro.HATCH, 
		        		Cambio.MANUAL, NumeroPortas.QUATRO_PORTAS),
		        new Caminhao("AAA1235", "VOLVO", "V1", 0, 
		        		TipoCombustivel.DIESEL, TipoCaminhao.TRES_QUARTOS, 
		        		Cambio.AUTOMATICO),
		        new Moto("AAA1236", "Kawasaki", "Ninja", 0, 
		        		TipoCombustivel.GASOLINA, Cilindrada.CC1000)));
	}

	// Singleton item 3
	// M�todo respons�vel por instanciar e retornar
	// a inst�ncia �nica do singleton
	public static BancoDados getUnicaInstancia() {
		if (unicaInstancia == null) {
			unicaInstancia = new BancoDados();
		}

		return unicaInstancia;
	}

	public void incluirVeiculo(Veiculo veiculo) {
		veiculos.add(veiculo);
	}

	public List<Veiculo> listarTodosVeiculos() {
		return veiculos;
	}
}

package br.com.tt.locadoraveiculos.view;

import java.util.InputMismatchException;
import java.util.List;

import br.com.tt.locadoraveiculos.infra.BancoDados;
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
import br.com.tt.locadoraveiculos.model.enums.TipoVeiculo;

public class TelaVeiculo extends Tela {

	@Override
	public void apresentarTela() {
		do {
			this.imprimirMenu();
			int opcaoUsuario = super.solicitarOpcaoNumerica();

			switch (opcaoUsuario) {
			case 1:
				this.cadastrarVeiculo();
				break;
			case 2:
				this.listarVeiculos();
				break;
			case 0:
				System.out.println("   >>> Retornando ao Menu Principal... <<<");
				return;
			default:
				System.out.println("   >>> Opção inválida! Digite novamente. <<<");
				break;
			}
		} while (true);
	}
	private void cadastrarVeiculo() {
		TipoVeiculo tipoVeiculo = this.solicitarTipoVeiculo();
		String placa = this.solicitarPlaca();
		String marca = this.solicitarMarca();
		String modelo = this.solicitarModelo();
		Float quilometragem = this.solicitarQuilometragem();
		TipoCombustivel tipoCombustivel = this.solicitarTipoCombustivel();
		Veiculo veiculo;
		
		if (tipoVeiculo == TipoVeiculo.CARRO) {
			TipoCarro tipoCarro = this.solicitarTipoCarro();
			Cambio cambio = this.solicitarCambio();
			NumeroPortas numeroPortas = this.solicitarNumeroPortas();
			
			veiculo = new Carro(placa, marca, modelo, quilometragem, 
					tipoCombustivel, tipoCarro, cambio, numeroPortas);
		} else if (tipoVeiculo == TipoVeiculo.MOTO) {
			Cilindrada cilindrada = this.solicitarCilindrada();
			
			veiculo = new Moto(placa, marca, modelo, quilometragem, 
					tipoCombustivel, cilindrada);
		} else {
			TipoCaminhao tipoCaminhao = this.solicitarTipoCaminhao();
			Cambio cambio = this.solicitarCambio();
			
			veiculo = new Caminhao(placa, marca, modelo, quilometragem, 
					tipoCombustivel, tipoCaminhao, cambio);
		}
		
		BancoDados bancoDados = BancoDados.getUnicaInstancia();
		bancoDados.incluirVeiculo(veiculo);
		
		System.out.println("   >>> Veículo incluído com sucesso! <<<");
	}

	private TipoVeiculo solicitarTipoVeiculo() {
		TipoVeiculo tipoVeiculo;

		do {
			System.out.print("Digite o tipo de veículo [CAMINHAO], [CARRO] ou [MOTO]: ");
			String valorDigitado = super.solicitarTexto();

			try {
				tipoVeiculo = TipoVeiculo.valueOf(valorDigitado.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				tipoVeiculo = null;
				System.out.println("   >>> Opção inválida! <<<");
			}
		} while (tipoVeiculo == null);

		return tipoVeiculo;
	}

	private String solicitarPlaca() {
		System.out.print("Digite a placa: ");
		return super.solicitarTexto();
	}
	
	private String solicitarMarca() {
		System.out.print("Digite a marca: ");
		return super.solicitarTexto();
	}
	
	private String solicitarModelo() {
		System.out.print("Digite a modelo: ");
		return super.solicitarTexto();
	}
	
	private Float solicitarQuilometragem() {
		Float quilometragem;
		
		do {
			System.out.print("Digite a quilometragem: ");
			
			try {
				quilometragem = super.solicitarNumeroFloat();
			} catch (InputMismatchException excecao) {
				quilometragem = null;
				super.solicitarTexto();
				System.out.println("   >>> Quilometragem inválida! <<<");
			}
		} while (quilometragem == null);
		
		return quilometragem;
	}
	
	private TipoCombustivel solicitarTipoCombustivel() {
		TipoCombustivel tipoCombustivel;

		do {
			System.out.print("Digite o tipo de combustível [ALCOOL], [FLEX], [GASOLINA], [DIESEL] ou [GNV]: ");
			String valorDigitado = super.solicitarTexto();

			try {
				tipoCombustivel = TipoCombustivel.valueOf(valorDigitado.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				tipoCombustivel = null;
				System.out.println("   >>> Opção inválida! <<<");
			}
		} while (tipoCombustivel == null);

		return tipoCombustivel;
	}
	
	private TipoCarro solicitarTipoCarro() {
		TipoCarro tipoCarro;

		do {
			System.out.print("Digite o tipo de carro [HATCH], [SEDAN], [SUV], ou [PICKUP]: ");
			String valorDigitado = super.solicitarTexto();

			try {
				tipoCarro = TipoCarro.valueOf(valorDigitado.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				tipoCarro = null;
				System.out.println("   >>> Opção inválida! <<<");
			}
		} while (tipoCarro == null);

		return tipoCarro;
	}
	
	private Cambio solicitarCambio() {
		Cambio cambio;

		do {
			System.out.print("Digite o câmbio [AUTOMATICO], [MANUAL], ou [SEMIAUTOMATICO]: ");
			String valorDigitado = super.solicitarTexto();

			try {
				cambio = Cambio.valueOf(valorDigitado.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				cambio = null;
				System.out.println("   >>> Opção inválida! <<<");
			}
		} while (cambio == null);

		return cambio;
	}
	
	private NumeroPortas solicitarNumeroPortas() {
		NumeroPortas numeroPortas;

		do {
			System.out.print("Digite o número de portas [DUAS_PORTAS], ou [QUATRO_PORTAS]: ");
			String valorDigitado = super.solicitarTexto();

			try {
				numeroPortas = NumeroPortas.valueOf(valorDigitado.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				numeroPortas = null;
				System.out.println("   >>> Opção inválida! <<<");
			}
		} while (numeroPortas == null);

		return numeroPortas;
	}
	
	private Cilindrada solicitarCilindrada() {
		Cilindrada cilindrada;

		do {
			System.out.print("Digite as cilindradas [CC125], [CC250], [CC500] ou [CC1000]: ");
			String valorDigitado = super.solicitarTexto();

			try {
				cilindrada = Cilindrada.valueOf(valorDigitado.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				cilindrada = null;
				System.out.println("   >>> Opção inválida! <<<");
			}
		} while (cilindrada == null);

		return cilindrada;
	}
	
	private TipoCaminhao solicitarTipoCaminhao() {
		TipoCaminhao tipoCaminhao;

		do {
			System.out.print("Digite o tipo de caminhão [URBANO_CARGA], "
					+ "[TRES_QUARTOS], [SEMIPESADO], [PESADO], [CARRETA] "
					+ "ou [COMBINADO]: ");
			String valorDigitado = super.solicitarTexto();

			try {
				tipoCaminhao = TipoCaminhao.valueOf(valorDigitado.toUpperCase());
			} catch (IllegalArgumentException excecao) {
				tipoCaminhao = null;
				System.out.println("   >>> Opção inválida! <<<");
			}
		} while (tipoCaminhao == null);

		return tipoCaminhao;
	}
	
	private void listarVeiculos() {
		BancoDados bancoDados = BancoDados.getUnicaInstancia();
		List<Veiculo> veiculos = bancoDados.listarTodosVeiculos();
		
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo);
		}
	}
	
	private void imprimirMenu() {
		System.out.println();
		System.out.println("+============== MENU VEÍCULOS ==============+");
		System.out.println("|  Digite:                                  |");
		System.out.println("|   - [1] para Cadastrar Veículo            |");
		System.out.println("|   - [2] para Listar Veículos              |");
		System.out.println("|   - [0] para Retornar ao Menu Principal   |");
		System.out.println("+===========================================+");
	}
}

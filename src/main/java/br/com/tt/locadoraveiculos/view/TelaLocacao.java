package br.com.tt.locadoraveiculos.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;

import br.com.tt.locadoraveiculos.excecao.DataInvalidaException;
import br.com.tt.locadoraveiculos.infra.BancoDados;
import br.com.tt.locadoraveiculos.model.Cliente;
import br.com.tt.locadoraveiculos.model.Locacao;
import br.com.tt.locadoraveiculos.model.Veiculo;

public class TelaLocacao extends Tela {

	@Override
	public void apresentarTela() {
		do {
			this.imprimirMenu();
			int opcaoUsuario = super.solicitarOpcaoNumerica();

			switch (opcaoUsuario) {
			case 1:
				this.cadastrarLocacao();
				break;
			case 2:
				this.encerrarLocacao();
				break;
			case 3:
				this.listarLocacoes();
				break;
			case 0:
				System.out.println("   >>> Retornando ao Menu Principal... <<<");
				return;
			default:
				System.out.println("   >>> Op��o inv�lida! Digite novamente. <<<");
				break;
			}
		} while (true);
	}

	private void cadastrarLocacao() {
		Cliente cliente = this.solicitarCliente();
		Veiculo veiculo = this.solicitarVeiculo();
		LocalDate dataLocacao = this.solicitarDataLocacao();

		Locacao locacao = null;

		do {

			try {
				locacao = new Locacao(cliente, veiculo, dataLocacao);
			} catch (DataInvalidaException excecao) {
				System.out.println(excecao.getMessage());
				dataLocacao = this.solicitarDataLocacao();
			}
		} while (locacao == null);

		BancoDados bancoDados = BancoDados.getUnicaInstancia();
		bancoDados.adicionarLocacao(locacao);

		System.out.println("   >>> Loca��o adicionada com sucesso! <<<");
	}

	private Cliente solicitarCliente() {
		System.out.println("Clientes:");
		BancoDados bancoDados = BancoDados.getUnicaInstancia();
		List<Cliente> clientes = bancoDados.listarTodosClientes();

		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(String.format("   >>> [%d] --> %s", i, clientes.get(i)));
		}

		Cliente cliente = null;

		do {
			System.out.print("Digite o n�mero do cliente:");
			int numeroCliente = super.solicitarOpcaoNumerica();

			try {
				cliente = bancoDados.selecionarCliente(numeroCliente);
			} catch (IndexOutOfBoundsException excecao) {
				cliente = null;
				System.out.println("   >>> Op��o inv�lida! <<<");
			}
		} while (cliente == null);

		return cliente;
	}

	private Veiculo solicitarVeiculo() {
		System.out.println("Ve�culos:");
		BancoDados bancoDados = BancoDados.getUnicaInstancia();
		List<Veiculo> veiculos = bancoDados.listarTodosVeiculos();

		for (int i = 0; i < veiculos.size(); i++) {
			System.out.println(String.format("   >>> [%d] --> %s", i, veiculos.get(i)));
		}

		Veiculo veiculo = null;

		do {
			System.out.print("Digite o n�mero do ve�culo:");
			int numeroVeiculo = super.solicitarOpcaoNumerica();

			try {
				veiculo = bancoDados.selecionarVeiculo(numeroVeiculo);
			} catch (IndexOutOfBoundsException excecao) {
				veiculo = null;
				System.out.println("   >>> Op��o inv�lida! <<<");
			}
		} while (veiculo == null);

		return veiculo;
	}

	private LocalDate solicitarDataLocacao() {
		LocalDate dataLocacao = null;

		do {
			System.out.println("Digite a data da loca��o:");
			String dataDigitada = super.solicitarTexto();
			DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			try {
				dataLocacao = LocalDate.parse(dataDigitada, formatoData);
			} catch (DateTimeParseException excecao) {
				dataLocacao = null;
				System.out.println("   >>> Op��o inv�lida! <<<");
			}
		} while (dataLocacao == null);

		return dataLocacao;
	}

	private void encerrarLocacao() {
		Locacao locacao = this.selecionarLocacao();

		if (locacao == null) {
			System.out.println("   >>> N�o h� loca��es ativas! <<<");
		} else {
			Float quilometragemAtual = this.solicitarKmAtualVeiculo();
			locacao.encerrar(quilometragemAtual);

			System.out.println(String.format("   >>> Loca��o encerrada " 
					+ "com o valor de R$ %.2f. <<<", locacao.getValor()));
		}
	}

	private Locacao selecionarLocacao() {
		System.out.println("Loca��es:");
		BancoDados bancoDados = BancoDados.getUnicaInstancia();
		List<Locacao> locacoes = bancoDados.listarTodasLocacoes();
		boolean somenteLocacoesEncerradas = true;

		for (int i = 0; i < locacoes.size(); i++) {
			Locacao locacao = locacoes.get(i);

			if (locacao.isAtiva()) {
				somenteLocacoesEncerradas = false;
				System.out.println(String.format(" >>> [%d] --> %s", i, locacao));
			}
		}

		if (somenteLocacoesEncerradas) {
			return null;
		}

		Locacao locacao;

		do {
			System.out.print("Digite o n�mero da loca��o:");
			int numeroLocacao = super.solicitarOpcaoNumerica();

			try {
				locacao = bancoDados.selecionarLocacao(numeroLocacao);
			} catch (IndexOutOfBoundsException excecao) {
				locacao = null;
				System.out.println("   >>> Op��o inv�lida! <<<");
			}
		} while (locacao == null);

		return locacao;
	}

	private void listarLocacoes() {
		BancoDados bancoDados = BancoDados.getUnicaInstancia();

		for (Locacao locacao : bancoDados.listarTodasLocacoes()) {
			System.out.println(String.format("   >>> %s", locacao));
		}
	}

	private Float solicitarKmAtualVeiculo() {
		Float kmAtual = null;

		do {
			System.out.println("Digite a quilometragem atual do ve�culo:");

			try {
				kmAtual = super.solicitarNumeroFloat();
			} catch (InputMismatchException excecao) {
				kmAtual = null;
				System.out.println("   >>> N�mero inv�lido! <<<");
				super.solicitarTexto();
			}
		} while (kmAtual == null);

		return kmAtual;
	}

	private void imprimirMenu() {
		System.out.println();
		System.out.println("+============== MENU LOCA��ES ==============+");
		System.out.println("|  Digite:                                  |");
		System.out.println("|   - [1] para Cadastrar Loca��o            |");
		System.out.println("|   - [2] para Encerrar Loca��o             |");
		System.out.println("|   - [3] para Listar Loca��es              |");
		System.out.println("|   - [0] para Encerrar o Programa          |");
		System.out.println("+===========================================+");
	}
}

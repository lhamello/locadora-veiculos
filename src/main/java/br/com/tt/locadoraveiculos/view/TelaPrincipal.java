package br.com.tt.locadoraveiculos.view;

public class TelaPrincipal extends Tela {

	@Override
	public void apresentarTela() {
		do {
			this.imprimirMenu();
			int opcaoUsuario = super.solicitarOpcaoNumerica();
			Tela tela;
			
			switch (opcaoUsuario) {
			case 1:
				tela = new TelaVeiculo();
				tela.apresentarTela();
				break;
			case 2:
				tela = new TelaCliente();
				tela.apresentarTela();
				break;
			case 3:
				System.out.println("ir para Tela Loca��es");
				break;
			case 0:
				scanner.close();
				System.out.println("   >>> Encerrando programa... <<<");
				return;
			default:
				System.out.println("   >>> Op��o inv�lida! Digite novamente. <<<");
				break;
			}
		} while (true);
	}
	
	private void imprimirMenu() {
		System.out.println();
		System.out.println("+============= MENU PRINCIPAL =============+");
		System.out.println("|  Digite:                                 |");
		System.out.println("|   - [1] para apresentar Tela de Ve�culos |");
		System.out.println("|   - [2] para apresentar Tela de Clientes |");
		System.out.println("|   - [3] para apresentar Tela de Loca��es |");
		System.out.println("|   - [0] para Encerrar o Programa         |");
		System.out.println("+==========================================+");
	}
}

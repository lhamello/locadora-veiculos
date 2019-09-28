package br.com.tt.locadoraveiculos;

import br.com.tt.locadoraveiculos.view.Tela;
import br.com.tt.locadoraveiculos.view.TelaPrincipal;

public class LocadoraVeiculo {

	public static void main(String[] args) {
		Tela tela = new TelaPrincipal();
		tela.apresentarTela();
		System.out.println("   >>> Programa encerrado com sucesso! <<<");
	}
}

package br.com.tt.locadoraveiculos.view;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Tela {

	protected Scanner scanner;

	public Tela() {
		this.scanner = new Scanner(System.in);
	}
	
	public abstract void apresentarTela();
	
	protected int solicitarOpcaoNumerica() {
		int numero;
		
		try {
			numero = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		} catch (InputMismatchException excecao) {
			numero = -99999;
			scanner.nextLine();
		}
		
		return numero;
	}
	
	protected float solicitarNumeroFloat() {
		float numero = scanner.nextFloat();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		return numero;
	}
	
	protected double solicitarNumeroDouble() {
		// TODO:
		return 0;
	}
	
	protected String solicitarTexto() {
		return scanner.nextLine();
	}
	
	protected LocalDate solicitarData() {
		// TODO:
		return null;
	}
}

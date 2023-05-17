package model.view;

import java.text.DecimalFormat;
import java.util.Scanner;

import conversoes.Euro;
import conversoes.Libra;

public class MenuLibra {

	private static final int OPCAO_MENU_LIBRAparaREAL = 1;
	private static final int OPCAO_MENU_REALparaLIBRA = 2;
	
	Scanner teclado = new Scanner(System.in);
	
	// FORMATACAO DE RESULTADO
	DecimalFormat df = new DecimalFormat("0.00");
	
	// VALOR DA MOEDA MEDIANTE A ATUALIZAÇÂO
	double valorLibra = 6.33;
	int valorReal = 1;
	
	public void apresMenuLibr() {
		Libra libra = new Libra();
		System.out.println("---------------------------------------------");
	    System.out.println(OPCAO_MENU_LIBRAparaREAL + " - De Libra para Real                      |");
	    System.out.println(OPCAO_MENU_REALparaLIBRA + " - De Real para Libra                      |");
	    System.out.println("---------------------------------------------");
		System.out.print("Escolha uma opção: ");
		
		int opcao = teclado.nextInt();
		
		switch (opcao) {
		case OPCAO_MENU_LIBRAparaREAL: {
			System.out.println("---------------------------------------------");
			System.out.print("\nDigite o valor para conversão:  £ ");
			libra.setValor(teclado.nextDouble());
			double resultado = converterLibraParaReal(valorLibra, libra.getValor());
			System.out.println("\nValor informado =  £ " + libra.getValor());
			System.out.println("\nValor convertido = R$ " + df.format(resultado));
			Menu menu = new Menu();
			menu.apresentarMenuCompleto();
			break;
		}
		case OPCAO_MENU_REALparaLIBRA : {
			System.out.println("---------------------------------------------");
			System.out.print("\nDigite o valor para conversão: R$ ");
			libra.setValor(teclado.nextDouble());
			double resultado = converterRealParaLibra(valorLibra, libra.getValor());
			System.out.println("\nValor informado = R$ " + libra.getValor());
			System.out.println("\nValor convertido =  £ " + df.format(resultado));
			Menu menu = new Menu();
			menu.apresentarMenuCompleto();
			break;
		}			
		
	}
		
}

	public double converterLibraParaReal(double valorLibra, double valor) {
		double v = 0;
		
		v = valor * valorLibra;
		
		
		
		return v;
	}

	public double converterRealParaLibra(double valorLibra, double valor) {
		double v = 0;
		
		v = valor / valorLibra;
	
		return v;
	}
	
	
}

package model.view;

import java.text.DecimalFormat;
import java.util.Scanner;

import conversoes.Dollar;
import conversoes.Euro;
import model.dao.ConversoesDAO;

public class MenuEuro {

	private static final int OPCAO_MENU_EUROparaREAL = 1;
	private static final int OPCAO_MENU_REALparaEURO = 2;
	
	Scanner teclado = new Scanner(System.in);
	
	// FORMATACAO DE RESULTADO
	DecimalFormat df = new DecimalFormat("0.00");
	
	// VALOR DA MOEDA MEDIANTE A ATUALIZAÇÂO
	ConversoesDAO conversao = new ConversoesDAO();
	double valorEuro = conversao.valorDoEuroBanco();
	int valorReal = 1;
	
	public void apresMenuEur() {
		Euro euro = new Euro();
		System.out.println("---------------------------------------------");
	    System.out.println(OPCAO_MENU_EUROparaREAL + " - De Euro para Real                       |");
	    System.out.println(OPCAO_MENU_REALparaEURO + " - De Real para Euro                       |");
	    System.out.println("---------------------------------------------");
		System.out.print("Escolha uma opção: ");
		int opcao = teclado.nextInt();
		
		switch (opcao) {
		case OPCAO_MENU_EUROparaREAL: {
			System.out.println("---------------------------------------------");
			System.out.print("\nDigite o valor para conversão: Є ");
			euro.setValor(teclado.nextDouble());
			double resultado = converterEuroParaReal(valorEuro, euro.getValor());
			System.out.println("\nValor informado = Є " + euro.getValor());
			System.out.println("\nValor convertido = R$ " + df.format(resultado));
			Menu menu = new Menu();
			menu.apresentarMenuCompleto();
			break;
		}
		case OPCAO_MENU_REALparaEURO: {
			System.out.println("---------------------------------------------");
			System.out.print("\nDigite o valor para conversão: R$ ");
			euro.setValor(teclado.nextDouble());
			double resultado = converterRealParaEuro(valorEuro, euro.getValor());
			System.out.println("\nValor informado = R$ " + euro.getValor());
			System.out.println("\nValor convertido = Є " + df.format(resultado));
			Menu menu = new Menu();
			menu.apresentarMenuCompleto();
			break;
		}			
		
	}
		
}

	public double converterEuroParaReal(double valorEuro, double valor) {
		double v = 0;
		
		v = valor * valorEuro;
		
		
		
		return v;
	}

	public double converterRealParaEuro(double valorEuro, double valor) {
		double v = 0;
		
		v = valor / valorEuro;
	
		return v;
	}

}



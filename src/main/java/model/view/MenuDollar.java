package model.view;

import java.text.DecimalFormat;
import java.util.Scanner;

import conversoes.Dollar;
import model.dao.ConversoesDAO;

public class MenuDollar {
	
	private static final int OPCAO_MENU_REALparaDOLLAR = 2;
	private static final int OPCAO_MENU_DOLLARparaREAL = 1;
	
	Scanner teclado = new Scanner(System.in);
	
	// FORMATACAO DE RESULTADO
	DecimalFormat df = new DecimalFormat("0.00");
	
	// VALOR DA MOEDA MEDIANTE A ATUALIZAÇÂO
	ConversoesDAO conversao = new ConversoesDAO();
	double valorDolar = conversao.valorDoDolarBanco();
	int valorReal = 1;
	
	public void apresMenuDol() {
		Dollar dollar = new Dollar();
		System.out.println("---------------------------------------------");
	    System.out.println(OPCAO_MENU_REALparaDOLLAR + " - De Real para Dollar ");
	    System.out.println(OPCAO_MENU_DOLLARparaREAL + " - De Dólar para Real ");
	    System.out.println("---------------------------------------------");
		System.out.print("Escolha uma opção: ");
		int opcao = teclado.nextInt();
		
		switch (opcao) {
		case OPCAO_MENU_REALparaDOLLAR: {
			System.out.println("---------------------------------------------");
			System.out.print("\nDigite o valor para conversão: R$ ");
			dollar.setValor(teclado.nextDouble());
			double resultado = converterRealParaDollar(valorDolar, dollar.getValor());
			System.out.println("\nValor informado = R$ " + dollar.getValor());
			System.out.println("\nValor convertido = $ " + df.format(resultado));
			Menu menu = new Menu();
			menu.apresentarMenuCompleto();
			
			
			break;
		}
		case OPCAO_MENU_DOLLARparaREAL: {
			System.out.println("---------------------------------------------");
			System.out.print("\nDigite o valor para conversão: $ ");
			dollar.setValor(teclado.nextDouble());
			double resultado = converterDollarParaReal(valorDolar, dollar.getValor());
			System.out.println("\nValor informado = $ " + dollar.getValor());
			System.out.println("\nValor convertido = R$ " + df.format(resultado));
			Menu menu = new Menu();
			menu.apresentarMenuCompleto();
			break;
		}			
		
	}
		
}

	public double converterDollarParaReal(double valorDolar, double valor) {
		double v = 0;
		
		v = valor * valorDolar;
		
		
		
		return v;
	}

	public double converterRealParaDollar(double valorDolar, double valor) {
		double v = 0;
		
		v = valor / valorDolar;
	
		return v;
	}

}

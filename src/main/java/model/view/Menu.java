package model.view;

import java.util.Scanner;

public class Menu {

	private static final String OPCAO_MENU_DOLLAR = "Dolar";
	private static final String OPCAO_MENU_EURO = "Euro";
	private static final String OPCAO_MENU_LIBRA = "Libra";
	
	Scanner teclado = new Scanner(System.in);
	
	
	public void apresentarMenuCompleto() {
		
	
	String opcao = this.apresentarOpcoesConversao();


	  if (opcao.equalsIgnoreCase(OPCAO_MENU_DOLLAR)) {
		  MenuDollar menuDollar = new MenuDollar();
		  menuDollar.apresMenuDol();
	  }
	 if (opcao.equalsIgnoreCase(OPCAO_MENU_EURO)) { 
		  MenuEuro menuEuro = new MenuEuro();
		  menuEuro.apresMenuEur();
	  } if (opcao.equalsIgnoreCase(OPCAO_MENU_LIBRA)) {
		  MenuLibra menuLibra = new MenuLibra();
		  menuLibra.apresMenuLibr();
	  }  
  }
	
	
	private String apresentarOpcoesConversao() {
		String opcao = " ";
		
		System.out.println("----------------------------------------------");
		System.out.println("\nBem vindo! ");
		System.out.println("_________________ Conversão de Moeda __________");
		System.out.println("____ Menu _____________________________________\n");
		System.out.println(OPCAO_MENU_DOLLAR + " - Para Dólar"); 
		System.out.println(OPCAO_MENU_EURO + " - Para Euro");
		System.out.println(OPCAO_MENU_LIBRA + "- Para Libra");
		System.out.print("\nDigite uma opção: ");
		opcao = teclado.nextLine();
		
		return opcao;
	}
	
  }







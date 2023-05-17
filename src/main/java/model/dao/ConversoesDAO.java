package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConversoesDAO {

	public double valorDoEuroBanco() {
		double valor = 0;
		String moeda = "Euro";
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT valor "
				+ "FROM MOEDAS "
				+ "WHERE nome = '" + moeda +"'";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				valor = resultado.getDouble(1);
				
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método valorDoEuroBanco");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return valor;
	}

	public double valorDoDolarBanco() {
		double valor = 0;
		String moeda = "Dolar";
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT valor "
				+ "FROM MOEDAS "
				+ "WHERE nome = '" + moeda +"'";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				valor = resultado.getDouble(1);
				
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método valorDoDolarBanco");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return valor;
	}
	
	public double valorDaLibraBanco() {
		double valor = 0;
		String moeda = "Libra";
		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		
		String query = "SELECT valor "
				+ "FROM MOEDAS "
				+ "WHERE nome = '" + moeda +"'";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				valor = resultado.getDouble(1);
				
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query do método valorDaLibraBanco");
			System.out.println("Erro: " + erro.getMessage());
		}finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return valor;
	}

}

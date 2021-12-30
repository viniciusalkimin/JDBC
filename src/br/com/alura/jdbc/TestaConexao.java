package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
//		
//		Connection con = DriverManager
//				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC","root","Vga0302!");

		ConnectionFactory connectionFactory = new ConnectionFactory();

		System.out.println("Conexão aberta");
		Connection con = connectionFactory.recuperarConexao();

		con.close();
		System.out.println("Conexão fechada ");

	}

}

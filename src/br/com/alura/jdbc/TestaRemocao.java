package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 31);
		stm.execute();

		Integer linhasmodif = stm.getUpdateCount();

//		Integer linhaModif = stm.getUpdateCount();

//		Statement stm = connection.createStatement();
//		stm.execute("DELETE FROM PRODUTO WHERE ID > 4");//		

		System.out.println("Quantidade de linhas modificadas: " + linhasmodif);

		connection.close();
	}

}

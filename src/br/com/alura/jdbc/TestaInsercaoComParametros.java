package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametros {

	public static void main(String[] args) throws SQLException {

//		String nome = "MICROFONE'";
//		String descricao = "MICROFONE PROFISSIONAL SENNHEISER; DELETE FROM PRODUTO;";

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao()) {
			connection.setAutoCommit(false);
//		
//		Statement stm = connection.createStatement();
//		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES (' " + nome + " ','" + descricao + "')", Statement.RETURN_GENERATED_KEYS);

			try (PreparedStatement stm = connection.prepareStatement(
					"INSERT INTO PRODUTOS (nome,descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);) {
				addVariavel("ESTANTE", "ESTANTE LIVREIRO", stm);
				addVariavel("MESA", "MESA DE ESCRITORIO PRETA", stm);

				connection.commit();
				stm.close();
			} // catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("ROLLBACK EXECUTADO");
//				connection.rollback();
//			}
		}
	}

	private static void addVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
//		if (nome.equals("MESA")) {
//			throw new RuntimeException("Não foi possível adicionar o item");
//		}
		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("ID criado: " + id);
			}
		}

	}
}
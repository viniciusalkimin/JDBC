package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto prod = new Produto("MOUSEPAD", "MOUSEPAD GAMER");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			
			ProdutoDAO produtoDAO =  new ProdutoDAO(connection);
			produtoDAO.salvar(prod);
			List<Produto> produtos = produtoDAO.listar();
			produtos.stream().forEach(prodList -> System.out.println(prodList));

//			try (PreparedStatement stm = connection.prepareStatement(
//					"INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS)) {
//				stm.setString(1, prod.getNome());
//				stm.setString(2, prod.getDescricao());
//				stm.execute();
//
//				try (ResultSet rst = stm.getResultSet()) {
//					while (rst.next()) {
//						prod.setId(rst.getInt(1));
//					}
//				}
//			}
		}

		System.out.println(prod);
	}

}

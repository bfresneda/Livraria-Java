package tabelasDB;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class CriarTabelaLivros {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = ConnectionFactory.getConexao();
		
		String sql = "CREATE TABLE TB_LIVROS("
				+ "IDLIVRO INT NOT NULL AUTO_INCREMENT,"
				+ "TITULO VARCHAR(100),"
				+ "PRECO FLOAT,"
				+ "ESTOQUE INT,"
				+ "FK_IDGENERO INT NOT NULL,"
				+ "PRIMARY KEY(IDLIVRO));";
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso!");
		conexao.close();
		
		
	}

}

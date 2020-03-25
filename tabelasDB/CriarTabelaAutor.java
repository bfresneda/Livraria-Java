package tabelasDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class CriarTabelaAutor {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = ConnectionFactory.getConexao();
		
		String sql = "CREATE TABLE TB_AUTOR("
				+ "IDAUTOR INT NOT NULL AUTO_INCREMENT,"
				+ "NOME VARCHAR(100),"
				+ "EMAIL VARCHAR(100),"
				+ "PRIMARY KEY(IDAUTOR));";
				
				
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso!");
		conexao.close();
		
		
	}

}

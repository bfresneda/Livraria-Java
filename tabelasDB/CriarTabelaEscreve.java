package tabelasDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class CriarTabelaEscreve {

	public static void main(String[] args) throws SQLException{

		Connection conexao = ConnectionFactory.getConexao();
		
		String sql = "CREATE TABLE TB_ESCREVE("
				+ "IDLIVRO INT NOT NULL AUTO_INCREMENT,"
				+ "FK_IDAUTOR INT NOT NULL,"
				+ "PRIMARY KEY(IDLIVRO));";
				
				
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso!");
		conexao.close();		
	}

}

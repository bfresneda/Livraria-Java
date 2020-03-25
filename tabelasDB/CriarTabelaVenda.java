package tabelasDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class CriarTabelaVenda {

	public static void main(String[] args) throws SQLException {

	Connection conexao = ConnectionFactory.getConexao();
	
	String sql = "CREATE TABLE TB_VENDA("
			+ "IDVENDA INT NOT NULL AUTO_INCREMENT,"
			+ "DATA DATE,"
			+ "TOTAL FLOAT,"
			+ "FK_IDCLIENTE INT NOT NULL,"
			+ "PRIMARY KEY(IDVENDA));";
	
	Statement stmt = conexao.createStatement();
	stmt.execute(sql);
	
	System.out.println("Tabela criada com sucesso!");
	conexao.close();
	
	
	

	}

}

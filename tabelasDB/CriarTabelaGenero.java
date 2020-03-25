package tabelasDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class CriarTabelaGenero {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = ConnectionFactory.getConexao();
		
		String sql = "CREATE TABLE TB_GENERO ("
				+ "IDGENERO INT NOT NULL AUTO_INCREMENT,"
				+ "DESCRICAO VARCHAR(100) NOT NULL,"
				+ "PRIMARY KEY(IDGENERO)"
				+ ");";
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso!");
		conexao.close();
		
		
		
	}
	
	
//	create table tb_genero(
//			idgenero INT NOT NULL AUTO_INCREMENT,
//			descricao VARCHAR(100) NOT NULL,
//			PRIMARY KEY(idgenero));

	
}

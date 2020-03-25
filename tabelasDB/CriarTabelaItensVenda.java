package tabelasDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class CriarTabelaItensVenda {

	public static void main(String[] args) throws SQLException {
		
		Connection conexao = ConnectionFactory.getConexao();
		
		String sql = "CREATE TABLE TB_ITENS_DA_VENDA("
				+ "QUANTIDADE INT,"
				+ "SUBTOTAL FLOAT,"
				+ "FK_IDVENDA INT NOT NULL,"
				+ "FK_IDLIVRO INT NOT NULL);";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso!");
		conexao.close();
		
		

	}

}

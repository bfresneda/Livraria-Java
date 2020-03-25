package tabelasDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class CriarForeignKey {

	public static void main(String[] args) throws SQLException{
		
		Connection conexao = ConnectionFactory.getConexao();
		String sql = "ALTER TABLE tb_livros ADD FOREIGN KEY (fk_idgenero) REFERENCES tb_genero(idgenero);"
				+ "ALTER TABLE tb_itens_da_venda ADD FOREIGN KEY (fk_idvenda) REFERENCES tb_venda(idvenda);"
				+ "ALTER TABLE tb_itens_da_venda ADD FOREIGN KEY (fk_idlivro) REFERENCES tb_livros(idlivro);"
				+ "ALTER TABLE tb_escreve ADD FOREIGN KEY (fk_idautor) REFERENCES tb_autor(idautor);"
				+ "ALTER TABLE tb_venda ADD FOREIGN KEY (fk_idcliente) REFERENCES tb_cliente(idcliente);";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Foreign keys criadas com sucesso!");
		conexao.close();
	}

}

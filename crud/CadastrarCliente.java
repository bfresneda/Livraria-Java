package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.ConnectionFactory;

public class CadastrarCliente {

	public static void main(String[] args) throws SQLException{

		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o nome do cliente: ");
		String nome = entrada.nextLine();
		System.out.print("Informe o telefone: ");
		String telefone = entrada.nextLine();
		
		Connection conexao = ConnectionFactory.getConexao();
		
		String sql = "INSERT INTO TB_CLIENTE(NOME, TELEFONE) VALUES (?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setString(2, telefone);
		
		stmt.execute();
		
		
		conexao.close();
				
		System.out.println("Cliente incluido com sucesso!");

		entrada.close();
	}

}

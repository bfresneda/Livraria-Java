package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.ConnectionFactory;

public class CadastrarGenero {

	public static void main(String[] args) throws SQLException{
		
		Scanner entrada = new Scanner(System.in);
		String descricao ="";
		
		while(!descricao.equals("0")) {
		System.out.print("Informe a descricao do genero: ");
		descricao = entrada.nextLine();
		
		Connection conexao = ConnectionFactory.getConexao();
		
		String sql = "INSERT INTO TB_GENERO(descricao) VALUES (?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, descricao);

		
		stmt.execute();
				conexao.close();
				
		System.out.println("Genero incluido com sucesso!");	
		System.out.println("Para sair do sistema digite 0(zero)");
		
	}

		entrada.close();

	}

}

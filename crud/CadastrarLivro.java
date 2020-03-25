package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.ConnectionFactory;
import model.Genero;

public class CadastrarLivro {

public void cadastrarLivro(Scanner entrada) throws SQLException{
		
		Connection conexao = ConnectionFactory.getConexao();
		
		String titulo ="";
		
		System.out.print("Informe o Titulo do livro: ");
		titulo = entrada.nextLine();
		System.out.print("Informe o preço do livro:R$");
		float preco = entrada.nextFloat();
		System.out.print("Informe a quantidade do estoque: ");
		int estoque = entrada.nextInt();
		String select = "SELECT * FROM TB_GENERO";
		PreparedStatement stmt = conexao.prepareStatement(select);
		ResultSet resultado = stmt.executeQuery();
		
		List<Genero> Generos = new ArrayList<>();
		
		while(resultado.next()) {
			int idGenero = resultado.getInt("idgenero");
			String descricao = resultado.getString("descricao");			
			Generos.add(new Genero(idGenero,descricao));
		}
		
		for(Genero g: Generos) {
		System.out.printf("ID %d |", g.getIdGenero(),g.getDescricao()) ;
		System.out.println();
		};		
			
		System.out.print("Informe o codigo do Genero: ");
		int idgenero = entrada.nextInt();	
		
		String sql = "INSERT INTO TB_LIVROS(TITULO,PRECO,ESTOQUE,FK_IDGENERO) VALUES (?,?,?,?)";
		PreparedStatement stmt1 = conexao.prepareStatement(sql);
		stmt1.setString(1, titulo);
		stmt1.setFloat(2, preco);
		stmt1.setInt(3, estoque);
		stmt1.setInt(4, idgenero);

		
		stmt1.execute();
		conexao.close();
				
		System.out.println("Livro incluido com sucesso!");	
	}	
}

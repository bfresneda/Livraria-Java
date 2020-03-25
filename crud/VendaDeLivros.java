package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import connection.ConnectionFactory;
import model.Cliente;
import model.Livro;

public class VendaDeLivros {

	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
		
		Livro livro1 = new Livro();
		Cliente cliente1 = new Cliente();
		
		Connection conexao = ConnectionFactory.getConexao();
		
		/////////////////////////////////////////////////
		//      CONSULTA O LIVRO A QUE SERA VENDIDO    //
		/////////////////////////////////////////////////
		
		livro1.consultarLivro(entrada);
		
		System.out.println("---------------------------------------------------");
		
		////////////////////////////////////////////////////////
		//      ADICIONA O CLIENTE QUE VAI COMPRAR O LIVRO    //
		////////////////////////////////////////////////////////
		
		
		cliente1.clienteSelecionado(entrada);
		

		System.out.println("---------------------------------------------------");

		
		////////////////////////////////////////////////////////
		//      	CALCULO DOS PRODUTOS COMPRADOS		      //
		////////////////////////////////////////////////////////
			
		
		System.out.print("Digite a quantidade de livros: ");
		int quantidade = entrada.nextInt();
		
		float totalVenda = livro1.getPreco() * quantidade;
		int estoqueFinal = livro1.getEstoque() - quantidade;
		

		
		String insert = "INSERT INTO TB_VENDA(DATA,TOTAL,FK_IDCLIENTE) VALUES (SYSDATE,?,?) ";				
		PreparedStatement stmt = conexao.prepareStatement(insert);
		stmt.setFloat(1, totalVenda);
		stmt.setInt(2, cliente1.getIdCliente());
		stmt.execute();
		stmt.close();
		
		String insert2 = "UPDATE TB_LIVROS SET ESTOQUE = ? where idLivro = ?";
		PreparedStatement stmt2 = conexao.prepareStatement(insert2);
		stmt2.setFloat(1, estoqueFinal);
		stmt2.setInt(2, livro1.getIdLivro());
		stmt2.execute();
		stmt2.close();
		
		String select = "SELECT IDVENDA FROM TB_CLIENTE AS TB JOIN TB_VENDA AS TC ON " 
					   +" IDCLIENTE = FK_IDCLIENTE"
					   + " WHERE IDCLIENTE = ?"
					   + " AND TOTAL = ?";
		PreparedStatement stmt3 = conexao.prepareStatement(select);
		stmt3.setInt(1, cliente1.getIdCliente());
		stmt3.setDouble(2, totalVenda );
		ResultSet resultado = stmt3.executeQuery();
		
		int idVendaPk = resultado.getInt("idVenda");
		
		stmt3.close();
		
		
		
		
		System.out.printf("resultado idvenda",idVendaPk);
		
		
		System.out.println();
		
		
		
		
		
		entrada.close();
		
		
		
		
		
		
		
		
		
		
//		
//		
//		System.out.println("Livro escolhilho");
//		System.out.printf("%d | %s ", livro1.getIdLivro(), livro1.getTitulo());
//		System.out.println("-------------------------------------------------");
//		System.out.println("Cliente selecionado");
//		System.out.printf("%d | %s", cliente1.getIdCliente() , cliente1.getNome());
//		
//		
//		String sql = "INSERT INTO TESTE(IDLIVRO,TITULO,IDCLIENTE,NOME) VALUES (?,?,?,?)";
//		PreparedStatement stmt = conexao.prepareStatement(sql);
//		stmt.setInt(1, livro1.getIdLivro());
//		stmt.setString(2, livro1.getTitulo());
//		stmt.setInt(3, cliente1.getIdCliente());
//		stmt.setString(4, cliente1.getNome());
//		
//		stmt.execute();	
//		
//		stmt.close();
//		conexao.close();
//				
//		System.out.println("Dados inseridos com sucesso!");
//		
//		
//		
//		
//		
//		
		
		
		
		
		
		conexao.close();	
		entrada.close();
		
		}
}
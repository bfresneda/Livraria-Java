package crud;

import java.sql.SQLException;
import java.util.Scanner;

import model.Cliente;
import model.Livro;

public class SistemaLivraria {
	
		static Scanner entrada = new Scanner(System.in);

		
		public static void main(String[] args) throws SQLException {

			menuNavegacao();
			entrada.close();
		}

		private static void menuNavegacao() throws SQLException {
	
		Livro livro1 = new Livro();
		Cliente cliente1 = new Cliente();
		CadastrarLivro cadastroLivro = new CadastrarLivro(); 

		System.out.print("--------------------L I V R A R I A   V I R T U A L   Q I N T E S S---------------------\n"
				+ "1 - Consultar livro \n2 - Cadastrar novo cliente \n3 - Cadastrar novo livro \nEscolha uma das opcoes:");

		String escolha = entrada.nextLine();
		String continuar = "s";
		
		System.out.println("----------------------------------------------------------------------------------------");

		switch (escolha) {
		case "1": {
			while (continuar.equalsIgnoreCase("s")) { 
				livro1.consultarLivro(entrada);
				System.out.print("Deseja procurar outro livro (s/n):");
				continuar = entrada.nextLine();}						
				menuNavegacao();
				break;
		}
	
		case "2": {
			while(continuar.equalsIgnoreCase("s")) {
				cliente1.cadastrarCliente(entrada);
				System.out.print("Deseja adicionar outro cliente (s/n):");
				continuar = entrada.nextLine();}
				menuNavegacao();
				break;
		}
		
		case "3":{
			while(continuar.equalsIgnoreCase("s")) {
				cadastroLivro.cadastrarLivro(entrada);
				System.out.print("Deseja cadastrar outro livro (s/n)");
				continuar = entrada.nextLine();}
				menuNavegacao();
				break;
			}
			
			
		}
		
		
		
		
		}
	}


//		Connection conexao = ConnectionFactory.getConexao();
//		
//		System.out.print("Digite o nome do Livro que deseja procurar: ");
//		String nomeLivro = entrada.nextLine();
//		
//		String sql = "SELECT * FROM TB_LIVROS WHERE lower(TITULO) LIKE ? ";
//		
//		PreparedStatement stmt = conexao.prepareStatement(sql);
//		stmt.setString(1, "%" + nomeLivro + "%");
//		ResultSet resultado = stmt.executeQuery();
//		
//		List<Livro> livros = new ArrayList<>();
//		
//		while(resultado.next()) {
//			int idLivro = resultado.getInt("idlivro");
//			String titulo = resultado.getString("titulo");
//			float preco = resultado.getFloat("preco");
//			int estoque = resultado.getInt("estoque");
//			int fkIdGenero = resultado.getInt("fk_idgenero");
//			
//			livros.add(new Livro(idLivro, titulo, preco, estoque, fkIdGenero));
//		}
//		
//		for(Livro l: livros) {
//		System.out.printf("ID %d | Titulo %s | Preço %.2f | Estoque %d | Genero %d",
//				l.getIdLivro(),l.getTitulo(),l.getPreco(), l.getEstoque(), l.getFkIdGenero());
//		System.out.println();
//		}		
//		stmt.close();
//		conexao.close();		

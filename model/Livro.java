package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.ConnectionFactory;

public class Livro {
	
	private int idLivro;
	private String titulo;
	private float preco;
	private int estoque;
	private int fkIdGenero;
	
	
	
	public Livro(int idLivro, String titulo, float preco, int estoque, int fkIdGenero) {
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.preco = preco;
		this.estoque = estoque;
		this.setFkIdGenero(fkIdGenero);
	}
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public void consultarLivro(Scanner entrada) throws SQLException {
	Connection conexao = ConnectionFactory.getConexao();
	
	System.out.print("Digite o nome do Livro que deseja procurar: ");
	String nomeLivro = entrada.nextLine();
	
	String sql = "SELECT * FROM TB_LIVROS WHERE lower(TITULO) LIKE ? ";
	
	PreparedStatement stmt = conexao.prepareStatement(sql);
	stmt.setString(1, "%" + nomeLivro + "%");
	ResultSet resultado = stmt.executeQuery();
	
	List<Livro> livros = new ArrayList<>();
	
	while(resultado.next()) {
		int idLivro = resultado.getInt("idlivro");
		String titulo = resultado.getString("titulo");
		float preco = resultado.getFloat("preco");
		int estoque = resultado.getInt("estoque");
		int fkIdGenero = resultado.getInt("fk_idgenero");
		
		livros.add(new Livro(idLivro, titulo, preco, estoque, fkIdGenero));
		
		this.idLivro = idLivro;
		this.titulo = titulo;	
		this.preco = preco;
		this.estoque = estoque;
	}
	
	
	
	for(Livro l: livros) {
	System.out.printf("ID %d | Titulo %s | Preço %.2f | Estoque %d | Genero %d",
			l.getIdLivro(),l.getTitulo(),l.getPreco(), l.getEstoque(), l.getFkIdGenero());
	System.out.println();
	
	}		
	stmt.close();
	conexao.close();		
	}
	

	public void RetirarEstoque(int quantidade) {
		estoque -= quantidade;
	}
	
	
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getFkIdGenero() {
		return fkIdGenero;
	}

	public void setFkIdGenero(int fkIdGenero) {
		this.fkIdGenero = fkIdGenero;
	}
	

	

	
	
	
	
}

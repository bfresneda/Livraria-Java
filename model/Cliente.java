package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.ConnectionFactory;

public class Cliente {
	
	private int idCliente;
	private String nome;
	private String telefone;

		
	public Cliente(){};
	
	
	
	public Cliente(int idcliente, String nome) {
		this.idCliente = idcliente;
		this.nome = nome;
	}


	public void cadastrarCliente(Scanner entrada) throws SQLException {

		Connection conexao = ConnectionFactory.getConexao();
		
		System.out.print("Informe o nome do cliente: ");
		String nome = entrada.nextLine();
		System.out.print("Informe o telefone: ");
		String telefone = entrada.nextLine();
		
		
		String sql = "INSERT INTO TB_CLIENTE(NOME, TELEFONE) VALUES (?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setString(2, telefone);
		stmt.execute();	
		
		stmt.close();
		conexao.close();
				
		System.out.println("Cliente incluido com sucesso!");

	}
	
	
	public void clienteSelecionado(Scanner entrada) throws SQLException {
		
	Connection conexao = ConnectionFactory.getConexao();	
		
	System.out.print("Digite o codigo do cliente ");
	String idCliente = entrada.nextLine();
	
	String sql = "SELECT * FROM TB_CLIENTE WHERE idcliente = ? ";
	
	PreparedStatement stmt = conexao.prepareStatement(sql);
	stmt.setString(1, idCliente);
	ResultSet resultado = stmt.executeQuery();
	
	
	List<Cliente> Clientes = new ArrayList<>();
	
	while(resultado.next()) {
		int idcliente = resultado.getInt("idcliente");
		String nome = resultado.getString("nome");
		
		Clientes.add(new Cliente(idcliente, nome));
		this.idCliente = idcliente;
		this.nome = nome;
	}
	
//	for(Cliente c: Clientes) {
//	System.out.printf("ID %d | nome %s",c.getIdCliente(), c.getNome());
//	System.out.println();

	stmt.close();
	
	}	

	
	
	
	
	public int getIdCliente() {
		return idCliente;
	}
	
	
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public String getTelefone() {
		return telefone;
	}
	
	
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}

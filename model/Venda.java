package model;

import java.time.LocalDate;

public class Venda {

	int idVenda;
	LocalDate data;
	float total;
	Cliente cliente;
	
	
	Venda(){
	};
	

	public Venda(int idVenda){
		this.idVenda = idVenda;
	};
	
	Venda(int idVenda, LocalDate data, float total, Cliente cliente){
		this.idVenda = idVenda;
		this.data = data;
		this.total = total;
		this.cliente = cliente;
	};
}

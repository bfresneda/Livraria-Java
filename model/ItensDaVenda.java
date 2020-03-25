package model;

public class ItensDaVenda {
	
	int quantidade;
	float subTotal;
	Venda venda;
	Livro livro;
	
	ItensDaVenda(){};
	
	
	public void Vender(float subTotal) {
		subTotal = quantidade * livro.getPreco();		
	}
	
	
	

}

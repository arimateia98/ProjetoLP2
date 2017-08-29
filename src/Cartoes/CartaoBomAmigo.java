package Cartoes;

import java.io.Serializable;

public class CartaoBomAmigo implements Cartao, Serializable{

	@Override
	public int diasPermitidos() {
		return 14;
	}
	
	@Override
	public String toString() {
		return "BomAmigo";
	}

}

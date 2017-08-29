package Cartoes;

import java.io.Serializable;

public class CartaoFreeRyder implements Cartao, Serializable{

	@Override
	public int diasPermitidos() {
		return 5;
	}
	
	@Override
	public String toString() {
		return "FreeRyder";
	}
	

}

package Cartoes;

public class CartaoFreeRyder implements Cartao{

	@Override
	public int diasPermitidos() {
		return 5;
	}
	
	@Override
	public String toString() {
		return "FreeRyder";
	}
	

}

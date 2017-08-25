package Cartoes;

public class CartaoNoob implements Cartao{

	@Override
	public int diasPermitidos() {
		return 7;
	}
	
	@Override
	public String toString(){
		return "Noob";
	}

}

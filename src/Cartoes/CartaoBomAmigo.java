package Cartoes;

public class CartaoBomAmigo implements Cartao{

	@Override
	public int diasPermitidos() {
		return 14;
	}
	
	@Override
	public String toString() {
		return "BomAmigo";
	}

}

package Cartoes;

public class CartaoCaloteiro implements Cartao{

	@Override
	public int diasPermitidos() {
		throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
	}
	
	@Override
	public String toString(){
		return "Caloteiro";
	}

}

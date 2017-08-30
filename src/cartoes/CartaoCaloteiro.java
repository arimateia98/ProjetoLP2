package cartoes;

import java.io.Serializable;

public class CartaoCaloteiro implements Cartao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int diasPermitidos() {
		throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
	}
	
	@Override
	public String toString(){
		return "Caloteiro";
	}

}

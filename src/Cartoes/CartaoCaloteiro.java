package Cartoes;

import java.io.Serializable;

public class CartaoCaloteiro implements Cartao, Serializable{

	@Override
	public int diasPermitidos() {
		throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
	}
	
	@Override
	public String toString(){
		return "Caloteiro";
	}

}

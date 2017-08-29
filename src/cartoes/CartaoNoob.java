package cartoes;

import java.io.Serializable;

public class CartaoNoob implements Cartao, Serializable{

	@Override
	public int diasPermitidos() {
		return 7;
	}
	
	@Override
	public String toString(){
		return "Noob";
	}

}

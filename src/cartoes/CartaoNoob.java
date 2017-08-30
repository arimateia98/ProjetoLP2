package cartoes;

import java.io.Serializable;

public class CartaoNoob implements Cartao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int diasPermitidos() {
		return 7;
	}
	
	@Override
	public String toString(){
		return "Noob";
	}

}

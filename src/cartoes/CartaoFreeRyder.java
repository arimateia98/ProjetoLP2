package cartoes;

import java.io.Serializable;

public class CartaoFreeRyder implements Cartao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int diasPermitidos() {
		return 5;
	}
	
	@Override
	public String toString() {
		return "FreeRyder";
	}
	

}
